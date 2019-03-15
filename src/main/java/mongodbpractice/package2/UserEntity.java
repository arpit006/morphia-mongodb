package mongodbpractice.package2;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Field;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Index;
import dev.morphia.annotations.Indexes;
import dev.morphia.annotations.Property;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Entity("users")
@Indexes(@Index(value = "salary", fields = @Field("salary")))
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    private ObjectId id;

    @Property(value = "user_name")
    private String name;

    @Property(value = "user_age")
    private int age;

    private String email;

//    @Indexed(IndexDirection.ASC)
    private double salary;

    private long number;


    @Override
    public String toString() {
        return "{\nname : " + this.name + ", \nage : "+ this.age +", \nemail : " +this.email +
                ", \nsalary : "+this.salary +", \nnumber : " +this.number +"\n }";
    }
}
