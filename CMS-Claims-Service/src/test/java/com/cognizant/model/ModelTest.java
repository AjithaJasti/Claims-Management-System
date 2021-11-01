//package com.cognizant.model;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.meanbean.test.BeanTester;
//
//class ModelTest {
//
//	@Test
//	void testNoArgs() {
//		assertThat(new ClaimStatus()).isNotNull();
//	}
//
//	@Test
//	void testAllArgs() {
//		assertThat(assertThat(new ClaimStatus(1, "1", "1", "1", "1", "1"))).isNotNull();
//	}
//
//	@Test
//	void testTreatPlanBeanGettersAndSetters() {
//		final BeanTester beanTester = new BeanTester();
//		beanTester.getFactoryCollection();
//		beanTester.testBean(ClaimStatus.class);
//	}
//
//	@Test
//	void testNoArgs2() {
//		assertThat(new Claim()).isNotNull();
//	}
//
//	@Test
//	void testAllArgs2() {
//		assertThat(assertThat(new Claim(1, "1", "1", "1", "1", "1", 1, 1))).isNotNull();
//	}
//
//	@Test
//	void testTreatPlanBeanGettersAndSetters2() {
//		final BeanTester beanTester = new BeanTester();
//		beanTester.getFactoryCollection();
//		beanTester.testBean(Claim.class);
//	}
//
//}
