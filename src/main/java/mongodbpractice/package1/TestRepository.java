package mongodbpractice.package1;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Repository
public interface TestRepository extends MongoRepository<Hotel, String> {
}
