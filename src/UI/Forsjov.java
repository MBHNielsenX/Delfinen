package UI;

import FileReaderWriter.GetUserInput;
import FileReaderWriter.Writer;
import Users.Chairman;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static FileReaderWriter.Reader.getMemberIdsFromFile;
import static FileReaderWriter.Reader.printMembersList;

public class Forsjov {
    public static void main(String[] args) {
        System.out.println("Hello World");
        ArrayList<String> memberIds = getMemberIdsFromFile();
        for (String string:memberIds) {
            System.out.println(string);

        }
        System.out.println(GetUserInput.integer());
    }
}
