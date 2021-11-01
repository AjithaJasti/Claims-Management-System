//package com.cognizant.helper;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.meanbean.test.BeanTester;
//
//class HelperTest {
//
//	@Test
//	void testNoArgs() {
//		assertThat(new MemberSubmitClaim()).isNotNull();
//	}
//
//	@Test
//	void testAllArgs() {
//		assertThat(assertThat(new MemberSubmitClaim(1, "1", "1", "1", 1, 1))).isNotNull();
//	}
//
//	@Test
//	void testTreatPlanBeanGettersAndSetters() {
//		final BeanTester beanTester = new BeanTester();
//		beanTester.getFactoryCollection();
//		beanTester.testBean(MemberSubmitClaim.class);
//	}
//
//	@Test
//	void testNoArgs2() {
//		assertThat(new ProviderPolicy()).isNotNull();
//	}
//
//	@Test
//	void testAllArgs2() {
//		assertThat(assertThat(new ProviderPolicy(1, "1", "1", "1", "1", "1", 1, 1, 1))).isNotNull();
//	}
//
//	@Test
//	void testTreatPlanBeanGettersAndSetters2() {
//		final BeanTester beanTester = new BeanTester();
//		beanTester.getFactoryCollection();
//		beanTester.testBean(ProviderPolicy.class);
//	}
//
//	@Test
//	void testNoArgs3() {
//		assertThat(new ProviderPolicyBenefit()).isNotNull();
//	}
//
//	@Test
//	void testAllArgs3() {
//		assertThat(assertThat(new ProviderPolicyBenefit(1, "1", "1", "1", "1", "1", 1, 1, 1))).isNotNull();
//	}
//
//	@Test
//	void testTreatPlanBeanGettersAndSetters3() {
//		final BeanTester beanTester = new BeanTester();
//		beanTester.getFactoryCollection();
//		beanTester.testBean(ProviderPolicyBenefit.class);
//	}
//
//}
