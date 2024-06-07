public class InvullenDossier {

    public static void invullenStandaardDossier(Asielzoeker asielzoeker){
        Dossier dossier = asielzoeker.getDossier();
        dossier.setAfrondingAsiel(AfrondingAsiel.NEE);
        dossier.setUitspraakIND(UitspraakIND.NEE);
        dossier.setEigenWoning(AfrondingWoning.NEE);
        dossier.setTerugNaarLand(TerugNaarLand.NEE);
        asielzoeker.setDossier(dossier);
    }
}
