package com.football.dao;

import java.util.List;

import com.football.entities.Player;

public interface DaoInterface<T> {
	T fetchById(String id);
    
    List<Player> fetchAll();
    
//    void save(T t);
//    
//    void update(T t, String[] params);
//    
//    void delete(T t);
}
