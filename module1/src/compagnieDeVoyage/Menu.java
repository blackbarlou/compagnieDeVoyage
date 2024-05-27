package compagnieDeVoyage;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cette classe represente le menu de notre code nous allons implementer ici la liste des methodes relatives aux menus et sous-menus
 */
public class Menu {
    private Compagnie compagnie = new Compagnie();
    private Scanner scan = new Scanner(System.in);


    public void afficherMenu() {
        System.out.println("Menu");
        System.out.println("Tapez 1 : pour ajouter un trajet/chauffeur/bus");
        System.out.println("Tapez 2 : pour effectuer une reservation");
        System.out.println("Tapez 3 : pour trouver la liste des bus conduit par un chauffeur");
        System.out.println("Tapez 4 : pour les caracteristiques de tous les bus et trajets");
        System.out.println("Tapez 0 : pour quitter");
    }

    public void menuPrincipal( Scanner scan) throws MauvaisFormatException, ValeurNulleException {
        int choix;
        boolean arret = true;
        do {
            try {
                this.afficherMenu();
                System.out.println("Votre choix ?");
                choix = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException exc) {
                throw new MauvaisFormatException("Entree invalide veillez entrer un choix valide");
            }

            switch (choix) {
                case 1:
                    sousMenu1();
                    break;
                case 2:
                    compagnie.reservation();
                    break;
                case 3:
                    compagnie.listeDeBusConduitParChauffeur();
                    break;
                case 4:
                    sousMenu2();
                    break;
                case 0:
                    arret = false;
                    break;
                default:
                    break;
            }

        } while (arret);
    }


    public void sousMenu1() throws MauvaisFormatException {
        int choix;
        boolean arret = true;

        while (arret) {

            System.out.println("Tapez 1 : pour creer un Bus");
            System.out.println("Tapez 2 : pour creer un Chauffeur");
            System.out.println("Tapez 0 : pour quitter");

            try {
                System.out.println("votre choix ?");
                choix = scan.nextInt();
            } catch (InputMismatchException e) {
                throw new MauvaisFormatException("Entree invalide veillez entrer un choix valide");
            }
            switch (choix) {

                case 1:
                    compagnie.creerBus();
                    break;
                case 2:
                    compagnie.creerChauffeur();
                    break;
                case 0:
                    arret = false;
                    break;
                default:
                    break;
            }
        }
    }


    private void sousMenu2() throws MauvaisFormatException, ValeurNulleException {
        int choix;
        boolean stop = true;

        while (stop) {

            System.out.println("Tapez 1 : pour afficher les caracteristiques de tous les bus");
            System.out.println("Tapez 2 : pour afficher les caracteristiques de tous les trajets");
            System.out.println("Tapez 0 : pour quitter");

            try {
                System.out.println("votre choix ?");
                choix = scan.nextInt();
            } catch (InputMismatchException e) {
                throw new MauvaisFormatException("Entree invalide veillez saisir un choix valide");
            }

            switch ( choix ){

                case 1:
                    compagnie.afficherLesBusUtilise();
                    break;
                case 2:
                    compagnie.afficherLesTrajet();
                    break;
                case 0:
                    stop = false;
                    break;
                default:
                    break;
            }
        }

    }
}
