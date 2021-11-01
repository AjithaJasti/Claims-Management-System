package com.cognizant.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityClaimResponse2 {
	private String policyName;
	private long totalClaimedAmt;

}
