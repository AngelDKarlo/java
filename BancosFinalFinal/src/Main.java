import Menus.MenuPrincipal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        Scanner sc = new Scanner(System.in);

        System.out.println("**********************");
        System.out.println("*       Banco        *");
        System.out.println("**********************");
        System.out.println("*                    *");
        System.out.println("*       * * *        *");
        System.out.println("*       *   *        *");
        System.out.println("*       *   *        *");
        System.out.println("**********************");
        sc.nextLine();

        menu.menuP();
    }
}