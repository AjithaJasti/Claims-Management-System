package com.cognizant.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.model.EliglibleClaimAmount;
import com.cognizant.model.ProviderPolicy;
import com.cognizant.repo.PolicyProviderRepo;
import com.cognizant.service.PolicyService;
import com.cognizant.utility.EligibilityClaimResponse;
import com.cognizant.utility.EligibilityClaimResponse2;
import com.cognizant.utility.Help;
import com.cognizant.utility.ProviderResult;

@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@Autowired
	private PolicyProviderRepo policyProviderRepo;

	@Autowired
	private RestTemplate restTemp;

	@PostConstruct
	void init() {
		policyProviderRepo.getChainOfProviders("0");
	}
	// @Autowired
	// private ProviderResult pResult;

	// Save Details

	@PostMapping("/saveProvidersDetails")
	public ProviderPolicy saveProviderPolicy(@RequestBody ProviderPolicy providerPolicy) {
		return this.policyService.saveProviderPolicy(providerPolicy);

	}

	// /getChainOfProviders (Input: Policy_ID | Output (Provider List, location
	// wise)
	@GetMapping("/getChainOfProviders/{policyId}")
	public ProviderResult getChainOfProviders(@PathVariable("policyId") String policyId) {

		ProviderPolicy newProviderPolicy = policyProviderRepo.getChainOfProviders(policyId);
		// ProviderPolicy newProviderPolicy =
		// policyService.getChainOfProviders(policyId);
		ProviderResult pResult = new ProviderResult();
		pResult.setProvider_Name(newProviderPolicy.getProviderName());
		pResult.setLocation(newProviderPolicy.getLocation());
		return pResult;

	}

	@GetMapping("/getdata/{policyId}")
	public EligibilityClaimResponse2 getData(@PathVariable("policyId") String policyId) {

		ProviderPolicy newProviderPolicy = policyProviderRepo.getChainOfProviders(policyId);
		EligibilityClaimResponse2 resp = new EligibilityClaimResponse2();
		resp.setPolicyName(newProviderPolicy.getPolicyName());
		resp.setTotalClaimedAmt(newProviderPolicy.getClaimAmt());
		return resp;

	}

	// getEligibleClaimAmount (Input: Policy_ID, Member_ID, Benefit_ID | Output:
	// Eligible Amount that can be claimed)
	@GetMapping("/getEliglibleClaimAmount/{policyId}/{memberId}")
	public EliglibleClaimAmount totalEliglibleClaimAmount(@PathVariable("policyId") long policyId,
			@PathVariable("memberId") long memberId) {
		EligibilityClaimResponse res = restTemp.getForObject(
				"http://cms-claim-service/getClaimStatusPolicy/" + policyId + "/" + memberId,
				EligibilityClaimResponse.class);
		Help help = restTemp.getForObject("http://cms-policy-service/getdata/" + policyId, Help.class);
		EliglibleClaimAmount eAmt = new EliglibleClaimAmount();
		eAmt.setPolicyId(res.getPolicyId());
		eAmt.setMemberId(res.getMemberId());
		eAmt.setPolicyName(help.getPolicyName());
		eAmt.setTotalClaimedAmt(help.getTotalClaimedAmt());
		return eAmt;

	}

}
