package compagnieDeVoyage;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cette Classe represente une compagnie nous allons implementer ici la liste des methodes en lien avec la compagnie
 */
public class Compagnie {
    private String nom;
    private Bus [] listeDeBus;
    private int busCount;
    private int chauffeurCount;
    private Chauffeur [] listeDeChauffeur;

    public Compagnie ( String nom){
        this.nom = nom;
        this.listeDeBus = new Bus[100];
        this.listeDeChauffeur = new Chauffeur[100];
        this.busCount = 0;
        this.chauffeurCount = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Bus[] getListeDeBus() {
        return listeDeBus;
    }

    public void setListeDeBus(Bus[] listeDeBus) {
        this.listeDeBus = listeDeBus;
    }

    public Chauffeur[] getListeDeChauffeur() {
        return listeDeChauffeur;
    }

    public void setListeDeChauffeur(Chauffeur[] listeDeChauffeur) {
        this.listeDeChauffeur = listeDeChauffeur;
    }

    @Override
    public String toString() {
        return "Compagnie : " + nom ;
    }

    /**
     * Cette methode permet a l'utilisateur de creer un bus a partir de ces propres valeurs et de l'ajouter dans la liste des bus
     * @throws MauvaisFormatException : classe d'Exception pour gerer les problemes liee aux mauvaises valeurs entrees
     * dans la variable nombreDePlace et capaciteDuReservoir
     */
    public void creerBus () throws MauvaisFormatException {
        Scanner scan = new Scanner(System.in);
        String couleur, immatriculation;
        int nombreDePlace, capaciteDuReservoir;

        System.out.println("Donnez la couleur du bus");
        couleur = scan.nextLine();
        System.out.println("Donnez l'immatriculation du bus ");
        immatriculation = scan.nextLine();
        try {
            System.out.println("Donnez le nombre de place du bus ");
            nombreDePlace = scan.nextInt();
            System.out.println("Donnez la capacite du reservoir");
            capaciteDuReservoir = scan.nextInt();
        } catch ( InputMismatchException exc ){
            throw new MauvaisFormatException("Mauvaise Valeur entree : valeur veillez entrer un entier");
        }
        Bus bus = new Bus( immatriculation, couleur, nombreDePlace, capaciteDuReservoir );
        System.out.println("Bus cree avec succes : " + bus.toString());
        listeDeBus[busCount] = bus;
        busCount++;
    }

    public void creerTrajet () throws ValeurNulleException, MauvaisFormatException {
        String villeDepart;
        String villeArrivee;
        int kilometrageDepart;
        int kilometrageArrivee;
        Bus bus;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Donnez la ville de depart du trajet ");
            villeDepart = scan.nextLine();
            System.out.println("Donnez la ville d'arrivee du trajet");
            villeArrivee = scan.nextLine();
            System.out.println("Donnez le kilometrage au depart votre trajet");
            kilometrageDepart = scan.nextInt();
            System.out.println("Donnez le kilometrage a l'arrivee de votre trajet");
            kilometrageArrivee = scan.nextInt();
        } catch (InputMismatchException exc){
            throw new MauvaisFormatException("La valeur du kilometrage doit imperativement etre un entier");
        }
        System.out.println("Veillez choisir le bus associe au trajet");
        try {
            if ( listeDeBus[0] == null ){
                throw new ValeurNulleException("Attention la liste de bus de cette compagnie est nulle ");
            }

        } catch ( ValeurNulleException ex ){
            System.out.println(ex.getMessage() + "Veillez d'abord ajouter des bus");
            creerBus();
        }
        if ( listeDeBus[0] != null ){
            for ( int i=0; i<listeDeBus.length; i++ ){
                if ( listeDeBus[i] != null ){
                    System.out.println( (i+1) + "||" + listeDeBus[i] );
                }
            }
            System.out.println("Votre choix ?");
            int choix = scan.nextInt();
            bus = listeDeBus[choix -1];
            Trajet trajet = new Trajet(villeDepart, villeArrivee, kilometrageDepart, kilometrageArrivee, bus);
        }
    }

    /**
     * Methode pour creer un chauffeur a partir des donnees utilisateurs
     * @throws MauvaisFormatException : classe pour gerer les erreurs liee a l'entree invalide
     */
    public void creerChauffeur () throws MauvaisFormatException {
        Scanner scan = new Scanner(System.in);
        String nom;
        String prenom;
        int age;
        int anneeEmbauche;
        int compteurDeTrajet = 0;
        String adresse;
        Trajet [] trajetChauffeur = new Trajet[20];
        String numeroIdentification;


    }
}
