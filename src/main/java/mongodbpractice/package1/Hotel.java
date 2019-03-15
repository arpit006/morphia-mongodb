package mongodbpractice.package1;

import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import dev.morphia.utils.IndexDirection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Document(collection = "Hotel")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Hotel {

    @Id
    private String id;

    private String hotelName;

    @Indexed(IndexDirection.ASC)
    private int pricePerNight;

    private Address address;

    private List<Reviewers> reviewers;
}
