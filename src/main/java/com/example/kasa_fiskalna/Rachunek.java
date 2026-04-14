package com.example.kasa_fiskalna;

public abstract class Rachunek {

    protected String nazwa;
    protected double wartosc;

    public Rachunek(String nazwa, double wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }
    protected abstract double podatek();

    public String oblicz() {
        double kwotaPodatku = wartosc * podatek();
        double netto = wartosc - kwotaPodatku;

        return nazwa +
                " | Wartość całkowita: " + String.format("%.2f", wartosc) + " zł" +
                " | Wartość netto: " + String.format("%.2f", netto) + " zł" +
                " | Podatek (" + (int)(podatek() * 100) + "%): " +
                String.format("%.2f", kwotaPodatku) + " zł";
    }
}