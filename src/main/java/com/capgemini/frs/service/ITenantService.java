package com.capgemini.frs.service;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.frs.entity.Tenant;
import com.capgemini.frs.exception.TenantNotFoundException;

public interface ITenantService {

	Tenant addTenant(@Valid Tenant tenant);

	String updateTenant(@Valid Tenant tenant) throws TenantNotFoundException;

	Tenant deleteTenantBytenantid(@Valid int tenantid) throws TenantNotFoundException;

	List<Tenant> viewAllTenants();

	Tenant getTenantById(@Valid int tenantId) throws TenantNotFoundException;

	Tenant findTenantById(@Valid int tenantId) throws TenantNotFoundException;

}
