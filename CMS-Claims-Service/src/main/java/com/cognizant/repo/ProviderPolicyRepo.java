package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.helper.ProviderPolicy;

@Repository
public interface ProviderPolicyRepo extends JpaRepository<ProviderPolicy, Long> {

	@Query(value = "select * from provider_policy pp where pp.policy_Id = :policyId", nativeQuery = true)
	public ProviderPolicy getProviderPolicy(@Param("policyId") String policyId);

}
