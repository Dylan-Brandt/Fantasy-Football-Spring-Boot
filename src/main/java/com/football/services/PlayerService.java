package com.football.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.entities.Player;
import com.football.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	private final PlayerRepository playerRepository;
	
	@Autowired
	public PlayerService(PlayerRepository repository) {
		this.playerRepository = repository;
	}
	
	public Player fetchById(String id) {
		return playerRepository.fetchById(id);
	}
	
	public List<Player> fetchAll() {
		return playerRepository.fetchAll();
	}
	
	public List<Player> fetchByPos(String pos) {
		return playerRepository.fetchByPos(pos);
	}
	
	public List<Player> fetchByName(String name) {
		return playerRepository.fetchByName(name);
	}
	
	public List<Player> fetchByTeam(String team) {
		return playerRepository.fetchByTeam(team);
	}
}
