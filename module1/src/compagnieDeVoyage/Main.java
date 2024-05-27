package compagnieDeVoyage;


public class Main {

    public static void main(String[] args) throws MauvaisFormatException, ValeurNulleException {
       /*Compagnie compagnie = new Compagnie("STTR");
        *//*try {
            //compagnie.creerBus();
            compagnie.creerTrajet();
            } catch ( ValeurNulleException exc ){
            System.out.println("erreur rencontree " + exc.getMessage());
        } catch ( MauvaisFormatException m ){
            System.out.println(" Veillez reprendre " + m.getMessage());
            compagnie.creerTrajet();
        }*//*
        //Chauffeur chauffeur = new Chauffeur("ben","Nour","hghdyu",24,2013);
        //System.out.println(chauffeur);
        //compagnie.reservation();
        Chauffeur chauffeur = new Chauffeur("Ben", "Franck", "670 rue des mangues", 20, 2034);
        //Chauffeur[] listec = new Chauffeur[1];
        Bus bus = new Bus("ijjd","noire",120,2000);
        compagnie.setListeDeBus(bus);
        Trajet trajet = new Trajet("Douala", "Yaounde",123,234, bus);
        chauffeur.setTrajetChauffeur(trajet);
        compagnie.setListeDeChauffeur(chauffeur);
        compagnie.listeDeBusConduitParChauffeur();
*/
        Menu menu = new Menu();
        menu.menuPrincipal();



    }
}
