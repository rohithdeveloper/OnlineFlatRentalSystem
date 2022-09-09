package com.capgemini.frs.controller;

import java.util.List;





import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.frs.entity.Tenant;
import com.capgemini.frs.exception.TenantNotFoundException;
import com.capgemini.frs.service.ITenantService;





@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	ITenantService tenantService;

// Add tenants

	@PostMapping("/add-tenants")
	public ResponseEntity<Tenant> addTenant(@Valid @RequestBody Tenant tenant) {
		Tenant result = tenantService.addTenant(tenant);
		if (result != null) {
			return new ResponseEntity<Tenant>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Tenant>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//  update tenants

	@PutMapping("/tenants")  
	public ResponseEntity<String> updateTenant(@Valid @RequestBody Tenant tenant) throws TenantNotFoundException{
		String list = tenantService.updateTenant(tenant);  
		if(list!=null) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
// Delete tenants

	@DeleteMapping("/delete-tenants/{tenantid}")
	public ResponseEntity<?> deleteTenantBytenantid(@Valid @PathVariable int tenantid) throws TenantNotFoundException {
		Tenant result = tenantService.deleteTenantBytenantid(tenantid);
		if (result!=null)
			return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


	
	@GetMapping("/tenants")
	public ResponseEntity<List<Tenant>> viewAllTenants() {
		List<Tenant> result = tenantService.viewAllTenants();
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// view tenant by id

	@GetMapping("/get-tenant-by-id/{tenantId}")
	public ResponseEntity<Tenant> getTenantById(@Valid @PathVariable("tenantId") int tenantId)
			throws TenantNotFoundException {
		Tenant result = tenantService.getTenantById(tenantId);
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}