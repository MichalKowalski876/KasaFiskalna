package com.example.kasa_fiskalna;

public class Faktura extends Rachunek{
    public Faktura(String nazwa, double wartosc){
        super(nazwa, wartosc);
    }

    @Override
    protected double podatek(){
        return 0.23;
    }
}
