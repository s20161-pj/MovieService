package pl.pjatk.joawalk;

public class Pies {
    private String imie;
    private String kolor;
    private String rasa;
    private int wiek;

    public Pies(String imie, String kolor, String rasa, int wiek) {
        this.imie = imie;
        this.kolor = kolor;
        this.rasa = rasa;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
}
