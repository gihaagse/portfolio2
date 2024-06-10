public interface Archief {
    void invullenStandaardArchief();
    void uitlezenArchief();
    void subscribeArchiefUpdates(Observer observer);
    void unsubscribeArchiefUpdates(Observer observer);
}
