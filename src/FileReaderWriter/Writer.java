package FileReaderWriter;

import Members.SwimmingClubMember;
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Writer { //Mads
    public static void write(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/FileReaderWriter/Members.csv",true));
            writer.write("_" + "\n" + getMemberInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMemberInfo(SwimmingClubMember member) {
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateOfBirth = formatter.format(member.getDateOfBirth());

        String memberInfo =
                "ID: " + String.valueOf(member.getMemberId()) + "\n" +
                "Name: " + member.getName() + "\n" +
                "Address: " + member.getAddress() + "\n" +
                "Email: " + member.getEmail() + "\n" +
                "Phone number: " + String.valueOf(member.getPhoneNumber()) + "\n" +
                "Date of birth: " + dateOfBirth;

        //Remember to input "isCompetitive
        //isActive
        return memberInfo;
    }


}
