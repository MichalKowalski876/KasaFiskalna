package com.example.kasa_fiskalna;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField wartoscTextField;
    @FXML
    private TextField nazwaTextField;
    @FXML
    private TextArea outputTextArea;

    @FXML
    protected void Paragon() {
        outputTextArea.clear();
        String nazwa = nazwaTextField.getText();
        String wartoscTekst = wartoscTextField.getText();

        if (nazwa.isEmpty() || wartoscTekst.isEmpty()){
            outputTextArea.appendText("Błąd: Proszę podać wszystkie dane.");
            return;
        }

        try {
            Double wartosc = Double.valueOf(wartoscTekst);

            Rachunek r = new Paragon(nazwa, wartosc);
            String wynik = r.oblicz();
            Historia.zapisHistorii(wynik, "Paragon");
            outputTextArea.appendText(wynik);

        } catch(NumberFormatException e){
            outputTextArea.appendText("Błąd: Wartość dopuszcza tylko liczby i \".\"");
        }
    }

    @FXML
    protected void Faktura() {
        outputTextArea.clear();
        String nazwa = nazwaTextField.getText();
        String wartoscTekst = wartoscTextField.getText();

        if (nazwa.isEmpty() || wartoscTekst.isEmpty()){
            outputTextArea.appendText("Błąd: Proszę podać wszystkie dane");
            return;
        }

        try {
            double wartosc = Double.valueOf(wartoscTekst);

            Rachunek r = new Faktura(nazwa, wartosc);
            String wynik = r.oblicz();
            Historia.zapisHistorii(wynik, "Faktura");
            outputTextArea.appendText(wynik);

        }catch (NumberFormatException e){
            outputTextArea.appendText("Błąd: Wartość dopuszcza tylko liczby i \".\"");
        }
    }

    @FXML
    protected void Historia() {
        outputTextArea.clear();
        String wynik = Historia.OdczytHistorii();

        outputTextArea.appendText(wynik);
    }
}