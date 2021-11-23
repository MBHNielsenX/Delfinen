package Users;

public class Coach extends Admin{

    public Coach(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void registerSwimTime (){
        System.out.println("Fuck du hurtig brors.");
    }

    public void topFiveResults(){
        System.out.println("Mads' top 5 tider er; ");
    }
}
