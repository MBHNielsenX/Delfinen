package Users;

import FileReaderWriter.GetUserInput;
import Members.Junior;

public class Chairman extends Admin{
    public Chairman(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void createNewMember(){
        System.out.println("type in your name");
        String name = GetUserInput.string();
        System.out.println("Type in your address");
        String address = GetUserInput.string();
        System.out.println("type in your email");
        String email = GetUserInput.string();
        System.out.println("type in your phonenumber");
        int phoneNumber = GetUserInput.integer();
        System.out.println("Type in your birthdate; (01-03-94)");
        String birthdate = GetUserInput.string();

        Junior newJunior = new Junior(name,address,email,phoneNumber,birthdate);

        System.out.println(newJunior);

    }

}
