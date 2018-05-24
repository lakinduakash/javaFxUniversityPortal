package com.ultimatex.nsbm;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ultimatex.nsbm.util.DatabaseHelper;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Updates.rename;
import static com.mongodb.client.model.Updates.set;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class NsbmTest {


    private DatabaseHelper mongoCon = DatabaseHelper.getInstance();
    private MongoClient mongoClient = mongoCon.getMongoClient();


    @Test
    public void testDbCon() {
        MongoClient mongoClient = mongoCon.getMongoClient();
        Assert.assertThat(mongoClient, is(notNullValue()));
    }


    @Test
    public void shouldGetADatabaseFromTheMongoClient() throws Exception {
        // Given
        // TODO any setup

        // When
        //TODO get the database from the client
        MongoDatabase database = mongoClient.getDatabase("nsbm");

        // Then
        assertThat(database, is(notNullValue()));
    }

    @Test
    public void shouldGetACollectionFromTheDatabase() throws Exception {
        // Given
        // TODO any setup

        // When
        // TODO get collection
        MongoCollection collection = mongoClient.getDatabase("nsbm").getCollection("student");
        System.out.print(collection.getNamespace());

        // Then
        assertThat(collection, is(notNullValue()));
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToUseMongoClientAfterItHasBeenClosed() throws UnknownHostException {
        // Given
        MongoClient mongoClient = new MongoClient();

        // When
        // TODO close the mongoClient
        mongoClient.close();

        // Then
        mongoClient.getDatabase("SomeDatabase").getCollection("coll").insertOne(new Document("field", "value"));
    }

    @Test
    public void shouldTurnAPersonIntoADBObject() {
        // Given
        Person bob = new Person("bob", "Bob The Amazing", new AddressTest("123 Fake St", "LondonTown", 1234567890), Arrays.asList(27464, 747854));

        // When
        Document bobAsDBObject = PersonAdaptor.toDocument(bob);

        // Then
        String expectedDBObject = "{" +
                " \"_id\" : \"bob\"," +
                " \"name\" : \"Bob The Amazing\"," +
                " \"address\" : {" +
                " \"street\" : \"123 Fake St\"," +
                " \"city\" : \"LondonTown\"," +
                " \"phone\" : 1234567890" +
                " }," +
                " \"books\" : [27464, 747854]" +
                " }";
        assertThat(bobAsDBObject.toJson(), is(expectedDBObject));
    }

    @Test
    public void shouldBeAbleToSaveAPerson() throws UnknownHostException {
        // Given
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("Examples");
        MongoCollection<Document> collection = database.getCollection("people");

        Person charlie = new Person("charlie222", "Charles", new AddressTest("74 That Place", "LondonTown", 1234567890), Arrays.asList(1, 74));
        Person akash = new Person("akash222", "Akash", new AddressTest("74 That Place", "LondonTown", 1234567890), Arrays.asList(1, 74));

        // When
        // TODO: insert Charlie into the collection
        Document bobAsDBObject = PersonAdaptor.toDocument(charlie);
        Document akashAsDBObject = PersonAdaptor.toDocument(akash);
        collection.insertOne(bobAsDBObject);
        collection.insertOne(akashAsDBObject);

        // Then
        assertThat(collection.count(), is(2L));

        // Clean up
        database.drop();
    }


    @Test
    public void find() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("nsbm");
        MongoCollection collection = database.getCollection("student");

        long count = collection.count(new Document("name.first", "Lakindu"));

        assertThat(count, is(1L));

    }

    @Test
    public void updateStudent() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("nsbm");
        MongoCollection<Document> collection = database.getCollection("student");

        Document filter = new Document("name.first", "Lakindu");

        collection.updateOne(filter, set("age", 28));

        System.out.println(rename("age", "aa").toString());

        FindIterable<Document> findIterable = collection.find(filter);

        Document re = findIterable.first();

        int a = (int) re.get("age");
        assertThat(a, is(28));
    }

    @Test
    public void insertDate() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("nsbm");
        MongoCollection<Document> collection = database.getCollection("student");

        Document filter = new Document("name.first", "Lakindu");

        collection.updateOne(filter, set("date", new Date()));
    }

}


class Person {
    private final String id;
    private final String name;
    private final AddressTest address;
    private final List<Integer> bookIds;

    public Person(final String id, final String name, final AddressTest address, final List<Integer> bookIds) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bookIds = bookIds;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AddressTest getAddress() {
        return address;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }


    //useful for testing

    @Override
    public String toString() {
        return "Person{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", address=" + address
                + ", bookIds=" + bookIds
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (!address.equals(person.address)) {
            return false;
        }
        if (!bookIds.equals(person.bookIds)) {
            return false;
        }
        if (!id.equals(person.id)) {
            return false;
        }
        if (!name.equals(person.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + bookIds.hashCode();
        return result;
    }
}


class AddressTest {
    private final String street;
    private final String town;
    private final int phone;

    public AddressTest(final String street, final String town, final int phone) {
        this.street = street;
        this.town = town;
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public int getPhone() {
        return phone;
    }
}


/**
 * This Adaptor allows us to separate our domain object, Person, from our library-specific classes, in this case the MongoDB-specific
 * DBObject.
 */
final class PersonAdaptor {

    public static final Document toDocument(Person person) {
        return new Document("_id", person.getId()).append("name", person.getName())
                .append("address", new BasicDBObject("street", person.getAddress().getStreet())
                        .append("city", person.getAddress().getTown())
                        .append("phone", person.getAddress().getPhone()))
                .append("books", person.getBookIds());
    }
}


