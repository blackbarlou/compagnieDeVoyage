package compagnieDeVoyage;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MauvaisFormatException, ValeurNulleException {

        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        menu.menuPrincipal(scan);

    }
}
