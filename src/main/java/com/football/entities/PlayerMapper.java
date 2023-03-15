package com.football.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlayerMapper implements RowMapper<Player> {

	@Override
	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Player player = new Player();
		
		player.setPlayerId(rs.getString("player_id"));
		player.setPos(rs.getString("pos"));
		player.setName(rs.getString("player"));
		player.setTeam(rs.getString("team"));
		player.setPassCmp(rs.getInt("pass_cmp"));
		player.setPassAtt(rs.getInt("pass_att"));
		player.setPassYds(rs.getInt("pass_yds"));
		player.setPassTd(rs.getInt("pass_td"));
		player.setPassInt(rs.getInt("pass_int"));
		player.setRushAtt(rs.getInt("rush_att"));
		player.setRushYds(rs.getInt("rush_yds"));
		player.setRushTd(rs.getInt("rush_td"));
		player.setTargets(rs.getInt("targets"));
		player.setRec(rs.getInt("rec"));
		player.setRecYds(rs.getInt("rec_yds"));
		player.setRecTd(rs.getInt("rec_td"));
		player.setFumblesLost(rs.getInt("fumbles_lost"));
		player.setTotalRetTd(rs.getInt("total_ret_td"));
		player.setTwoPtConversion(rs.getInt("two_point_conv"));
		player.setFumbleRecoveryTd(rs.getInt("offensive_fumble_recovery_td"));
		player.setPasserRating(rs.getDouble("pass_rating"));

		return player;
	}

}
