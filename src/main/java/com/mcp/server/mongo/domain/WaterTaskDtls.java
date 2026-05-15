package com.mcp.server.mongo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "waterTaskDtls")
public class WaterTaskDtls {

    private String playerName;
    private LocalDate date;

    public WaterTaskDtls(String playerName, LocalDate date) {
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
