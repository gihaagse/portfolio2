public class DossierEditor {

    public static void invullenStandaardArchief(Archief archief){
        archief.invullenStandaardArchief();
    }

    public void uitlezenArchief(Archief archief){
        archief.uitlezenArchief();
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
}
