package mongodbpractice.package2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */

@Component
public class RunnerClass implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("Himanshu");
        userEntity1.setAge(23);
        userEntity1.setEmail("him@gma.com");
        userEntity1.setNumber(7243642);
        userEntity1.setSalary(42000);

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setName("Shivansh");
        userEntity2.setAge(23);
        userEntity2.setEmail("shiv@gma.com");
        userEntity2.setNumber(724236642);
        userEntity2.setSalary(45000);

        UserEntity userEntity3 = new UserEntity();
        userEntity3.setName("Prabal");
        userEntity3.setAge(23);
        userEntity3.setEmail("prabal@gma.com");
        userEntity3.setNumber(80423842);
        userEntity3.setSalary(110000);

        userService.saveUser(userEntity1);
        userService.saveUser(userEntity2);
        userService.saveUser(userEntity3);
    }
}
