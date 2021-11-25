//Jens' kode
package Users;

import Members.SwimmingClubMember;

import java.util.ArrayList;

public class Cashier extends Admin{

    public Cashier(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void checkArrears(int memberId, ArrayList<SwimmingClubMember> allMembers){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:allMembers) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        }
        System.out.println("\n"+memberToCheck.getName()+" er DKK "+memberToCheck.getArrears()+" i restance.");
    }

    public void checkEstimatedIncome(ArrayList<SwimmingClubMember> allMembers){
        int estimatedIncome=0;
        for (SwimmingClubMember member:allMembers) {
            estimatedIncome+=member.getContingent();
        }
        System.out.println("\nEstimeret indkomst for i år er DKK "+estimatedIncome+",-");
    }

    public void registerContingentPayment(int memberId, double amountPayed, ArrayList<SwimmingClubMember> allMembers){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:allMembers) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        }
        memberToCheck.setArrears(memberToCheck.getArrears()-amountPayed);
        System.out.println("Betaling af DKK "+amountPayed+" er registreret for medlemmet, med medlemsID: "+memberId);
        System.out.println("Restbalance er DKK "+memberToCheck.getArrears());
    }
}
