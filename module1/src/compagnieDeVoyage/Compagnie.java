package compagnieDeVoyage;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Compagnie {
    private String nom;
    private Bus [] listeDeBus;
    private Chauffeur [] listeDeChauffeur;

    public Compagnie ( String nom){
        this.nom = nom;
        this.listeDeBus = new Bus[100];
        this.listeDeChauffeur = new Chauffeur[100];
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

    }
}
