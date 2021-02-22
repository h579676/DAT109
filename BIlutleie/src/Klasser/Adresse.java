package Klasser;

public class Adresse {
    String gateAddresse;
    int postnummer;
    String poststed;

    public Adresse(String gateAdresse, int postnummer, String poststed) {
        this.gateAddresse = gateAddresse;
        this.postnummer = postnummer;
        this.poststed = poststed;
    }

    public String getGateAddresse() {
        return gateAddresse;
    }

    public void setGateAddresse(String gateAddresse) {
        this.gateAddresse = gateAddresse;
    }

    public int getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(int postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    @Override
    public String toString() {
        return "Addresse{" +
                "gateAddresse='" + gateAddresse + '\'' +
                ", postnummer='" + postnummer + '\'' +
                ", poststed='" + poststed + '\'' +
                '}';
    }
}