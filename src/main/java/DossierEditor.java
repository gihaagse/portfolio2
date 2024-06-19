public class DossierEditor {

    public static void invullenStandaardArchief(Archief archief, Gebruiker asielzoeker){
        archief.invullenStandaardArchief(asielzoeker);
        asielzoeker.setArchief(archief);
    }

    public void uitlezenArchief(Archief archief, Asielzoeker asielzoeker){
        archief.uitlezenArchief(asielzoeker);
    }

    public void subscribeArchiefUpdates (Archief archief, Observer observer){
        archief.subscribeArchiefUpdates(observer);
    }

    public void unsubscribeArchiefUpdates (Archief archief, Observer observer){
        archief.unsubscribeArchiefUpdates(observer);
    }

    public static void setArchief(Archief archief, Observer observer){
        observer.setArchief(archief);
    }

    public static void setAfrondingAsiel(Archief archief, AfrondingAsiel afrondingAsiel){
        archief.setAfrondingAsiel(afrondingAsiel);
    }
    public static void setUitspraakIND(Archief archief, UitspraakIND uitspraakIND){
        archief.setUitspraakIND(uitspraakIND);
    }
    public static void setEigenWoning(Archief archief, AfrondingWoning afrondingWoning, Gebruiker asielzoeker){
        archief.setEigenWoning(afrondingWoning, asielzoeker);
    }
    public static void setTerugNaarLand(Archief archief, TerugNaarLand terugNaarLand){
        archief.setTerugNaarLand(terugNaarLand);
    }

}
