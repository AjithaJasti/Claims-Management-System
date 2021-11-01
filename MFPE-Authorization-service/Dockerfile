FROM openjdk:8
EXPOSE 8089
ADD target/authorizationService.jar authorizationService.jar 
ENTRYPOINT ["java","-jar","/authorizationService.jar"]