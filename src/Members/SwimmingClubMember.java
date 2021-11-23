package Members;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class SwimmingClubMember {
    private static ArrayList<Integer> existingMemberids = new ArrayList<>();

    private int memberid;
    private String name;
    private String address;
    private String email;
    private int phoneNumber;
    private Date dateOfBirth;

    public SwimmingClubMember(String name, String address, String email, int phoneNumber, String dateOfBirth) {
        Random rand = new Random();
        this.memberid = rand.nextInt(89999)+10000;
        while (existingMemberids.contains(this.memberid)){
            this.memberid = rand.nextInt(89999)+10000;
        }
        existingMemberids.add(this.memberid);

        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;

        String[] dateOfBirthArray = dateOfBirth.split("-");
        this.dateOfBirth = new Date(Integer.parseInt(dateOfBirthArray[0]), Integer.parseInt(dateOfBirthArray[1])+1, Integer.parseInt(dateOfBirthArray[2]));
    }

    @Override
    public String toString() {
        return "SwimmingClubMember{" +
                "memberid=" + memberid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
