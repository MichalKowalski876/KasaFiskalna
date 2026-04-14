package com.example.kasa_fiskalna;

public class Paragon extends Rachunek {
    public Paragon(String nazwa, double wartosc){
        super(nazwa, wartosc);
    }

    @Override
    protected double podatek(){
        return 0.08;
    }
}
