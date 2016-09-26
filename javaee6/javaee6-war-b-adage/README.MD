/**
 *  adages1 implements JAX-RS resources with Jackson binding, can be published : 
 *  - with a Java Application : AdagesPublisher
 *  - with containers like Tomcat
 */


To compile and deploy: ant deploy (-Dwar.name=prediction is already set in build.xml)
To test:               curl http://localhost:8080/prediction/

mvn clean install doesn't work, to be repaired(copy path, etc)..