package com.mcp.server.service;


import com.mcp.server.mongo.domain.PlayerDtls;
import com.mcp.server.mongo.domain.WaterTaskDtls;
import com.mcp.server.mongo.repo.CricketRepo;
import com.mcp.server.mongo.repo.WaterTaskRepo;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springaicommunity.mcp.annotation.McpProgressToken;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CricketService {

    Logger logger = LogManager.getLogger(CricketService.class);

    public enum PlayerCategory{Batsman, Bowler, AllRounder}

    @Autowired
    CricketRepo crcicketRepo;

    @Autowired
    WaterTaskRepo waterTaskRepo;

    @McpTool(description = "Creates a Player in PCC Database")
    public String createPlayer(McpSyncServerExchange exchange,
                               @McpToolParam(description = "Player First & Last Name") String playerName,
                               @McpToolParam(description = "Category, Batsman/ Bowler/ AllRounder") PlayerCategory playerCategory,
                               @McpProgressToken String progressToken) {

        logger.info("Cricket MCP Service. Creating New Player with Name {}", playerName);
        exchange.loggingNotification(McpSchema.LoggingMessageNotification.builder()
                .level(McpSchema.LoggingLevel.INFO)
                .data("Creating Player "+playerName).build());
        var player = new PlayerDtls(playerName, playerCategory.name());
        var id = crcicketRepo.save(player);
        logger.info("Created new Player with Id {}", id);
        exchange.progressNotification(new McpSchema.ProgressNotification(progressToken, 1.0, 1.0, "Player Created in DB with ID "+id));
        return "Player Created in Database";
    }

    @McpTool(description = "Record Water Task Done by a PCC Player")
    public String recordWaterTask(McpSyncServerExchange exchange,
                                  @McpToolParam(description = "Player First & Last Name") String playerName,
                                  @McpToolParam(description = "Date in MM/DD/YYYY format") String date ) {

        var id = waterTaskRepo.save(new WaterTaskDtls(playerName, date));

        logger.info("Water Task Recorded Player with Id {}", id);

        return "Water task recorded for "+playerName+" on "+date;
    }

    @McpTool(description = "Water Task Details Performed by PCC Players so far")
    public String getWaterTask() {
        try {
            logger.info("Getting Water Task Details");
            List<WaterTaskDtls> waterTaskDtls = new ArrayList<>();
            waterTaskRepo.findAll().iterator().forEachRemaining(waterTaskDtls::add);
            logger.info("Water Task Performed so far is {}", waterTaskDtls);
            return waterTaskDtls.toString();
        } catch (Exception e) {
            logger.info("Error while retrieving Water Task details {}", e.fillInStackTrace());
            return "Not Available at this moment";
        }

    }

}
