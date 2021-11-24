package Members;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class SwimmingClubMember {
    private static ArrayList<Integer> existingMemberIds = new ArrayList<>();

    private int memberId;
    private String name;
    private String address;
    private String email;
    private int phoneNumber;
    private Date dateOfBirth;
    private int contingent;
    private double arrears;
    private boolean isActive;


    public SwimmingClubMember(String name, String address, String email, int phoneNumber, Date dateOfBirth, boolean isActive) {
        Random rand = new Random();
        this.memberId = rand.nextInt(89999)+10000;
        while (existingMemberIds.contains(this.memberId)){
            this.memberId = rand.nextInt(89999)+10000;
        }
        existingMemberIds.add(this.memberId);

        this.isActive = isActive;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contingent = 0;
        this.arrears =0;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "SwimmingClubMember{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public int getMemberId() {
        return memberId;
    }

    public void setArrears(double arrears) {
        this.arrears = arrears;
    }

    public void setContingent(int contingent) {
        this.contingent = contingent;
    }

    public String getName() {
        return name;
    }

    public double getArrears() {
        return arrears;
    }

    public int getContingent() {
        return contingent;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
