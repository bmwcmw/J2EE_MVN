/**
 * A RESTful Web Service as a JAX-RS Resource
 *  adages1 implements JAX-RS resources with Jackson binding, can be published : 
 *  - with a Java Application : AdagesPublisher
 *  - with containers like Tomcat
 */


To compile and deploy: ant deploy (-Dwar.name=b-adage is already set in build.xml)
To test:               curl http://127.0.0.1:8080/b-adage/badage

mvn clean install doesn't work, to be repaired(copy path, etc)..