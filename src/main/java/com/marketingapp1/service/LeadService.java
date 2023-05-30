package com.marketingapp1.service;

import java.util.List;

import com.marketingapp1.entities.Lead;

public interface LeadService {
	public void saveLead(Lead lead); 
	public List<Lead> getAllLeads();
	public void finddeleteById(long id);
	public Lead findLeadById(long id); 
	

}
