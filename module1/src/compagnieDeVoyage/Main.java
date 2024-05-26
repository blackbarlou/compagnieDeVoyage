package compagnieDeVoyage;


public class Main {

    public static void main(String[] args) throws MauvaisFormatException, ValeurNulleException {
       Compagnie compagnie = new Compagnie("STTR");
        /*try {
            //compagnie.creerBus();
            compagnie.creerTrajet();
            } catch ( ValeurNulleException exc ){
            System.out.println("erreur rencontree " + exc.getMessage());
        } catch ( MauvaisFormatException m ){
            System.out.println(" Veillez reprendre " + m.getMessage());
            compagnie.creerTrajet();
        }*/
        //Chauffeur chauffeur = new Chauffeur("ben","Nour","hghdyu",24,2013);
        //System.out.println(chauffeur);
        compagnie.reservation();
        compagnie.listeDeBusConduitParChauffeur();

    }
}
