package Principales;

public class Historial {
    private String transaccion;
    private double dinero;
    private Clientes cliente1;
    private Clientes cliente2;
    private int id;

    public Historial(String transaccion, double dinero, Clientes cliente1,Clientes cliente2,int id) {
        this.setTransaccion(transaccion);
        this.setDinero(dinero);
        this.setCliente1(cliente1);
        this.setCliente2(cliente2);
        this.setId(id);
    }

    public String getTransaccion() {
        return transaccion;
    }
    public double getDinero() {
        return dinero;
    }
    public Clientes getCliente1() {
        return cliente1;
    }
    public Clientes getCliente2() {
        return cliente2;
    }
    public int getId() {
        return id;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    public void setCliente1(Clientes cliente1) {
        this.cliente1 = cliente1;
    }
    public void setCliente2(Clientes cliente2) {
        this.cliente2 = cliente2;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String formato = "***************************************\n" + "ID Transacción: %d\n" + "Tipo: %s\n" +  "Monto: $%.6f\n" +  "Cliente: %s %s\n";
        if (cliente2 != null) {
            formato += "Destinatario: %s %s\n";
            return String.format(formato + "***************************************\n", id, transaccion, dinero, cliente1.getNombres(), cliente1.getApellidos(), cliente2.getNombres(), cliente2.getApellidos());
        } else {
            return String.format(formato + "***************************************\n", id, transaccion, dinero, cliente1.getNombres(), cliente1.getApellidos() );
        }
    }
}
