package com.capgemini.frs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capgemini.frs.entity.Tenant;

@Repository
public interface ITenantRepository extends JpaRepository<Tenant,Integer>{

	

}
