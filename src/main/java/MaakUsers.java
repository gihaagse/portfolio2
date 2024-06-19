import java.time.LocalDate;

public class MaakUsers {
    public static void nieuweGebruikerMaken(Gebruiker gebruiker){
        System.out.println();
        gebruiker.setNaam(gebruiker.vraagVoornaam());
        gebruiker.setAchternaam(gebruiker.vraagAchternaam());
        gebruiker.setGender(gebruiker.vraagGender());
        gebruiker.setGeboortedatum(LocalDate.of(gebruiker.vraagGeboorteJaar(), gebruiker.vraagGeboorteMaand(), gebruiker.vraagGeboorteDag()));
    }
}
