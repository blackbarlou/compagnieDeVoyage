package compagnieDeVoyage;


public class Main {

    public static void main(String[] args) throws MauvaisFormatException {
       Compagnie compagnie = new Compagnie("STTR");
        try {
            compagnie.creerBus();
            }
        catch ( MauvaisFormatException exc ){
            System.out.println("erreur rencontree " + exc.getMessage());
        }

    }
}
