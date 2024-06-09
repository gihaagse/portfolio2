public class DossierEditor {

    public static void invullenStandaardArchief(Asielzoeker asielzoeker, Archief archiefType){
        archiefType.invullenStandaardDossier();
    }

    public void UitlezenDossier(Dossier dossier){
        if (dossier.getAfrondingAsiel() == null) {
            System.out.println("Asielaanvraag is niet ingevuld.");
        } else {
            System.out.println("Asielaanvraag is afgerond: " + dossier.getAfrondingAsiel());
        }
        if (dossier.getUitspraakIND() == null) {
            System.out.println("Uitspraak IND is niet ingevuld.");
        } else {
            System.out.println("Uitspraak IND: " + dossier.getUitspraakIND());
        }
        if (dossier.getEigenWoning() == null) {
            System.out.println("Plaatsing in eigen woning is niet ingevuld.");
        } else {
            System.out.println("Plaatsing in eigen woning: " + dossier.getEigenWoning());
        }
        if (dossier.getTerugNaarLand() == null) {
            System.out.println("Teruggekeerd naar het land van herkomst is niet ingevuld.");
        } else {
            System.out.println("Teruggekeerd naar het land van herkomst: " + dossier.getTerugNaarLand());
        }

/*        System.out.println("Asielaanvraag is afgerond:" + dossier.getAfrondingAsiel() );
        System.out.println("Uitspraak IND: " + dossier.getUitspraakIND());
        System.out.println("Plaatsing in eigen woning: " + dossier.getEigenWoning());
        System.out.println("Teruggekeerd naar het land van herkomst: " + dossier.getTerugNaarLand());*/
    }
}
