package compagnieDeVoyage;


/**
 * Cette classe represente un trajet
 * Nous allons implementer ici les methodes propres au trajet
 * la methode pour afficher les caracteristiques d'un trajet
 */
public class Trajet {
    private String villeDepart;
    private String villeArrive;
    private int kilometrageDepart;
    private int kilometrageArrive;
    private Bus bus;

    /**
     * constructeur de la classe trajet
     * @param villeDepart : represente la ville de depart
     * @param villeArrive : represnete la ville d'arrivee
     * @param kilometrageDepart : represente le kilometrage du bus au depart du trajet
     * @param kilometrageArrive : represente le kilometrage du bus a l'arrive du trajet
     * @param bus : represente le bus utiliser pour effectuer le trajet
     */
    public Trajet(String villeDepart, String villeArrive, int kilometrageDepart, int kilometrageArrive, Bus bus ){
        this.villeArrive = villeArrive;
        this.villeDepart = villeDepart;
        this.kilometrageArrive = kilometrageArrive;
        this.kilometrageDepart = kilometrageDepart;
        this.bus = bus;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getKilometrageArrive() {
        return kilometrageArrive;
    }

    public void setKilometrageArrive(int kilometrageArrive) {
        this.kilometrageArrive = kilometrageArrive;
    }

    public int getKilometrageDepart() {
        return kilometrageDepart;
    }

    public void setKilometrageDepart(int kilometrageDepart) {
        this.kilometrageDepart = kilometrageDepart;
    }

    public String getVilleArrive() {
        return villeArrive;
    }

    public void setVilleArrive(String villeArrive) {
        this.villeArrive = villeArrive;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    @Override
    public String toString() {
        return "trajet [" +
                "ville de Depart : " + villeDepart +
                ", ville d'Arrive : " + villeArrive  +
                ", kilometrage au Depart : " + kilometrageDepart +
                ", kilometrage l'Arrive : " + kilometrageArrive +
                ", bus du trajet : " + bus +
                ']';
    }

    public void afficherLesCaracteristiques ( ) throws ValeurNulleException {

        if ( bus == null ){
            throw new ValeurNulleException(" Attention vous n'avez pas de bus pour ce trajet ");
        }
        System.out.println("Les caracteristiques du trajet :");
        System.out.println("La ville de Depart : " + villeDepart);
        System.out.println("La ville de D'arrivee : " + villeArrive);
        System.out.println("kilometrage au Depart :" + kilometrageDepart);
        System.out.println("kilometrage a l'Arrive :" + kilometrageArrive);
        System.out.println("Le bus du trajet : " + bus);
    }


}
