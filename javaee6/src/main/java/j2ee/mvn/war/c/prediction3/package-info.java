/**
 * WADL2JAVBA generated client
 * 
 * As an example, recall the predictions3 JAX-RS service from Chapter 2whose base URL is:
 * http://127.0.0.1:8080/b-prediction3/pred3app/predresource3/xml
 * 
 * The WADL document for this service is available under Jersey with the URL:
 * http://127.0.0.1:8080/b-prediction3/pred3app/application.wadl
 * 
 * If the implementation were Apache CXF instead of Jersey, the URL would be:
 * http://127.0.0.1:8080/b-prediction3/pred3app/predresource3?wadl
 * 
 * Then run : 
 * wadl2java -o outputDir -p package [-a] [-s jaxrs20] [-c customization]* file.wadl
 * 
 * (run in wadl-dist-1.1.6\bin) : 
 * wadl2java -o ..\..\src\main\java\j2ee\mvn\war\c\prediction3 -p j2ee.mvn.war.c.prediction3 ..\..\src\main\java\j2ee\mvn\war\c\prediction3\application.wadl
 * 
 * FIEME : 
 * java.net.URISyntaxException: Illegal character in path at index 2: ..\..\src\main\java\j2ee\mvn\war\c\prediction3\application.wadl
        at java.net.URI$Parser.fail(URI.java:2829)
        at java.net.URI$Parser.checkChars(URI.java:3002)
        at java.net.URI$Parser.parseHierarchical(URI.java:3086)
        at java.net.URI$Parser.parse(URI.java:3044)
        at java.net.URI.<init>(URI.java:595)
        at org.jvnet.ws.wadl2java.Main.main(Main.java:111)
 */
package j2ee.mvn.war.c.prediction3;