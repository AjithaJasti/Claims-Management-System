package com.cognizant.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimStatusResult {
	private String claimStatus;
	private String claimDesc;
	private Long ClaimId;
	private String memberId;

}
