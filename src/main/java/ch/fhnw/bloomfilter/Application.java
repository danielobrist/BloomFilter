package ch.fhnw.bloomfilter;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Bitte gewünschte Fehlerwahrscheinlichekeit p eingeben (z.B. 0.01 für 1%)");
        System.out.println("-> Achtung es funktioniert nur Punkt als Dezimaltrennzeichen!");
        Scanner in = new Scanner(System.in).useLocale(new Locale("de_CH"));
        double p = in.nextDouble();

        BloomFilter bloomFilter = new BloomFilter(p);

        System.out.println("Anzahl Wörter: " + bloomFilter.getN());
        System.out.println("gewünschte maximale Fehlerwahrscheinlichkeit: " + (bloomFilter.getP()*100) + "%");
        System.out.println("Anzahl Hash-Funktionen: " + bloomFilter.getK());
        System.out.println("Anzahl Testwerte: " + bloomFilter.getZ());
        System.out.println("Zuverlässigkeit: " + bloomFilter.testReliability());

    }
}
