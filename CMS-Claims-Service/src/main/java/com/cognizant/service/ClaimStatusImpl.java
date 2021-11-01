package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.helper.MemberSubmitClaim;
import com.cognizant.helper.ProviderPolicy;
import com.cognizant.helper.ProviderPolicyBenefit;
import com.cognizant.model.ClaimStatus;
import com.cognizant.repo.ClaimStatusRepo;
import com.cognizant.repo.MemberSubmitClaimRepo;
import com.cognizant.repo.ProviderPolicyBenefitRepo;
import com.cognizant.repo.ProviderPolicyRepo;

@Service
public class ClaimStatusImpl implements ClaimService {

	@Autowired
	private ClaimStatusRepo claimStatusRepo;

	@Autowired
	private MemberSubmitClaimRepo memberSubmitClaimRepo;

	@Autowired
	private ProviderPolicyRepo providerPolicyRepo;
	
	@Autowired
	private ProviderPolicyBenefitRepo providerPolicyBenefitRepo;

	@Override
	public ClaimStatus updateStatus(ClaimStatus claimStatus) {
		return this.claimStatusRepo.save(claimStatus);
	}

	@Override
	public MemberSubmitClaim getMemberSubmitClaim(String policyId) {
		MemberSubmitClaim newmemberSubmitClaim = memberSubmitClaimRepo.getMemberSubmitClaim(policyId);
		return newmemberSubmitClaim;
	}


	@Override
	public ProviderPolicy getProviderPolicy(String policyId) {
		ProviderPolicy newproviderPolicy = providerPolicyRepo.getProviderPolicy(policyId);
		return newproviderPolicy;
	}

	@Override
	public ProviderPolicyBenefit getProviderPolicyBenefit(String benefit) {
		ProviderPolicyBenefit newProviderBenefit = providerPolicyBenefitRepo.getProviderPolicyBenefit(benefit);
		return newProviderBenefit;
	}

}
