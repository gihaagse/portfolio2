import java.util.List;

public class Dossier {
    private boolean afrondingAsiel;
    private boolean uitspraakIND;
    private AfrondingWoning eigenWoning;
    private boolean terugNaarLand;
    private List<Observer> observers;

    public boolean isAfrondingAsiel() {
        return afrondingAsiel;
    }

    public void setAfrondingAsiel(boolean afrondingAsiel) {
        this.afrondingAsiel = afrondingAsiel;
    }

    public boolean isUitspraakIND() {
        return uitspraakIND;
    }

    public void setUitspraakIND(boolean uitspraakIND) {
        this.uitspraakIND = uitspraakIND;
    }

    public AfrondingWoning getEigenWoning() {
        return eigenWoning;
    }

    public void setEigenWoning(AfrondingWoning eigenWoning) {
        this.eigenWoning = eigenWoning;
    }

    public boolean isTerugNaarLand() {
        return terugNaarLand;
    }

    public void setTerugNaarLand(boolean terugNaarLand) {
        this.terugNaarLand = terugNaarLand;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }



}
