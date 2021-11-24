package FileReaderWriter;

import Members.SwimmingClubMember;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;



public class Writer {
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
        Format formatter = new SimpleDateFormat("dd-MM-yy");
        String dateOfBirth = formatter.format(member.getDateOfBirth());

        String memberInfo =
                "Member ID: " + String.valueOf(member.getMemberId()) + "\n" +
                "Name: " +member.getName() + "\n" +
                "Address: " + member.getAddress() + "\n" +
                "Email: " + member.getEmail() + "\n" +
                "Phone number: " + String.valueOf(member.getPhoneNumber()) + "\n" +
                "Date of birth: " + dateOfBirth;


        return memberInfo;
    }


}
