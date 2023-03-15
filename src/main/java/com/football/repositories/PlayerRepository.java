package com.football.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.football.entities.Player;
import com.football.entities.PlayerMapper;
import com.football.dao.PlayerDaoInterface;

@Repository
public class PlayerRepository implements PlayerDaoInterface {
	
    private final JdbcTemplate jdbcTemplate;
    
    private final String TABLE = "season22";
    
    private final String FETCH_BY_ID = "select * from " + TABLE + " where player_id = ?";
    private final String FETCH_ALL = "select * from " + TABLE;
    private final String FETCH_ALL_POS = "select * from " + TABLE + " where pos = ?";
    private final String FETCH_ALL_NAME = "select * from " + TABLE + " where player like ?";
    private final String FETCH_ALL_TEAM = "select * from " + TABLE + " where team = ?";
 
	@Autowired
    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
	@Override
	public Player fetchById(String id) {
		Player player = null;
		try {
			player = jdbcTemplate.queryForObject(FETCH_BY_ID, new PlayerMapper(), id);
		} catch(DataAccessException e) {
			throw e;
		}
        return player;
	}

	@Override
	public List<Player> fetchAll() {
		List<Player> players = null;
		try {
			players = jdbcTemplate.query(FETCH_ALL, new PlayerMapper());
		} catch(DataAccessException e) {
			throw e;
		}
		return players;
	}

	@Override
	public List<Player> fetchByPos(String pos) {
		List<Player> players = null;
		try {
			players = jdbcTemplate.query(FETCH_ALL_POS, new PlayerMapper(), pos);
		} catch(DataAccessException e) {
			throw e;
		}
		return players;
	}

	@Override
	public List<Player> fetchByName(String name) {
		List<Player> players = null;
		try {
			players = jdbcTemplate.query(FETCH_ALL_NAME, new PlayerMapper(), "%" + name + "%");
		} catch(DataAccessException e) {
			throw e;
		}
		return players;
	}

	@Override
	public List<Player> fetchByTeam(String team) {
		List<Player> players = null;
		try {
			players = jdbcTemplate.query(FETCH_ALL_TEAM, new PlayerMapper(), team);
		} catch(DataAccessException e) {
			throw e;
		}
		return players;
	}
}
