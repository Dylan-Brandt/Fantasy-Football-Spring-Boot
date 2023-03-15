package com.football.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.football.entities.Player;

@Component
public interface PlayerDaoInterface extends DaoInterface<Player> {
	
	List<Player> fetchByPos(String pos);
	List<Player> fetchByName(String name);
	List<Player> fetchByTeam(String team);
}
