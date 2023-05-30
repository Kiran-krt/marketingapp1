package com.marketingapp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.marketingapp1.dto.LeadDto;
import com.marketingapp1.entities.Lead;
import com.marketingapp1.service.LeadService;
import com.marketingapp1.utility.EmailService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	@Autowired
	private EmailService emailService;
	
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLead() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String  saveLead(@ModelAttribute  Lead lead,Model model) {
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "Text", "Welcome");
		model.addAttribute("msg","Record is saved");
		return "create_lead";
	}
	
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String  getAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		
		return "search_result";
		
	}
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") long id,Model model) {
		leadService.finddeleteById(id);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		
		return "search_result";
	}
	
	@RequestMapping("/update")
	public String getLeadById(@RequestParam("id") long id,Model model) {
		Lead lead=leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "update_Lead";
		
		
	}
	
	@RequestMapping("/updatelead")
	public String updateLead(LeadDto dto,Model model) {
		Lead lead=new Lead();
		lead.setId(dto.getId());
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadService.saveLead(lead);
		
		List<Lead> leads = leadService.getAllLeads();

		model.addAttribute("leads", leads);
		return "search_result";

		
		
	}

}
