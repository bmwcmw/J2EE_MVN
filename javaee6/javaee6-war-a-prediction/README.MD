The two *.java files can be compiled as usual. 

To run, provide each with a URL (e.g., http://www.amazon.com/index.html/) as a command-line argument.


To compile and deploy: ant -Dwar.name=prediction deploy
To test:               curl http://localhost:8080/prediction/

ant (build.xml) doesn't work, to be repaired..