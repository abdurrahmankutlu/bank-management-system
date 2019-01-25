package user;

public class SuperUser extends BaseUser {

    private static final double cutRate = 0.00;

    public SuperUser(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public  double getCutRate() {
        return cutRate;
    }
}
