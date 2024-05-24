package compagnieDeVoyage;

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
        return "Bus[" +
                "Immatriculation : " + numeroImmatriculation  +
                ", capacite du Reservoir : " + capaciteReservoir +
                ", nombre de Passagers : " + nombrePassagers +
                ", couleur : " + couleur
                 + "]";
    }
}

