package com.example.kasa_fiskalna;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Historia {
    static void zapisHistorii(String wynik, String forma) {
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String zapis = forma + " | " + wynik + " | " + data.format(formatter) + "\n";

        File plik = new File("Historia.txt");
        try {
            plik.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fw = new FileWriter("Historia.txt", true)) {
            fw.write(zapis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String OdczytHistorii() {
        File plik = new File("Historia.txt");
        StringBuilder wynik = new StringBuilder();

        try (BufferedReader br = new BufferedReader((new FileReader(plik)))) {
            String line;
            while ((line = br.readLine()) != null) {
                wynik.insert(0, line + "\n");
            }
            return wynik.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
