//Jens' kode
package Members;

import java.time.LocalDate;
import java.util.Date;

public class Junior extends SwimmingClubMember {
    public Junior(String name, String address, String email, int phoneNumber, LocalDate dateOfBirth, boolean isActive) {
        super(name, address, email, phoneNumber, dateOfBirth, isActive);
        if (isActive){
            setArrears(1000);
            setArrears(1000);
        } else{
            setArrears(500);
            setContingent(500);
        }
    }
}
