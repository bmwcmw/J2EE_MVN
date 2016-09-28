A RESTful Web Service as Restlet Resources

The service can be deployed in the usual way with the Ant script. 
There is also the executablejar (java -jar .jar) as an alternative way of publishing.

To compile and deploy: ant deploy (-Dwar.name=b-adage is already set in build.xml)
To test:
	curl --request GET http://localhost:8080/b-adage2/
	curl --request GET http://localhost:8080/b-adage2/xml
	curl --request GET http://localhost:8080/b-adage2/json
	curl --request GET http://localhost:8080/b-adage2/xml/2
	curl --request POST --data "words=This is a test" http://localhost:8080/b-adage2/create
	curl --request DELETE http://localhost:8080/b-adage2/delete/6


mvn clean install doesn't work, to be repaired(copy path, etc)..