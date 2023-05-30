package com.marketingapp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp1.entities.Lead;
import com.marketingapp1.repositories.LeadRepository;

@Service
public class LeadServiceimpl implements LeadService {
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void finddeleteById(long id) {
	leadRepo.deleteById(id);
		
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);	
		return findById.get();
	}

}