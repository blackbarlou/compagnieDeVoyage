package compagnieDeVoyage;


public class Main {

    public static void main(String[] args) throws MauvaisFormatException {
        try {Bus.creerBus();
        }catch ( MauvaisFormatException exc ){
            System.out.println("erreur rencontree " + exc.getMessage());
            Bus.creerBus();
        }

    }
}
