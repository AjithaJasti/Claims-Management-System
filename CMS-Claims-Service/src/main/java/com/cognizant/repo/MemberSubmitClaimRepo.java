package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.helper.MemberSubmitClaim;

@Repository
public interface MemberSubmitClaimRepo extends JpaRepository<MemberSubmitClaim, Long> {
	
	@Query(value = "select * from member_submit_claim ms where ms.policy_Id = :policyId",nativeQuery = true)
	public MemberSubmitClaim getMemberSubmitClaim(@Param("policyId") String policyId);

}
