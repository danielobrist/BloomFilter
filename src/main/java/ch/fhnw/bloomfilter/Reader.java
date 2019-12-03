package ch.fhnw.bloomfilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reader {
    private File file;

    public Reader (String fileName) throws URISyntaxException {
            file = getRessourceFile(fileName);
    }

    public File getRessourceFile(String fileName) throws URISyntaxException {
        URL filePath = Application.class.getClassLoader().getResource(fileName);
        return Paths.get(filePath.toURI()).toFile();
    }

    public ArrayList<String> readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        ArrayList<String> words = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
            words.add(st);
        }
        return words;
    }
}
