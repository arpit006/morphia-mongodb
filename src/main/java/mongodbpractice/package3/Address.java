package mongodbpractice.package3;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
//@Embedded
    @Data
    @NoArgsConstructor
public class Address {

    private String city;

    private String country;

    @Override
    public String toString() {
        return "    {\n city: " + this.city + ",\n  country: " + this.country + "\n    }";
    }
}
