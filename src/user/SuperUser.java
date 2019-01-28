package user;

public class SuperUser extends BaseUser {

    public SuperUser(String firstName, String lastName, UserType userType) {
        super(firstName, lastName, userType,0.00,Integer.MAX_VALUE);
    }

    public double getCutRate() {
        return cutRate;
    }
}
