package com.capgemini.frs.serviceimplementation;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capgemini.frs.entity.Tenant;
import com.capgemini.frs.exception.TenantNotFoundException;
import com.capgemini.frs.repository.ITenantRepository;
import com.capgemini.frs.service.ITenantService;

@Component
@Service
public class TenantService implements ITenantService {

	@Autowired
	public ITenantRepository itenantRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return itenantRepository.save(tenant);
	}

	@Override
	public List<Tenant> viewAllTenants() {
		// TODO Auto-generated method stub
		return  itenantRepository.findAll();
	}

	@Override
	public String updateTenant(Tenant tenant) throws TenantNotFoundException {
		// TODO Auto-generated method stub
		String message = "Tenant is updated successfully";
		Tenant t = itenantRepository.save(tenant);
		if (t == null) {
			return "flat is not updated";
		}
		return message;
	}

	@Override
	public Tenant deleteTenantBytenantid(int tenantId) throws TenantNotFoundException {
		// TODO Auto-generated method stub
		try {
			Tenant tenant = itenantRepository.findById(tenantId).get();
			itenantRepository.delete(tenant);
			if (tenant != null) {
				return tenant;
			}
		} catch (NoSuchElementException e) {
			throw new TenantNotFoundException("tenant Id"  +tenantId + "not found");
		}
		return null;
	}


	@Override
	public Tenant findTenantById(@Valid int tenantId)  {
		// TODO Auto-generated method stub
		
		return null;
	}
	

	@Override
	public Tenant getTenantById(@Valid int tenantId) throws TenantNotFoundException {
		// TODO Auto-generated method stub
		try {
			Tenant tenant = itenantRepository.findById(tenantId).get();
			itenantRepository.save(tenant);
			if (tenant != null) {
				return tenant;
			}
		} catch (NoSuchElementException e) {
			throw new TenantNotFoundException("tenanrt Id" + tenantId + "not found");
		}
		return null;
	}


}
