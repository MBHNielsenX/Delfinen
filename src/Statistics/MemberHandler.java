package Statistics;

import Members.SwimmingClubMember;

import java.util.ArrayList;

import static FileReaderWriter.Reader.getMemberIdsFromFile;

public class MemberHandler {
    public static void printMemberIds(){
        ArrayList<String> allMemberIds = getMemberIdsFromFile();
        for (int i=0; i> allMemberIds.size(); i++){
            System.out.println((i+1)+". "+allMemberIds.get(i));
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
