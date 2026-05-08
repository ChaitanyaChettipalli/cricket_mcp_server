package com.mcp.server.mongo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "waterTaskDtls")
public class WaterTaskDtls {

    private String playerName;
    private String date;

    public WaterTaskDtls(String playerName, String date) {
        this.playerName = playerName;
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WaterTaskDtls{");
        sb.append("playerName='").append(playerName).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
