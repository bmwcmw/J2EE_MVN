Porting the Predictions Web Service to JAX-RS, like adage1 JAX-RS

Check supported CRUD operations in j2ee.mvn.war.b.prediction3.PredictionsResource(no default method).

To compile and deploy: ant deploy
To test:				curl http://127.0.0.1:8080/b-prediction3/pred3app/predresource3/xml
						curl http://127.0.0.1:8080/b-prediction3/pred3app/predresource3/json
						... etc

mvn clean install doesn't work, to be repaired(copy path, etc)..