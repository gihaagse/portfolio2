public class Woonplaats {
    private String adres;

    private String stad;

    private String postcode;
    
    public Woonplaats (String adres, String stad, String postcode){
        this.adres = adres;
        this.stad = stad;
        this.postcode = postcode;
    }

    public String getAdres(){
        return adres;
    }
    public void setAdres(){
        this.adres = adres;
    }
    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
