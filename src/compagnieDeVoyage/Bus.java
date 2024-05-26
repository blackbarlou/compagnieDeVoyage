package compagnieDeVoyage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bus {
    private int capaciteReservoir;
    private int  nombrePassagers;
    private String couleur;
    private String numeroImmatriculation;
    /**
     * Constructeur de la classe Bus
     * @param numeroImmatriculation : represente numero d'immatriculation du bus compose de caractere alpha-numerique
     * @param couleur : represente la couleur du bus
     * @param nombrePassagers : represente le nombre de passagers d'un bus
     * @param capaciteReservoir : represente la capacite du reservoir du bus
     */
    public Bus( String numeroImmatriculation, String couleur, int nombrePassagers, int capaciteReservoir ) {
        this.capaciteReservoir = capaciteReservoir;
        this.couleur = couleur;
        this.nombrePassagers = nombrePassagers;
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public int getCapaciteReservoir() {
        return capaciteReservoir;
    }

    public void setCapaciteReservoir(int capaciteReservoir) {
        this.capaciteReservoir = capaciteReservoir;
    }

    public int getNombrePassagers() {
        return nombrePassagers;
    }

    public void setNombrePassagers(int nombrePassagers) {
        this.nombrePassagers = nombrePassagers;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    @Override
    public String toString() {
        return "Bus [" +
                "Immatriculation : " + numeroImmatriculation  +
                ", capacite du Reservoir : " + capaciteReservoir +
                ", nombre de Passagers : " + nombrePassagers +
                ", couleur : " + couleur
                 + "]";
    }

    public  void creerBus() throws MauvaisFormatException {
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

