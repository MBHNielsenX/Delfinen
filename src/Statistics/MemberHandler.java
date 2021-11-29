package Statistics;

import Members.SwimmingClubMember;
import java.util.ArrayList;

public class MemberHandler {
    public static void printAllMembersNamesAndIds(ArrayList<SwimmingClubMember> allMembers){
        int listNo=1;
        for (SwimmingClubMember member:allMembers) {
            System.out.println(listNo+". Medlems-Id: "+member.getMemberId());
            System.out.println("Navn: "+member.getName());
            System.out.println();
            listNo++;
        }

        for (int i=0; i> allMembers.size(); i++){
            System.out.println((i+1)+". "+allMembers.get(i));
        }
    }

    public static SwimmingClubMember getMemberFromId(int memberId, ArrayList<SwimmingClubMember> allMembers){
        SwimmingClubMember memberToCheck = null;
        for (SwimmingClubMember member:allMembers) {
            if (member.getMemberId()==memberId){
                memberToCheck=member;
            }
        } return memberToCheck;
    }
}
