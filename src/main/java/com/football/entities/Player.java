package com.football.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String playerId;
	private String pos;
	private String name;
	private String team;
	private int passCmp;
	private int passAtt;
	private int passYds;
	private int passTd;
	private int passInt;
	private int rushAtt;
	private int rushYds;
	private int rushTd;
	private int targets;
	private int rec;
	private int recYds;
	private int recTd;
	private int fumblesLost;
	private int totalRetTd;
	private int twoPtConversion;
	private int fumbleRecoveryTd;
	private double passerRating;
	
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getPassCmp() {
		return passCmp;
	}
	public void setPassCmp(int passCmp) {
		this.passCmp = passCmp;
	}
	public int getPassAtt() {
		return passAtt;
	}
	public void setPassAtt(int passAtt) {
		this.passAtt = passAtt;
	}
	public int getPassYds() {
		return passYds;
	}
	public void setPassYds(int passYds) {
		this.passYds = passYds;
	}
	public int getPassTd() {
		return passTd;
	}
	public void setPassTd(int passTd) {
		this.passTd = passTd;
	}
	public int getPassInt() {
		return passInt;
	}
	public void setPassInt(int passInt) {
		this.passInt = passInt;
	}
	public int getRushAtt() {
		return rushAtt;
	}
	public void setRushAtt(int rushAtt) {
		this.rushAtt = rushAtt;
	}
	public int getRushYds() {
		return rushYds;
	}
	public void setRushYds(int rushYds) {
		this.rushYds = rushYds;
	}
	public int getRushTd() {
		return rushTd;
	}
	public void setRushTd(int rushTd) {
		this.rushTd = rushTd;
	}
	public int getTargets() {
		return targets;
	}
	public void setTargets(int targets) {
		this.targets = targets;
	}
	public int getRec() {
		return rec;
	}
	public void setRec(int rec) {
		this.rec = rec;
	}
	public int getRecYds() {
		return recYds;
	}
	public void setRecYds(int recYds) {
		this.recYds = recYds;
	}
	public int getRecTd() {
		return recTd;
	}
	public void setRecTd(int recTds) {
		this.recTd = recTds;
	}
	public int getFumblesLost() {
		return fumblesLost;
	}
	public void setFumblesLost(int fumblesLost) {
		this.fumblesLost = fumblesLost;
	}
	public int getTotalRetTd() {
		return totalRetTd;
	}
	public void setTotalRetTd(int totalRetTds) {
		this.totalRetTd = totalRetTds;
	}
	public int getTwoPtConversion() {
		return twoPtConversion;
	}
	public void setTwoPtConversion(int twoPtConversion) {
		this.twoPtConversion = twoPtConversion;
	}
	public int getFumbleRecoveryTd() {
		return fumbleRecoveryTd;
	}
	public void setFumbleRecoveryTd(int fumbleRecoveryTd) {
		this.fumbleRecoveryTd = fumbleRecoveryTd;
	}
	public double getPasserRating() {
		return passerRating;
	}
	public void setPasserRating(double passerRating) {
		this.passerRating = passerRating;
	}
	
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", pos=" + pos + ", name=" + name + ", team=" + team + ", passCmp="
				+ passCmp + ", passAtt=" + passAtt + ", passYds=" + passYds + ", passTd=" + passTd + ", passInt="
				+ passInt + ", rushAtt=" + rushAtt + ", rushYds=" + rushYds + ", rushTd=" + rushTd + ", targets="
				+ targets + ", rec=" + rec + ", recYds=" + recYds + ", recTd=" + recTd + ", fumblesLost=" + fumblesLost
				+ ", totalRetTd=" + totalRetTd + ", twoPtConversion=" + twoPtConversion + ", fumbleRecoveryTd="
				+ fumbleRecoveryTd + ", passerRating=" + passerRating + "]";
	}
	
	public double getFantasyPts() {
		Double points = (this.passYds * 0.04) +
				(this.passTd * 4.0) +
				(this.rushYds * 0.1) +
				(this.rushTd * 6.0) +
				(this.rec * 1.0) +
				(this.recYds * 0.1) +
				(this.recTd * 6.0) +
				(this.twoPtConversion * 2.0) +
				(this.fumbleRecoveryTd * 6.0) +
				(this.totalRetTd * 6.0) -
				(this.fumblesLost * 2.0) -
				(this.passInt * 2.0);

		return BigDecimal.valueOf(points).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
}
