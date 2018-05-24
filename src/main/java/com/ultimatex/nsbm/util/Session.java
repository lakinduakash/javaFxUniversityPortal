package com.ultimatex.nsbm.util;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.istack.internal.NotNull;
import com.ultimatex.nsbm.User;
import org.bson.Document;

public class Session {
    private static Session sessionInstance;

    private static String _email;

    private boolean valid;
    private User user;
    private MongoDatabase db;
    private String email;


    private Session session;

    private Session(@NotNull String email, @NotNull String password) {

        DatabaseHelper dh = DatabaseHelper.getInstance();
        db = dh.getDatabase();
        MongoCollection<Document> userCollection = db.getCollection("user");

        FindIterable<Document> findIterable = userCollection.find(new Document("email", email));

        Document user = findIterable.first();

        if (user == null) {
            sessionInstance = null;
            throw new UserNotFoundException();
        }

        if (password.equals(user.get("password"))) {
            valid = true;
            this.email = email;
            sessionInstance = this;
        } else {
            sessionInstance = null;
        }


    }

    public static Session getInstance(@NotNull String email, @NotNull String password) {
        if (sessionInstance == null || !email.equals(_email)) {
            new Session(email, password);
            _email = email;
            return sessionInstance;
        } else
            return sessionInstance;
    }

    public static void createInstance(String email, String password) {
        if (sessionInstance == null || !email.equals(_email)) {
            new Session(email, password);
            _email = email;
        }
    }

    public static void close() {
        sessionInstance = null;
    }

    public static Session getSession() {
        if (sessionInstance == null) {
            throw new InvalidSessionException();
        }
        return sessionInstance;
    }

    public static User getUser(Session session, MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("user");
        Document document = collection.find(new Document("email", Session.getSession().email)).first();
        String type = (String) document.get("type");

        if (type == null) {
            type = "";
        }

        if (User.TYPE_ADMIN.equals(type))
            return new AdminHelper(session.email, database);
        else
            return new StudentHelper(session.email, database);
    }

    public boolean isValid() {
        return valid;
    }

    public void logOut() {
        valid = false;
    }
}
