package mongodbpractice.package2;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class UserService {

    final Morphia morphia = new Morphia();
    final Datastore ds;
    UserService() {
        morphia.mapPackage("org.arpit.mongodbpractice.package2");
        ds = morphia.createDatastore(new MongoClient("localhost", 27017), "user_db");
    }

    void saveUser(UserEntity userEntity) {
        ds.save(userEntity);
    }

    UserEntity findUser(){
        return null;
    }

    public List<UserEntity> findAllUser() {
        Query<UserEntity> query = ds.createQuery(UserEntity.class);
        List<UserEntity> userEntityList = query.asList();
        return userEntityList;
    }

    public List<UserEntity> findAssociateUsers() {
        Query<UserEntity> query = ds.createQuery(UserEntity.class)
                .field("salary").lessThanOrEq(45000);
        return query.asList();
    }

    public List<UserEntity> findSeniorUsers() {
        Query<UserEntity> query = ds.createQuery(UserEntity.class)
                .field("salary").greaterThan(45000);

//        Query<UserEntity> query1 = ds.createQuery(UserEntity.class).filter("salary>=", 45000);
        return query.asList();
    }

    public UserEntity incrementSalary(String name) {
        Query<UserEntity> query = ds.createQuery(UserEntity.class).field("name").equal(name);
        UpdateOperations<UserEntity> updateQuery = ds.createUpdateOperations(UserEntity.class).inc("salary", 70000);
        ds.update(query, updateQuery);
        return ds.createQuery(UserEntity.class).field("name").equal(name).get();

    }

    public UserEntity updateUserDetails(String name, UserEntity userEntity) {
        Query<UserEntity> query = ds.createQuery(UserEntity.class).field("name").equal(name);
        UserEntity tempUser = query.get();
        UpdateOperations<UserEntity> updateQuery = ds.createUpdateOperations(UserEntity.class).set("name",name)
                .set("age", userEntity.getAge() == 0 ? tempUser.getAge() : userEntity.getAge())
                .set("email", userEntity.getEmail() == null ? tempUser.getEmail() : userEntity.getEmail())
                .set("number", userEntity.getNumber() == 0 ? tempUser.getNumber() : userEntity.getNumber());
        ds.update(query, updateQuery);
        return ds.createQuery(UserEntity.class).field("name").equal(name).get();
    }

    public List<UserEntity> complexQueryFindUsers() {
        Query<UserEntity> query = ds.createQuery(UserEntity.class);
        query.and(
                query.criteria("age").equal(23),
                query.criteria("number").equal(5473723)
        );
        return query.asList();
    }

    /**
     * To update value in the array(insert)
     * ds.createUpdateOpertaions(UserEntity.class).push("address",addressObj)
     *                                            .addToSet       //for unique values in the list
     *
     * To remove element from the array
     *                                            .removeFirst(array_name)
     *                                            .removeLast(array_name)
     *                                            .removeAll(array_name)
     *                                            .removeAll(array_name, number)
     *                                            .removeAll(array_name, Arrays.asList(1,2,3))
     */
}
