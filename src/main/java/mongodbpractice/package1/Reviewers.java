package mongodbpractice.package1;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Data
@NoArgsConstructor
public class Reviewers {

    private String name;

    private int rating;

    private boolean approved;
}
