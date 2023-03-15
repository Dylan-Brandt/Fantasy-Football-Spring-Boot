package com.football.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.football.services.PlayerService;

@Controller
public class FootballController {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/")
	public RedirectView home(Model model) {
		return new RedirectView("/Players?pos=All");
	}
	
	@GetMapping("/Players")
	public String players(@RequestParam("pos") String pos, Model model) {
		
		if(pos.equals("All")) {
			model.addAttribute("players", playerService.fetchAll());
			return "allPlayers";
		}
		else if(pos.equals("QB")) {
			model.addAttribute("players", playerService.fetchByPos("QB"));
			return "QBs";
		}
		else if(pos.equals("WR")) {
			model.addAttribute("players", playerService.fetchByPos("WR"));
			return "WRs";
		}
		else if(pos.equals("TE")) {
			model.addAttribute("players", playerService.fetchByPos("TE"));
			return "TEs";
		}
		else if(pos.equals("RB")) {
			model.addAttribute("players", playerService.fetchByPos("RB"));
			return "RBs";
		}
		
		return "allPlayers";
	}
	
	
}
