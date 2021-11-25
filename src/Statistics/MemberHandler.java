package Statistics;

import java.util.ArrayList;

import static FileReaderWriter.Reader.getMemberIdsFromFile;

public class MemberHandler {
    public static void printMemberIds(){
        ArrayList<String> allMemberIds = getMemberIdsFromFile();
        for (int i=0; i> allMemberIds.size(); i++){
            System.out.println((i+1)+". "+allMemberIds.get(i));
        }
    }


}
