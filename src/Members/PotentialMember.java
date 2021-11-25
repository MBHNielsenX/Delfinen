//Mikkels kode
package Members;

public class PotentialMember {
    String name;
    String address;
    String email;
    int phoneNumber;
    String birthdate;

    public PotentialMember(String name){
        this.name = name;
    }
    public PotentialMember(String name, String address){
        this.name = name;
        this.address = address;
    }
    public PotentialMember(String name, String address, String email){
        this.name = name;
        this.address = address;
        this.email = email;
    }
    public PotentialMember(String name, String address, String email, int phoneNumber){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public PotentialMember(String name, String address, String email, int phoneNumber, String birthdate){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
    }


    public String getName() {
        return name;
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

    public String getBirthdate() {
        return birthdate;
    }
}
