package compagnieDeVoyage;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cette Classe represente une compagnie nous allons implementer ici la liste des methodes en lien avec la compagnie
 * methode qui permet de creer un bus
 * methode qui permet de creer un trajet
 * methode qui permet de creer un chauffeur
 */
public class Compagnie {
    private String nom;
    private Bus [] listeDeBus;
    private static int busCount;
    private static int chauffeurCount;
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
        int nombreDePlace;
        double capaciteDuReservoir;

        System.out.println("Donnez la couleur du bus");
        couleur = scan.nextLine();
        System.out.println("Donnez l'immatriculation du bus ");
        immatriculation = scan.nextLine();
        try {
            System.out.println("Donnez le nombre de place du bus ");
            nombreDePlace = scan.nextInt();
            System.out.println("Donnez la capacite du reservoir");
            capaciteDuReservoir = scan.nextDouble();
        } catch ( InputMismatchException exc ){
            System.out.println("le Nombre de place doit etre un entier et la capacite un reel veillez recommencer SVP");
            creerBus();
            throw new MauvaisFormatException("Mauvaise valeur entree lors de la saisie");
        }
        Bus bus = new Bus( immatriculation, couleur, nombreDePlace, capaciteDuReservoir );
        System.out.println("Bus cree avec succes : " + bus.toString());
        listeDeBus[busCount++] = bus;
    }

    /**
     * cette methode permet de creer un trajet a partir des informations de l'utilisateur
     * @return le trajet cree
     * @throws ValeurNulleException : classe qui gere les exception de valeur nulle dans le tableau de bus
     * @throws MauvaisFormatException : classe qui l'exception de mauvais format entre lors de l'appel du Scanner
     */
    public Trajet creerTrajet () throws ValeurNulleException, MauvaisFormatException {
        String villeDepart;
        String villeArrivee;
        int kilometrageDepart;
        int kilometrageArrivee;
        Bus bus;
        Trajet trajet;
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
            trajet = new Trajet(villeDepart, villeArrivee, kilometrageDepart, kilometrageArrivee, bus);
            return trajet;
        } return null;
    }

    /**
     * Methode pour creer un chauffeur a partir des donnees utilisateurs
     * @throws MauvaisFormatException : classe pour gerer les erreurs liee a l'entree invalide
     */
    public void creerChauffeur () throws MauvaisFormatException {
        Scanner scan = new Scanner(System.in);
        int age;
        int caractere;
        int anneeEmbauche;
        int compteurDeTrajet = 0;
        String nom;
        String prenom;
        String adresse;
        String codePostal;
        Trajet [] trajetChauffeur = new Trajet[20];
        Chauffeur chauffeur;

        /*
        cette boucle est utilisee pour s'assurer que les valeurs du nom et du prenom
        ne soient pas vide a cause de la contrainte qui les lie au numero d'identification
         */
        do {
            System.out.println("Donnez le nom du chauffeur");
            nom = scan.nextLine();
            System.out.println("Donnez le prenom du chauffeur");
            prenom = scan.nextLine();
        } while ( nom.isEmpty() && prenom.isEmpty() );
        System.out.println("Remplissage de l'adresse du Chauffeur format canadien");
        System.out.println("Entrez le numero et nom de rue (123 nom_Rue)");
        adresse = scan.nextLine();
        System.out.println("Entrez la ville et la province (nom_ville, nom_province) ");
        adresse += scan.nextLine();
        do {
            System.out.println("Entrez le code postal sans espace ex (G9P3H3)");
            codePostal = scan.nextLine();
            caractere = codePostal.length();
        } while ( caractere != 6 );
        adresse += codePostal;
        adresse += "CANADA";
        try {
            System.out.println("Donnez l'age du chauffeur");
            age = scan.nextInt();
            System.out.println("Donnez l'annee d'embauche du chauffeur");
            anneeEmbauche = scan.nextInt();
        } catch ( InputMismatchException in ){
            throw new MauvaisFormatException("Mauvaise valeur entree l'age de l'annee doivent entre des entiers");
        }

        chauffeur = new Chauffeur( nom, prenom, adresse, age, anneeEmbauche );
        System.out.println("operation reussie :" + chauffeur.toString());
        listeDeChauffeur[chauffeurCount++] = chauffeur;

    }

    /**
     * cette methode permet de faire une reservation ( choisir un chauffeur et lui associer un trajet )
     * si la liste de chauffeur est vide, la methode permet te renvoie vers la methode creerChauffeur()
     * avant de continuer grace a un appel recursif
     * @throws MauvaisFormatException
     * @throws ValeurNulleException
     */
    public void reservation() throws MauvaisFormatException, ValeurNulleException {
        Trajet trajet;
        Chauffeur chauffeur;
        int count = 0;
        int choix;
        Scanner scan = new Scanner(System.in);

        System.out.println("Veillez selectionner le chauffeur a qui vous voulez associer un trajet");
        if ( listeDeChauffeur[0] != null ){
            for ( int i=0; i<listeDeChauffeur.length; i++ ){
                if ( listeDeChauffeur[i] != null ){
                    System.out.println( (i + 1) + " || " + listeDeChauffeur[i] );
                }
            }
            System.out.println("Votre choix");
            try {
                choix = scan.nextInt();
            } catch ( InputMismatchException e){
                throw new MauvaisFormatException("Mauvaise valeur");
            }
            chauffeur = listeDeChauffeur[choix -1];
            System.out.println("Entrez les information du trajet ");
            trajet = creerTrajet();
            chauffeur.setTrajetChauffeur(trajet);
            System.out.println("Operation reussie");
            chauffeur.afficherCaracteristiqueChauffeur();
        } else {
            System.out.println("La liste de chauffeur est vide veillez d'abord ajouter un chauffeur");
            creerChauffeur();
            reservation();
        }
    }

    public void listeDeBusConduitParChauffeur() throws MauvaisFormatException {
        int choix;
        int count = 0;
        Trajet [] trajet = new Trajet[20];
        Chauffeur chauffeur;
        Scanner scan = new Scanner(System.in);
        Bus [] busList = new Bus[20];
        if ( listeDeChauffeur[0] != null ){
            System.out.println("Veillez choisir le chauffeur");
            for ( int i=0; i<listeDeChauffeur.length; i++ ){
                if ( listeDeChauffeur[i] != null){
                    System.out.println( (1 + i) + "|| " + listeDeChauffeur[i] );
                }
            }
            System.out.println("Votre choix ?");
            choix = scan.nextInt();
            chauffeur = listeDeChauffeur[choix -1 ];
            for ( Trajet t : chauffeur.getTrajetChauffeur() ){
                busList[count++] = t.getBus();
            }
            System.out.println("La liste de bus conduit par le chauffeur " + chauffeur.getNumeroIdentification());
            for ( Bus b : busList ){
                while ( b != null ){
                    System.out.println(b);
                }
            }
        } else {
            System.out.println("La liste de chauffeur est vide ");
        }
    }

}
