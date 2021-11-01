package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.helper.MemberSubmitClaim;
import com.cognizant.helper.ProviderPolicy;
import com.cognizant.helper.ProviderPolicyBenefit;
import com.cognizant.model.ClaimStatus;
import com.cognizant.repo.ClaimStatusRepo;
import com.cognizant.service.ClaimService;
import com.cognizant.utility.ClaimStatusResult;
import com.cognizant.utility.ClaimStatusUtilResult;

@RestController
public class ClaimController {

	@Autowired
	private ClaimService claimService;

	@Autowired
	private ClaimStatusRepo claimStatusRepo;

	// Submit Claim Status(file)
	@PostMapping("/submitClaimStatus")
	public ClaimStatus SubmitClaimStatus(@RequestBody ClaimStatus claimStatus) {
		return this.claimService.updateStatus(claimStatus);
	}

	// GET: /getClaimStatus (Input: Claim_ID, Policy_ID, Member_ID | Output: Claim
	// Status, Claim Status Description)(file)
	//
	// @GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	// public ClaimStatusResult getClaimStatus(@PathVariable("claimId") long
	// claimId,@PathVariable("policyId") long policyId,@PathVariable("memberId")
	// long memberId){
	// ClaimStatus newclaimClaimStatus = claimStatusRepo.getClaimStatus(claimId,
	// policyId, memberId);
	// ClaimStatusResult claimStatusResult = new ClaimStatusResult();
	// claimStatusResult.setClaimStatus(newclaimClaimStatus.getClaimStatus());
	// claimStatusResult.setClaimDesc(newclaimClaimStatus.getStatusDes());
	// return claimStatusResult;
	// }

	// this will send data from claim to policy service
	@GetMapping("/getClaimStatusPolicy/{policyId}/{member_Id}")
	public ClaimStatusUtilResult getClaimStatusUtil(@PathVariable("policyId") long policyId,
			@PathVariable("member_Id") long member_Id) {
		ClaimStatus newclaimClaimStatus = claimStatusRepo.getClaimStatusUtil(policyId, member_Id);
		ClaimStatusUtilResult claimStatusUtilResult = new ClaimStatusUtilResult();
		claimStatusUtilResult.setPolicyId(newclaimClaimStatus.getPolicyId());
		claimStatusUtilResult.setMemberId(newclaimClaimStatus.getMemberId());
		return claimStatusUtilResult;

	}

	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ClaimStatusResult getClaimStatus(@PathVariable("claimId") long claimId,
			@PathVariable("policyId") String policyId, @PathVariable("memberId") String memberId) {
		MemberSubmitClaim memberSubmitClaim = claimService.getMemberSubmitClaim(policyId);
		ProviderPolicy providerPolicy = claimService.getProviderPolicy(policyId);
		ProviderPolicyBenefit providerBenefit = claimService.getProviderPolicyBenefit(providerPolicy.getBenefits());
		ClaimStatusResult claimStatusResult = new ClaimStatusResult();
		if ((memberSubmitClaim.getTotalClaimedAmt() < providerPolicy.getClaimAmt())
				&& (providerPolicy.getPolicyId().equalsIgnoreCase(providerBenefit.getPolicyId()))) {
			claimStatusResult.setClaimId(memberSubmitClaim.getClaimsId());
			claimStatusResult.setMemberId(memberSubmitClaim.getMemberId());
			claimStatusResult.setClaimStatus("Pending Action");
			claimStatusResult.setClaimDesc("Wait for Updates");
		} else {
			claimStatusResult.setClaimId(memberSubmitClaim.getClaimsId());
			claimStatusResult.setMemberId(memberSubmitClaim.getMemberId());
			claimStatusResult.setClaimStatus("Claim Rejected");
			claimStatusResult.setClaimDesc("Under Dispute");
		}
		return claimStatusResult;

	}

}
