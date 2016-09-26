The two *.java files can be compiled as usual. 

To run, provide each with a URL (e.g., http://www.amazon.com/index.html/) as a command-line argument.


To compile and deploy: ant deploy (-Dwar.name=prediction is already set in build.xml)
To test:               curl http://localhost:8080/prediction/

mvn clean install doesn't work, to be repaired(copy path, etc)..