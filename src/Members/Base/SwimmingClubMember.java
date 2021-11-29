//Primært Jens' kode
package Members.Base;

import IO.FileReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class SwimmingClubMember {
    private static ArrayList<Integer> existingMemberIds = new ArrayList<>();

    private int memberId;
    private String name;
    private String address;
    private String email;
    private int phoneNumber;
    private LocalDate dateOfBirth;
    private int contingent;
    private double arrears;
    private boolean isActive;
    private boolean isCompetitive = false;
    private double butterflyTime;
    private double backstrokeTime;
    private double breaststrokeTime;
    private double freestyleTime;


    public SwimmingClubMember(String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, boolean isActive) {
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

    public SwimmingClubMember(int memberId, String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, int contingent, double arrears, boolean isActive, boolean isCompetitive) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.contingent = contingent;
        this.arrears = arrears;
        this.isActive = isActive;
        this.isCompetitive = isCompetitive;
    }

    @Override
    public String toString() {
        return "SwimmingClubMember{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth + //Skal formatteres til at stå pænt
                ", contingent=" + contingent +
                ", arrears=" + arrears +
                ", isActive=" + isActive +
                ", isCompetitive=" + isCompetitive +
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    public void setCompetitive(boolean competitive) {
        isCompetitive = competitive;
    }

    public void setIsActive(boolean active){
        isActive = active;
    }

    public void setButterflyTime(double butterflyTime) {
        this.butterflyTime = butterflyTime;
    }

    public void setBackstrokeTime(double backstrokeTime) {
        this.backstrokeTime = backstrokeTime;
    }

    public void setBreaststrokeTime(double breaststrokeTime) {
        this.breaststrokeTime = breaststrokeTime;
    }

    public void setFreestyleTime(double freestyleTime) {
        this.freestyleTime = freestyleTime;
    }


    public static ArrayList<Integer> getExistingMemberIds() {
        return existingMemberIds;
    }

    public double getButterflyTime() {
        return butterflyTime;
    }

    public double getBackstrokeTime() {
        return backstrokeTime;
    }

    public double getBreaststrokeTime() {
        return breaststrokeTime;
    }

    public double getFreestyleTime() {
        return freestyleTime;
    }

    public static void addExistingMemberIdsToStaticArraylist() {
        ArrayList<String> grabbedMemberIds = FileReader.getMemberIdsFromFile();
        for (String currentId:grabbedMemberIds) {
            String[] currentIdArray = currentId.split(": ");
            int idInt = Integer.parseInt(currentIdArray[1]);
            existingMemberIds.add(idInt);
        }
    }
}
