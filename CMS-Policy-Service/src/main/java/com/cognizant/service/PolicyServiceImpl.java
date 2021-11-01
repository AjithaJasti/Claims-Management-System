package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.ProviderPolicy;
import com.cognizant.repo.PolicyProviderRepo;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyProviderRepo policyProviderRepo;

	@Override
	public ProviderPolicy saveProviderPolicy(ProviderPolicy providerPolicy) {

		return policyProviderRepo.save(providerPolicy);
	}

//	@Override
//	public ProviderPolicy getChainOfProviders(String policyId) throws Exception {
//		// List<ProviderPolicy> list = new ArrayList<>();
//		// ProviderPolicy policy = new ProviderPolicy();
//		for (ProviderPolicy p : policyProviderRepo.findAll()) {
//			if (p.getPolicyId() == policyId) {
//				return p;
//				// break;
//			}
//		}
////		Optional<ProviderPolicy> optional = policyProviderRepo.findById(Long.parseLong(policyId));
////		ProviderPolicy providerPolicy = null;
////		if (optional.isPresent()) {
////			providerPolicy = optional.get();
////		} else {
////			throw new Exception();
////		}
//		return null;
//	}

}
