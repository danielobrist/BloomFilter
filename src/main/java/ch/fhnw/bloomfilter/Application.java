package ch.fhnw.bloomfilter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws URISyntaxException, IOException {

        BloomFilter bloomFilter = new BloomFilter(0.01);

        System.out.println("Anzahl Wörter: " + bloomFilter.getN());
        System.out.println("gewünschte maximale Fehlerwahrscheinlichkeit: " + (int) (bloomFilter.getP()*100) + "%");
        System.out.println("Anzahl Hash-Funktionen: " + bloomFilter.getK());
        System.out.println("Anzahl Testwerte: " + bloomFilter.getZ());
        System.out.println("Zuverlässigkeit: " + bloomFilter.testReliability());

    }
}
