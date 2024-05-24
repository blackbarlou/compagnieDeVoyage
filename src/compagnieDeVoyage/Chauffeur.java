package compagnieDeVoyage;

import java.util.Arrays;

public class Chauffeur {
    private String nom;
    private String prenom;
    private int age;
    private int anneeEmbauche;
    private String adresse;
    private Trajet [] trajetChauffeur;
    private final String numeroIdentification;

    /**
     *
     * @param nom : represente le nom du chauffeur
     * @param prenom : represente le prenom du chauffeur
     * @param adresse : represente l'adresse du chauffeur format canadien
     * @param age : represente l'age du chauffeur
     * @param anneeEmbauche : represente l'annee d'embauche du chauffeyr
     * le numero d'identification est genere automatiquement en utilisant
     *                              -les 4 premiers caracteres du nom
     *                              -le 1er caractere du prenom
     *                              -les deux derniers caracteres de l'annee d'embauche
     * Pour ce fait nous avons utilise des methodes de la classe String substring () qui retourne une partie de chaine de caractere extraite d'une chaine initiale
     *                      charAt() qui retourne le caractere de la position demandee
     *                      String.valueof() qui transforme des valeurs en objet de type string
     */
    public Chauffeur ( String nom, String prenom, String adresse, int age, int anneeEmbauche ){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.anneeEmbauche = anneeEmbauche;
        this.numeroIdentification = nom.substring(0,4) + prenom.charAt(0) + String.valueOf( anneeEmbauche ).substring(2);
        this.trajetChauffeur = new Trajet[20];
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnneeEmbauche() {
        return anneeEmbauche;
    }

    public void setAnneeEmbauche(int anneeEmbauche) {
        this.anneeEmbauche = anneeEmbauche;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Trajet[] getTrajetChauffeur() {
        return trajetChauffeur;
    }

    public void setTrajetChauffeur(Trajet[] trajetChauffeur) {
        this.trajetChauffeur = trajetChauffeur;
    }

    public String getNumeroIdentification() {
        return numeroIdentification;
    }

    @Override
    public String toString() {
        return "Chauffeur [" +
                "nom :" + nom + '\'' +
                ", prenom : " + prenom + '\'' +
                ", age :" + age +
                ", annee d'embauche :" + anneeEmbauche +
                ", adresse : " + adresse + '\'' +
                ", numero d'identification='" + numeroIdentification + '\'' +
                ']';
    }
}
