package FileReaderWriter;

import java.io.*;

public class Writer {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt")); //Change file name
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
