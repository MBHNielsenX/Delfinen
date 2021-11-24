package UI;

import Members.Senior;
import Users.Chairman;

import java.time.LocalDate;
import java.util.Date;

public class Forsjov {
    public static void main(String[] args) {

        Chairman mads = new Chairman("Mads","hej","jens.dk");
        Senior jens = new Senior("Jens Ryge","Vølundsgade 4","jens@politiken.dk",10203040,"10-5-96");

        //mads.createNewMember();
        Date date = new Date(120,10,20);
        Date dateTest = new Date(120,10,20);
        Date newDate = new Date();


        System.out.println(getAge(1950,12,10));

    }

    public static int getAge(int year, int month, int day) {
        Date now = new Date();
        int nowMonth = now.getMonth()+1;
        int nowYear = now.getYear()+1900;
        int result = nowYear - year;

        if (month > nowMonth) {
            result--;
        }
        else if (month == nowMonth) {
            int nowDay = now.getDate();

            if (day > nowDay) {
                result--;
            }
        }
        return result;
    }
}
