import java.util.List;

public class Dossier implements Archief{
    private AfrondingAsiel afrondingAsiel;
    private UitspraakIND uitspraakIND;
    private AfrondingWoning eigenWoning;
    private TerugNaarLand terugNaarLand;
    private List<Observer> observers;

    public AfrondingAsiel getAfrondingAsiel() {
        return afrondingAsiel;
    }

    public void setAfrondingAsiel(AfrondingAsiel afrondingAsiel) {
        this.afrondingAsiel = afrondingAsiel;
    }

    public UitspraakIND getUitspraakIND() {
        return uitspraakIND;
    }

    public void setUitspraakIND(UitspraakIND uitspraakIND) {
        this.uitspraakIND = uitspraakIND;
    }

    public AfrondingWoning getEigenWoning() {
        return eigenWoning;
    }

    public void setEigenWoning(AfrondingWoning eigenWoning) {
        this.eigenWoning = eigenWoning;
        for(Observer obs: observers){
            obs.update();
        }
    }

    public TerugNaarLand getTerugNaarLand() {
        return terugNaarLand;
    }

    public void setTerugNaarLand(TerugNaarLand terugNaarLand) {
        this.terugNaarLand = terugNaarLand;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
@Override
    public void uitlezenArchief(){
    if (getAfrondingAsiel() == null) {
        System.out.println("Asielaanvraag is niet ingevuld.");
    } else {
        System.out.println("Asielaanvraag is afgerond: " + getAfrondingAsiel());
    }
    if (getUitspraakIND() == null) {
        System.out.println("Uitspraak IND is niet ingevuld.");
    } else {
        System.out.println("Uitspraak IND: " + getUitspraakIND());
    }
    if (getEigenWoning() == null) {
        System.out.println("Plaatsing in eigen woning is niet ingevuld.");
    } else {
        System.out.println("Plaatsing in eigen woning: " + getEigenWoning());
    }
    if (getTerugNaarLand() == null) {
        System.out.println("Teruggekeerd naar het land van herkomst is niet ingevuld.");
    } else {
        System.out.println("Teruggekeerd naar het land van herkomst: " + getTerugNaarLand());
    }
        
        /*        System.out.println("Asielaanvraag is afgerond:" + getAfrondingAsiel() );
        System.out.println("Uitspraak IND: " + getUitspraakIND());
        System.out.println("Plaatsing in eigen woning: " + getEigenWoning());
        System.out.println("Teruggekeerd naar het land van herkomst: " + getTerugNaarLand());*/
    }
@Override
    public void invullenStandaardArchief(){
        setAfrondingAsiel(AfrondingAsiel.NEE);
        setUitspraakIND(UitspraakIND.NEE);
        setEigenWoning(AfrondingWoning.NEE);
        setTerugNaarLand(TerugNaarLand.NEE);
    }

    @Override
    public void subscribeArchiefUpdates(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribeArchiefUpdates(Observer observer) {
        observers.remove(observer);
    }
}
