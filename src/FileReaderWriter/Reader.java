package FileReaderWriter;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt")); //Change filename
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
