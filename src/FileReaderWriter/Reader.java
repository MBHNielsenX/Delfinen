package FileReaderWriter;

import java.io.*;

public class Reader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt")); //Change filename
            String line;
            while((line = reader.readLine()) !=null)
                System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
