package com.mcp.server.mongo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "playerDtls")
public class PlayerDtls {

    String name;
    String category;

    public PlayerDtls(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
