package com.ultimatex.nsbm.util;

import com.mongodb.client.MongoDatabase;
import com.ultimatex.nsbm.User;

public class AdminHelper extends User {

    private String email;

    public AdminHelper(String email, MongoDatabase database) {
        super(email, database);

        this.email = email;
    }


}
