package Users;

import FileReaderWriter.GetUserInput;

public class Chairman extends Admin{
    public Chairman(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void createNewMember(){
        System.out.println("type in name");
        String name = GetUserInput.string();
        System.out.println("Type in address");
        String address = GetUserInput.string();
        System.out.println("type in email");
        String email = GetUserInput.string();
        System.out.println("type in number");
        int phoneNumber = GetUserInput.integer();
        System.out.println("Type in your birthdate; (01-03-1994)");
        String birthdate = GetUserInput.string();



    }

}
