package ee.bcs.valiit.tests;

public class Konto {

    private String kontoNumber;
    private String omanikuNimi;
    private double balanss;
    private boolean kasOnLukus;

    public String getKontoNumber() {
        return kontoNumber;
    }

    public void setKontoNumber(String kontoNumber) {
        this.kontoNumber = kontoNumber;
    }

    public String getOmanikuNimi() {
        return omanikuNimi;
    }

    public void setOmanikuNimi(String omanikuNimi) {
        this.omanikuNimi = omanikuNimi;
    }

    public double getBalanss() {
        return balanss;
    }

    public void setBalanss(double balanss) {
        this.balanss = balanss;
    }

    public boolean isKasOnLukus() {
        return kasOnLukus;
    }

    public void setKasOnLukus(boolean kasOnLukus) {
        this.kasOnLukus = kasOnLukus;
    }
}
