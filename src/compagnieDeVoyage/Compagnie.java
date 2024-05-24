package compagnieDeVoyage;

import java.util.Arrays;

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
}
