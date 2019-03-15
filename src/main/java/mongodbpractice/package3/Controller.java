package mongodbpractice.package3;

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
@RequestMapping("/person")
public class Controller {

    @Autowired
    private PersonService service;

    @PostMapping
    public String save(@RequestBody Person person) {
        return service.savePerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return service.getAllPersons();
    }

    @GetMapping("/senior")
    public List<Person> getSeniorPerson() {
        return service.getSeniorPerson();
    }

    @GetMapping("/associate")
    public List<Person> getAssociatePerson() {
        return service.getAssociatePerson();
    }

    @PutMapping("/addmobile/{name}/{mobile}")
    public Person addMobileNo(@PathVariable String name, @PathVariable Long mobile) {
        return service.addMobileNo(mobile, name);
    }

    @GetMapping("/complexquery/{salary}/{age}")
    public List<Person> findPersonBasedOnComplexQuery(@PathVariable Double salary, @PathVariable int age) {
        return service.findPersonBasedOnComplexQuery(salary,age);
    }

    @PutMapping("/increaseage/{name}/{age}")
    public Person increasePersonAge(@PathVariable String name, @PathVariable int age) {
        return service.increasePersonAge(name, age);
    }

    @PutMapping("/decreaseage/{name}/{age}")
    public Person decreasePersonAge(@PathVariable String name, @PathVariable int age) {
        return service.decreasePersonAge(name, age);
    }

    @GetMapping("/complexquery2/{salary}/{age}")
    public List<Person> findPersonBasedOnComplexQueryExample2(@PathVariable Double salary, @PathVariable int age) {
        return service.findPersonBasedOnComplexQueryExample2(salary, age);
    }

    @PutMapping("/updateperson/{name}")
    public Person updatePersonDetails(@PathVariable String name, @RequestBody Person person) {
        return service.updatePersonDetails(person, name);
    }

    @PutMapping("/updateaddress/{name}")
    public Person updateAddress(@PathVariable String name, @RequestBody Address address) {
        return service.updateAddress(name, address);
    }

    @PutMapping("/addtoset/{name}/{mobile}")
    public Person addValueToArrayAsSet(@PathVariable String name, @PathVariable Long mobile) {
        return service.addValueToArrayAsSet(name, mobile);
    }

    @PutMapping("/removefirst/{name}")
    public Person removeFirstElementFromTheArray(@PathVariable String name) {
        return service.removeFirstElementFromTheArray(name);
    }

    @PutMapping("/removelast/{name}")
    public Person removeLastElementFromTheArray(@PathVariable String name) {
        return service.removeLastElementFromTheArray(name);
    }

    @PutMapping("/removeall/{name}/{mobile}")
    public Person removeAlOccurencesOfTheGivenElementInTheArray(@PathVariable String name, @PathVariable Long mobile) {
        return service.removeAlOccurencesOfTheGivenElementInTheArray(name, mobile);
    }

    @PutMapping("/updatefirst")
    public Person updateFirstPerson() {
        return service.updateFirstPerson();
    }

    @PutMapping("/updatelast")
    public Person updateLastPerson() {
        return service.updateLastPerson();
    }





}
