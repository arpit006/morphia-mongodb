package mongodbpractice.package3;

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
public class PersonService {

    final Morphia morphia;

    final Datastore ds;

    PersonService() {
        morphia = new Morphia();
        morphia.mapPackage("org.arpit.mongodbpractice.package3");
        ds = morphia.createDatastore(new MongoClient("localhost", 27017), "person_db");
    }

    public String savePerson(Person person) {
        ds.save(person);
        return person.toString();
    }

    public List<Person> getAllPersons() {
        Query<Person> query = ds.createQuery(Person.class);
        return query.asList();
    }

    public List<Person> getSeniorPerson() {
//        Query<Person> query = ds.createQuery(Person.class).field("salary").greaterThan(50000);
        Query<Person> query1 = ds.createQuery(Person.class).filter("salary >", 50000);
        return query1.asList();
    }

    public List<Person> getAssociatePerson() {
        Query<Person> query = ds.createQuery(Person.class).field("salary").lessThanOrEq(50000);
        return query.asList();
    }

    public Person addMobileNo(Long mobileno, String name) {
        Query<Person> query = ds.createQuery(Person.class).field("name").equal(name);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class).push("phoneNumber", mobileno);
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).field("name").equal(name).get();
    }

    public List<Person> findPersonBasedOnComplexQuery(Double salary, int age) {
        Query<Person> query = ds.createQuery(Person.class);
        query.and(
                query.criteria("salary").greaterThan(salary),
                query.criteria("age").greaterThanOrEq(age)
        );
        return query.asList();
    }

    public Person increasePersonAge(String name, int age) {
        Query<Person> query = ds.createQuery(Person.class).field("name").equal(name);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class)
                .inc("age", age);
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).filter("name", name).get();
    }

    public Person decreasePersonAge(String name, int age) {
        Query<Person> query = ds.createQuery(Person.class).filter("name", name);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class)
                .dec("age", age);
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).filter("name", name).get();
    }

    public List<Person> findPersonBasedOnComplexQueryExample2(Double salary, int age) {
        Query<Person> query = ds.createQuery(Person.class)
                .field("salary").greaterThan(salary)
                .field("age").greaterThanOrEq(age);
        return query.asList();
    }

    public Person updatePersonDetails(Person person, String name) {
        Query<Person> query = ds.createQuery(Person.class).field("name").equal(name);
        Person tempPerson = query.get();
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class)
                .set("name", tempPerson.getName())
                .set("age", person.getAge() == 0 ? tempPerson.getAge() : person.getAge())
                .set("salary", person.getSalary() == 0.0 ? tempPerson.getSalary() : person.getSalary());
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).field("name").equal(name).get();
    }

    public Person updateAddress(String name, Address address) {
        Query<Person> query = ds.createQuery(Person.class).filter("name", name);
        Person tempPerson = query.get();
        Address tempAddress = tempPerson.getAddress();
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class)
                .set("address.city", address.getCity() == null ? tempAddress.getCity() : address.getCity())
                .set("address.country", address.getCountry() == null ? tempAddress.getCountry() : address.getCountry());
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).filter("name", name).get();
    }

    public Person addValueToArrayAsSet(String name, Long mobileNo) {
        Query<Person> query = ds.createQuery(Person.class).filter("name", name);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class)
                .addToSet("phoneNumber", mobileNo);
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).filter("name", name).get();
    }

    public Person removeFirstElementFromTheArray(String name) {
        Query<Person> query = ds.createQuery(Person.class).filter("name", name);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class).removeFirst("phoneNumber");
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).filter("name", name).get();
    }

    public Person removeLastElementFromTheArray(String name) {
        Query<Person> query = ds.createQuery(Person.class).filter("name", name);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class)
                .removeLast("phoneNumber");
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).filter("name", name).get();
    }

    public Person removeAlOccurencesOfTheGivenElementInTheArray(String name, Long value) {
        Query<Person> query = ds.createQuery(Person.class).filter("name", name);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class)
                .removeAll("phoneNumber", value);
        ds.update(query, updateOperations);
        return ds.createQuery(Person.class).filter("name", name).get();
    }

    public Person updateFirstPerson() {
        Query<Person> query = ds.createQuery(Person.class);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class).inc("age", 2);
        ds.updateFirst(ds.find(Person.class).order("age"), updateOperations);
        return ds.find(Person.class).order("age").get();    }

    public Person updateLastPerson() {
        Query<Person> query = ds.createQuery(Person.class);
        UpdateOperations<Person> updateOperations = ds.createUpdateOperations(Person.class).inc("age", 3);
        ds.updateFirst(ds.find(Person.class).order("-age"), updateOperations);
        return ds.find(Person.class).order("-age").get();
    }

}














