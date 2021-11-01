## Claims Management System

Claim is a right of insured to receive the amount secured under the policy of insurance contract promised by Insurer.

Insurance Claim is the request of the insured policy holder/beneficiary from the insurer/insurance issuing company for financial reimbursement whenever he/she suffers a loss of the insured property/life/health/etc

Insurer- settle the claim after satisfying himself that all the conditions and requirements for settlement of claim have been compiled with.


There are five modules:
1. Authorization Service
2. Claims Service
3. Member Service
4. Policy Service
5. Portal Service

Authorization Service
    -   Creates JWT
    -   The token gets expired after specific amount of time
    -   Sets the token inside the session
    
Claims Module 

    -   Middleware Microservice that performs following operations: 
    -   Get Claim Status 
    -   Validate Eligibility of Claim and Action Settlement

Member Service
    -  View Bills 
    -  Submit Claim 
    -  View Claim Status

Policy Service
    -   Get Chain of Permissible Providers (Hospitals) 
    -   Get Benefits permissible under a policy 
    -   Get Acceptable Claim Amount per benefit, per policy

Portal Service
    -   It allows member to Login and allows to do following operations: 
              Login 
              View Current Bill Status, Next Due 
              Verify Claim Status 
              Submit a Claim
