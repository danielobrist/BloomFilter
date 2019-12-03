package ch.fhnw.bloomfilter;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BloomFilter {
//aksdjf
    int n;
    double p;
    double m;
    int k;

    boolean[] bloomFilter;

    Reader reader = new Reader("words.txt");
    ArrayList<String> words = reader.readFile();

    public BloomFilter(double p) throws URISyntaxException, IOException {
        this.n =  words.size();                  // TODO: Anzahl Wörter von Liste zählen
        this.p = p;                                                 // Fehlerwahscheinlichkeit fix
        this.m = - (n * Math.log(p) / Math.pow(Math.log(2),2));      // Filtergrösse
        this.k = (int)( (m / n) * Math.log(2)) + 1;                  // Anzahl Hash-Funktionen
        bloomFilter = new boolean[(int) m + 1];


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
               HashCode hash = Hashing.murmur3_128(j).hashString(words.get(i), Charset.defaultCharset());
               int pos = (int) (hash.asInt() % m);
               bloomFilter[pos] = true;
            }
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
