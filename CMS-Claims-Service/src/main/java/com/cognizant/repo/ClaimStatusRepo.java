package com.cognizant.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.helper.MemberSubmitClaim;
import com.cognizant.model.ClaimStatus;

@Repository
public interface ClaimStatusRepo extends JpaRepository<ClaimStatus, Long> {

	@Query(value = "select * from claimstatus c where c.claim_Id = :claimId AND c.policy_Id = :policyId AND c.member_Id = :memberId",nativeQuery = true)
	public ClaimStatus getClaimStatus(@Param("claimId") long claimId, @Param("policyId") long policyId, @Param("memberId")long memberId);
	
	@Query(value = "select * from claimstatus s where s.policy_Id = :policy_Id AND s.member_Id = :member_Id",nativeQuery = true)
	public ClaimStatus getClaimStatusUtil(@Param("policy_Id") long claimId, @Param("member_Id") long policyId);
	
}
