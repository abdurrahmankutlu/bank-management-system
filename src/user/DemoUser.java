package user;

public class DemoUser extends BaseUser {

    public DemoUser(String firstName, String lastName, UserType userType) {
        super(firstName, lastName, userType,0.05,3);
    }

    public double getCutRate() {
        return cutRate;
    }
}
