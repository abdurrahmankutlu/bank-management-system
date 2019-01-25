package user;

public class DemoUser extends BaseUser {

    private static final double cutRate = 0.05;

    public DemoUser(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public  double getCutRate() {
        return cutRate;
    }
}
