package FileReaderWriter;

import Members.SwimmingClubMember;
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


public class Writer { //Mads
    public static void write(SwimmingClubMember member) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Statistics/MemberList/Members.csv",true));
            writer.write(getMemberInfo(member) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMemberInfo(SwimmingClubMember member) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateOfBirth = formatter.format(member.getDateOfBirth());

        String memberInfo =
                "ID: " + String.valueOf(member.getMemberId()) + "\n" +
                "Name: " + member.getName() + "\n" +
                "Address: " + member.getAddress() + "\n" +
                "Email: " + member.getEmail() + "\n" +
                "Phone number: " + String.valueOf(member.getPhoneNumber()) + "\n" +
                "Date of birth: " + dateOfBirth + "\n" +
                "Contingent: " + member.getContingent() + "\n" +
                "Arrears: " + member.getArrears() + "\n" +
                "Is member active: " + booleanToString(member.isActive()) + "\n" +
                "Is member competitive: " + booleanToString(member.isCompetitive()) + "\n";

        return memberInfo;
    }

    public static String booleanToString(boolean trueOrFalse) {
        String yesOrNo;
        if (trueOrFalse == true) {
            yesOrNo = "Yes";
        } else {
            yesOrNo = "No";
        }

        return yesOrNo;
    }



}
