package com.cognizant.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.cognizant.helper.MemberSubmitClaim;
import com.cognizant.helper.ProviderPolicy;
import com.cognizant.helper.ProviderPolicyBenefit;
import com.cognizant.model.ClaimStatus;
import com.cognizant.repo.ClaimStatusRepo;
import com.cognizant.service.ClaimService;
import com.cognizant.utility.ClaimStatusResult;
import com.cognizant.utility.ClaimStatusUtilResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(controllers = ClaimController.class)
class ClaimControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private ClaimService claimService;

	@MockBean
	private ClaimStatusRepo claimStatusRepo;

	@Test
	final void testSubmitClaimStatus() throws Exception {
		ClaimStatus claimStatus = new ClaimStatus(1, "1", "1", "1", "Pending Action", "Wait for updates");
		when(claimService.updateStatus(claimStatus)).thenReturn(claimStatus);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(claimStatus);
		this.mockMvc.perform(post("/submitClaimStatus").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk());
	}

	@Test
	final void testGetClaimStatusUtil() throws Exception {
		ClaimStatus claimStatus = new ClaimStatus(1, "1", "1", "1", "Pending Action", "Wait for updates");
		when(claimStatusRepo.getClaimStatusUtil(1, 1)).thenReturn(claimStatus);
		ClaimStatus newclaimClaimStatus = claimStatusRepo.getClaimStatusUtil(1, 1);
		ClaimStatusUtilResult claimStatusUtilResult = new ClaimStatusUtilResult();
		claimStatusUtilResult.setPolicyId(newclaimClaimStatus.getPolicyId());
		claimStatusUtilResult.setMemberId(newclaimClaimStatus.getMemberId());
		this.mockMvc.perform(get("/getClaimStatusPolicy/{policyId}/{member_Id}", 1, 1)).andExpect(status().isOk());
	}

//	@Test
//	final void testGetClaimStatusUtil2() throws Exception {
//		ClaimStatus claimStatus = new ClaimStatus(1, "1", "1", "1", "Claim Rejected", "Under Dispute");
//		when(claimStatusRepo.getClaimStatusUtil(1, 1)).thenReturn(claimStatus);
//		ClaimStatus newclaimClaimStatus = claimStatusRepo.getClaimStatusUtil(1, 1);
//		ClaimStatusUtilResult claimStatusUtilResult = new ClaimStatusUtilResult();
//		claimStatusUtilResult.setPolicyId(newclaimClaimStatus.getPolicyId());
//		claimStatusUtilResult.setMemberId(newclaimClaimStatus.getMemberId());
//		this.mockMvc.perform(get("/getClaimStatusPolicy/{policyId}/{member_Id}", 1, 1)).andExpect(status().isOk());
//	}

	@Test
	final void testGetClaimStatus() throws Exception {
		ClaimStatus claimStatus = new ClaimStatus(1, "1", "1", "1", "Pending Action", "Wait for updates");
		MemberSubmitClaim memberSubmitClaim = new MemberSubmitClaim(1, "1", "1", "1", 40000, 36000);
		ProviderPolicy providerPolicy = new ProviderPolicy(1, "1", "healthy", "Apollo", "Delhi", "many", 20000, 40000,
				10);
		ProviderPolicyBenefit policyBenefit = new ProviderPolicyBenefit(1, "1", "healthy", "Apollo", "Delhi", "many",
				20000, 40000, 10);

		when(claimService.getProviderPolicy("1")).thenReturn(providerPolicy);

		when(claimService.getProviderPolicyBenefit(policyBenefit.getBenefits())).thenReturn(policyBenefit);
		ClaimStatusResult claimStatusResult = new ClaimStatusResult("Pending Action", "Wait for Updates", 1l, "1");
		when(claimService.getMemberSubmitClaim("1")).thenReturn(memberSubmitClaim);
		this.mockMvc.perform(get("/getClaimStatus/{claimId}/{policyId}/{memberId}", 1l, "1", "1"))
				.andExpect(status().isOk());

	}

	@Test
	final void testGetClaimStatus2() throws Exception {
		ClaimStatus claimStatus = new ClaimStatus(1, "1", "1", "1", "Pending Action", "Wait for updates");
		MemberSubmitClaim memberSubmitClaim = new MemberSubmitClaim(1, "1", "1", "1", 36000, 40000);
		ProviderPolicy providerPolicy = new ProviderPolicy(1, "1", "healthy", "Apollo", "Delhi", "many", 20000, 40000,
				10);
		ProviderPolicyBenefit policyBenefit = new ProviderPolicyBenefit(1, "1", "healthy", "Apollo", "Delhi", "many",
				20000, 40000, 10);

		when(claimService.getProviderPolicy("1")).thenReturn(providerPolicy);

		when(claimService.getProviderPolicyBenefit(policyBenefit.getBenefits())).thenReturn(policyBenefit);
		ClaimStatusResult claimStatusResult = new ClaimStatusResult("Pending Action", "Wait for Updates", 1l, "1");
		when(claimService.getMemberSubmitClaim("1")).thenReturn(memberSubmitClaim);
		this.mockMvc.perform(get("/getClaimStatus/{claimId}/{policyId}/{memberId}", 1l, "1", "1"))
				.andExpect(status().isOk());

	}

//	@Test
//	final void testObject() {
//		assertNotNull(mockMvc);
//	}
//
//	@Test
//	final void testGetClass() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testHashCode() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testEquals() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testClone() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testToString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testNotify() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testNotifyAll() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testWait() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testWaitLong() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testWaitLongInt() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testFinalize() {
//		fail("Not yet implemented"); // TODO
//	}

}
