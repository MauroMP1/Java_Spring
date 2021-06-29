package net.iot.Home.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.iot.Home.service.ConectABM;
import net.iot.Home.service.ReadofUrl;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private ReadofUrl conect;
	private String estado = "off";
	private String estado1 = "off";
	
	
	@GetMapping("/home")
	public String getHome(Model model) {
		return "home";
	}
	
	@GetMapping("/livingoff")
	public String getHome1(Model model) {
		int dato = 0;
		int d = 1;
		String url1off = "http://183.153.0.45:3838/1/off";
		String result = conect.readFromUrl(url1off);
		System.out.println(result);
		if(result.contains("200")) {
			dato = 1;
			estado = "off";
		}		
		model.addAttribute("livingoff", dato);
		model.addAttribute("livingon", d );
		
		return "home";
	}
	
	@GetMapping("/livingon")
	public String getHome2(Model model) {
		int dato = 0;
		int d = 1;
		String url1on = "http://183.153.0.45:3838/1/on";
		String result = conect.readFromUrl(url1on);
		if(result.contains("200")) {
			dato = 1;
			estado = "on";
		}		
		model.addAttribute("livingon", dato);
		model.addAttribute("livingoff", d );
		
		return "home";
	}
	
	@GetMapping("/cobachaoff")
	public String getHome3(Model model) {
		int d = 1;
		int dato = 0;
		String url2off = "http://183.153.0.45:3838/2/off";
		String result = conect.readFromUrl(url2off);
		System.out.println(result);
		if(result.contains("200")) {
			dato = 1;
			estado1 = "off";
		}		
		model.addAttribute("cobachaoff", dato);
		model.addAttribute("cobachaon", d );
		
		return "home";
	}
	
	@GetMapping("/cobachaon")
	public String getHome4(Model model) {
		int d = 1;
		int dato = 0;
		String url2on = "http://183.153.0.45:3838/2/on";
		String result = conect.readFromUrl(url2on);
		if(result.contains("200")) {
			dato = 1;
			estado1 = "on";
		}		
		model.addAttribute("cobachaon", dato);
		model.addAttribute("cobachaoff", d );
		
		return "home";
	}
	
	
		
		
}
