package xml;

public class InstanceUser implements UserFactory{
    @Override
    public User createUser() {
        return UserFactory.super.createUser();
    }
}
