# ReturnsCalculator-Rest-Boot

This repository contains a rest interface to calculate the Simple and Compound interests.

Modules:
  - domain: contains the business and domain objects
  - core: contains the underlying services that perform the calculations
  - rest: contians Spring Boot, Rest & Swagger Integration APIs that expose the underlying services as Rest Services
  
Build:
  - cd <root/parent project>
  - mvnw clean install
  
Run:
  - cd <root/parent project>/target
  - java -jar rest-interface-1.0-SNAPSHOT.jar
  

Results:
  - Rest Services:
    -- http://localhost:8080/calculateReturns
  - Swagger UI: 
    -- http://localhost:8080/swagger-ui.html
  
