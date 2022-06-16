package xml;

public class AutowireFactory implements UserFactory {

    @Override
    public User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("AutowireFactory装配");
        return user;
    }
}


