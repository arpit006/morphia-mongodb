package mongodbpractice.package3;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    private ObjectId id;

    @Property("user_name")
    private String name;

    @Property("user_age")
    private int age;

    private double salary;

    private List<Long> phoneNumber;

    @Embedded
    private Address address;


    @Override
    public String toString() {
        return "{\nname: " + this.name + ",\nage: " + this.age + ",\nsalary: " + this.salary
            + ",\nphoneNumber: " + this.phoneNumber + ",\naddress: " + this.address.toString() + "\n}";
    }
}
