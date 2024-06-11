public interface Archief {
    void invullenStandaardArchief();
    void uitlezenArchief();
    void subscribeArchiefUpdates(Observer observer);
    void unsubscribeArchiefUpdates(Observer observer);

    public AfrondingAsiel getAfrondingAsiel();

    public void setAfrondingAsiel(AfrondingAsiel afrondingAsiel);


    public UitspraakIND getUitspraakIND();


    public void setUitspraakIND(UitspraakIND uitspraakIND);


    public AfrondingWoning getEigenWoning();
    public void setEigenWoning(AfrondingWoning eigenWoning);

    public TerugNaarLand getTerugNaarLand();

    public void setTerugNaarLand(TerugNaarLand terugNaarLand);

}
