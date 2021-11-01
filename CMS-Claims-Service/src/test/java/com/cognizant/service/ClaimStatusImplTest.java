package com.cognizant.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.helper.MemberSubmitClaim;
import com.cognizant.helper.ProviderPolicy;
import com.cognizant.helper.ProviderPolicyBenefit;
import com.cognizant.model.ClaimStatus;
import com.cognizant.repo.ClaimStatusRepo;
import com.cognizant.repo.MemberSubmitClaimRepo;
import com.cognizant.repo.ProviderPolicyBenefitRepo;
import com.cognizant.repo.ProviderPolicyRepo;

@SpringBootTest
class ClaimStatusImplTest {

	@Mock
	private ClaimStatusRepo repo;

	@InjectMocks
	private ClaimStatusImpl service;

	@Mock
	private MemberSubmitClaimRepo memberSubmitClaimRepo;

	@Mock
	private ProviderPolicyRepo providerPolicyRepo;

	@Mock
	private ProviderPolicyBenefitRepo providerPolicyBenefitRepo;

	@Test
	final void testUpdateStatus() {
		ClaimStatus claimStatus = new ClaimStatus(1, "1", "1", "1", "Pending Action", "Wait for updates");
		when(repo.save(claimStatus)).thenReturn(claimStatus);
		assertThat(service.updateStatus(claimStatus).equals(claimStatus));
	}

	@Test
	final void testGetMemberSubmitClaim() {
		MemberSubmitClaim memberSubmitClaim = new MemberSubmitClaim(1, "1", "1", "1", 40000, 36000);
		when(memberSubmitClaimRepo.getMemberSubmitClaim("1")).thenReturn(memberSubmitClaim);
		assertThat(service.getMemberSubmitClaim("1").equals(memberSubmitClaim));
	}

	@Test
	final void testGetProviderPolicy() {
		ProviderPolicy providerPolicy = new ProviderPolicy(1, "1", "healthy", "Apollo", "Delhi", "many", 20000, 40000,
				10);
		when(providerPolicyRepo.getProviderPolicy("1")).thenReturn(providerPolicy);
		assertThat(service.getProviderPolicy("1").equals(providerPolicy));
	}

	@Test
	final void testGetProviderPolicyBenefit() {
		ProviderPolicyBenefit policyBenefit = new ProviderPolicyBenefit(1, "1", "healthy", "Apollo", "Delhi", "many",
				20000, 40000, 10);
		when(providerPolicyBenefitRepo.getProviderPolicyBenefit(Mockito.any())).thenReturn(policyBenefit);
		assertThat(service.getProviderPolicyBenefit("many").equals(policyBenefit));
	}

}
