package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EliglibleClaimAmount {

	private String policyId;
	private String memberId;
	private String policyName;
	private long totalClaimedAmt;

}
