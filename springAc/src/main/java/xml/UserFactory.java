package xml;

public interface UserFactory {

    //实例方法装配
    default User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("实例方法装配");
        return user;
    }
}


