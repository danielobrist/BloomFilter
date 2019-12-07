package ch.fhnw.bloomfilter;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Source: parts from https://www.baeldung.com/java-file-to-arraylist
 */

public class Reader {

    public ArrayList<String> readFileIntoArrayList(String fileName) throws IOException {
        ArrayList<String> words = new ArrayList<>();

        try (FileReader f = new FileReader(Application.class.getClassLoader().getResource(fileName).getFile())) {
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '\n') {
                    words.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                words.add(sb.toString());
            }
        }
        return words;
    }
}
