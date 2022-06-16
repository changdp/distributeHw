package xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 *
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;

    //静态方法装配
    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("静态方法装配");
        return user;
    }
}


