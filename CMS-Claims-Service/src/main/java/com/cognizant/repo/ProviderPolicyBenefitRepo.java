package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.helper.ProviderPolicy;
import com.cognizant.helper.ProviderPolicyBenefit;

@Repository
public interface ProviderPolicyBenefitRepo extends JpaRepository<ProviderPolicyBenefit, Long> {
	
	@Query(value = "select * from provider_policy p where p.benefits = :benefit",nativeQuery = true)
	public ProviderPolicyBenefit getProviderPolicyBenefit(@Param("benefit") String benefit);

}
