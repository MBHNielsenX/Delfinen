package Users;

public class Cashier extends Admin{

    public Cashier(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void checkRestance(){
        System.out.println("Skylder du penge brors???");
    }

    public void checkEstimatedIncome(){
        System.out.println("Jens sends his regards.");
    }
}
