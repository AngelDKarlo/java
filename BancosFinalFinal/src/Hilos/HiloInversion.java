package Hilos;

import Auxiliares.Enums.EstadoInversion;
import Gestores.GestorInverciones;
import Principales.Inversion;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class HiloInversion extends Thread {
    private volatile boolean corriendo = true;
    private final List<Inversion> inversiones;
    private final long intervalo;


    public HiloInversion(List<Inversion> inversiones) {
        this(inversiones, 10000);
    }

    public HiloInversion(List<Inversion> inversiones, long intervalo) {
        this.inversiones = new CopyOnWriteArrayList<>(inversiones);
        this.intervalo = intervalo;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (corriendo && !Thread.currentThread().isInterrupted()) {
            try {
                if (!inversiones.isEmpty()) {
                    for (Inversion inversion : inversiones) {
                        if (!corriendo) break;
                        if(inversion.getEstadoInversion() == EstadoInversion.Acabada){
                            continue;
                        }
                        else {
                            synchronized (inversion){
                                if (!corriendo) break;
                                GestorInverciones.calcularInversiones(inversion);
                            }
                        }
                    }
                }
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void detener() {
        corriendo = false;
        this.interrupt();
    }

    public void agregarInversion(Inversion inversion) {
        inversiones.add(inversion);
    }

    public void quitarInversion(Inversion inversion) {
        inversiones.remove(inversion);
    }


    public boolean getCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public List<Inversion> getInversiones() {
        return new CopyOnWriteArrayList<>(inversiones);
    }
}
