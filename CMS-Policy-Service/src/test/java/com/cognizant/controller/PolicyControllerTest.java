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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

//import com.cognizant.controller.model.MemberPolicy;
//import com.cognizant.controller.model.MemberPolicy;
import com.cognizant.model.ProviderPolicy;
import com.cognizant.repo.PolicyProviderRepo;
import com.cognizant.service.PolicyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(controllers = PolicyController.class)
class PolicyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private PolicyService policyService;

	@MockBean
	private PolicyProviderRepo policyProviderRepo;

	@MockBean
	private RestTemplate restTemp;

	@Test
	final void testSubmit() throws Exception {
		ProviderPolicy providerPolicy = new ProviderPolicy(1L, "1", "1", "1", "1", "1", 2L, 2L, 2L);
		when(policyService.saveProviderPolicy(providerPolicy)).thenReturn(providerPolicy);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(providerPolicy);
		this.mockMvc.perform(post("/saveProvidersDetails").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk());
	}

	@Test
	final void testgetChain() throws Exception {
		ProviderPolicy providerPolicy = new ProviderPolicy(1L, "1", "1", "1", "1", "1", 2L, 2L, 2L);
		when(policyProviderRepo.getChainOfProviders("1")).thenReturn(providerPolicy);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(providerPolicy);
		this.mockMvc.perform(
				get("/getChainOfProviders/{policyId}", 1).contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk());
	}

	@Test
	final void testgetdata() throws Exception {
		ProviderPolicy providerPolicy = new ProviderPolicy(1L, "1", "1", "1", "1", "1", 2L, 2L, 2L);
		when(policyProviderRepo.getChainOfProviders("1")).thenReturn(providerPolicy);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		String jsonString = mapper.writeValueAsString(providerPolicy);
		this.mockMvc.perform(get("/getdata/{policyId}", 1).contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk());
	}
	/*
	 * @Test final void totalEligible() throws Exception{ ProviderPolicy
	 * providerPolicy= new ProviderPolicy(1L, "1","1","1","1","1",2L,2L,2L);
	 * EligibilityClaimResponse res =
	 * restTemp.getForObject("http://cms-claim-service/getClaimStatusPolicy/"+1+"/"+
	 * 2,EligibilityClaimResponse.class); Help help =
	 * restTemp.getForObject("http://cms-policy-service/getdata/"+1, Help.class);
	 * EliglibleClaimAmount eAmt = new EliglibleClaimAmount();
	 * when(eAmt.getPolicyId().thenReturn(providerPolicy);
	 * when(policyProviderRepo.getChainOfProviders("2")).thenReturn(providerPolicy);
	 * ObjectMapper mapper=new ObjectMapper(); mapper.registerModule(new
	 * JavaTimeModule());
	 * mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	 * String jsonString=mapper.writeValueAsString(providerPolicy);
	 * this.mockMvc.perform(get("/getEliglibleClaimAmount/{policyId}/{memberId}",1,2
	 * ).contentType(MediaType.APPLICATION_JSON).content(jsonString))
	 * .andExpect(status().isOk()); }
	 */

}