package Users;

public class Chairman extends Admin{

    public Chairman(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void createNewMember(){
        System.out.println("New member oprettet BRORZ.");
    }

}
