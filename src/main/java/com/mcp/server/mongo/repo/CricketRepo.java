package com.mcp.server.mongo.repo;

import com.mcp.server.mongo.domain.PlayerDtls;
import org.springframework.data.repository.CrudRepository;

public interface CricketRepo extends CrudRepository<PlayerDtls, String> {}
