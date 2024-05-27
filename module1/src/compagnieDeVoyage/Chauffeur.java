package compagnieDeVoyage;

import java.util.Arrays;

/**
 * Cette classe represente un Chauffeur
 * nous allons implementer les methodes liee au chauffeur
 * methode pour trouver les bus conduit par un chauffeur
 * afficher les caracteristiques d'un chauffeur
 */
public class Chauffeur {
    private String nom;
    private String prenom;
    private int age;
    private int anneeEmbauche;
    private String adresse;
    private Trajet[] trajetChauffeur;
    private String numeroIdentification;
    private static int count = 0;

    /**
     * @param nom           : represente le nom du chauffeur
     * @param prenom        : represente le prenom du chauffeur
     * @param adresse       : represente l'adresse du chauffeur format canadien
     * @param age           : represente l'age du chauffeur
     * @param anneeEmbauche : represente l'annee d'embauche du chauffeyr
     *                      le numero d'identification est genere automatiquement en utilisant la methode genererNumeroIdentifiant()
     *                      -les 4 premiers caracteres du nom
     *                      -le 1er caractere du prenom
     *                      -les deux derniers caracteres de l'annee d'embauche
     *                      Pour ce fait nous avons utilise des methodes de la classe String substring () qui retourne une partie de chaine de caractere extraite d'une chaine initiale
     *                      charAt() qui retourne le caractere de la position demandee
     *                      String.valueof() qui transforme des valeurs en objet de type string
     *                      Si le nombre de caractere du nom est inferieur a 4 des 0 sont ajoutes au debut de l'identifiant pour moduler
     */
    public Chauffeur(String nom, String prenom, String adresse, int age, int anneeEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.anneeEmbauche = anneeEmbauche;
        this.numeroIdentification = this.genererNumeroIdentification();
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

    public void setTrajetChauffeur(Trajet trajet) {
        this.trajetChauffeur[count++] = trajet;
    }

    public String getNumeroIdentification() {
        return numeroIdentification;
    }

    @Override
    public String toString() {
        return "Chauffeur [" +
                "nom : " + nom +
                ", prenom : " + prenom +
                ", age : " + age +
                ", annee d'embauche :" + anneeEmbauche +
                ", adresse : " + adresse +
                ", numero d'identification = " + numeroIdentification +
                "]";
    }

    /**
     * cette methode permet d'afficher la liste des trajet du chauffeur en plus de ses informations personelles
     */
    public void afficherCaracteristiqueChauffeur() {
        System.out.println("Nom du chauffeur : " + nom);
        System.out.println("Prenom du chauffeur : " + prenom);
        System.out.println("Age du chauffeur : " + age);
        System.out.println("Numero d'identification du chauffeur : " + numeroIdentification);
        System.out.println("liste des trajets du chauffeur");
        for (Trajet trajet : trajetChauffeur) {
            if (trajet != null)
                System.out.println(trajet);
        }

    }

    /**
     * cette methode permet de creer l'identifiant du chauffeur tout en tenant compte des cas ou le nom serait de moins de 4 caracteres
     * @return String identifiant : qui sera utilise par notre constructeur pour generer automatique l'id du chauffeur
     */
    public String genererNumeroIdentification() {
        int caractereDuNom = this.nom.length();
        String indentifiant = "";
        if (caractereDuNom < 4) {
            switch (caractereDuNom) {
                case 1:
                    indentifiant = "000" + nom + prenom.charAt(0) + String.valueOf(anneeEmbauche).substring(2);
                    break;
                case 2:
                    indentifiant = "00" + nom + prenom.charAt(0) + String.valueOf(anneeEmbauche).substring(2);
                    break;
                case 3:
                    indentifiant = "0" + nom + prenom.charAt(0) + String.valueOf(anneeEmbauche).substring(2);
                    break;
                default:
                    break;
            }
            return indentifiant ;
        } else {
            indentifiant = this.nom.substring(0, 4) + this.prenom.charAt(0) + String.valueOf(this.anneeEmbauche).substring(2);
        }
        return indentifiant;
    }
}
