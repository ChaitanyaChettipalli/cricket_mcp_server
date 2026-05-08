package com.mcp.server.mongo.repo;

import com.mcp.server.mongo.domain.WaterTaskDtls;
import org.springframework.data.repository.CrudRepository;

public interface WaterTaskRepo extends CrudRepository<WaterTaskDtls, String> {
}
