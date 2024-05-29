package compagnieDeVoyage;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MauvaisFormatException, ValeurNulleException {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        menu.menuPrincipal(scan);
        scan.close();




    }
}
