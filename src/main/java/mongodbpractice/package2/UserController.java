package mongodbpractice.package2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String saveUser(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
        return  userEntity.toString();
    }

    @GetMapping
    public List<UserEntity> findAllUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/associate")
    public List<UserEntity> findAssociateUsers() {
        return userService.findAssociateUsers();
    }

    @GetMapping("/senior")
    public List<UserEntity> findSeniorUsers() {
        return userService.findSeniorUsers();
    }

    @PutMapping("/increment/{name}")
    public UserEntity incrementSalary(@PathVariable String name) {
        return userService.incrementSalary(name);
    }

    @PutMapping("/update/{name}")
    public UserEntity updateUserDetails(@PathVariable String name, @RequestBody UserEntity userEntity) {
        return userService.updateUserDetails(name, userEntity);
    }

    @GetMapping("/complex")
    public List<UserEntity> getUsersOnComplexQuery() {
        return userService.complexQueryFindUsers();
    }
}
