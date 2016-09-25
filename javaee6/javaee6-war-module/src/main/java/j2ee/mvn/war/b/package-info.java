/**
 *  Service side
 *  
Four different APIs were considered in this chapter, but these APIs fall into three general
groups:

• The  HttpServletAPI, which has been around since the late 1990s, remains an
excellent way to implement RESTful services. Servlets are HTTP-aware and provide
convenient filtering of requests by HTTP verb. Programmers accustomed to im‐
plementing websites with servlets, JSP, and related scripting languages such as JSF
or Struts, should find servlets a natural and appealing way to deliver web services
as well. The servlet API is at once uncomplicated and powerful.

• The JAX-RS and Restlet APIs take full advantage of Java annotations to advertise
the RESTful aspects of implemented services. These frameworks integrate well with
JAX-B technologies to automate the conversion of Java types into XML and JSON
documents. JAX-RS and Restlet services, like servlet-based servlets, can be pub‐
lished with production-grade web servers such as Tomcat and Jetty. These APIs also
mimic the routing idioms that have become so popular because of frameworks such
as Rails and Sinatra.

• The JAX-WS API, with the @WebServiceProvider at its center, is lower level than
the other options but well suited for programmers who need to be close to the HTTP
and XML metal. This API is sufficiently rich to deliver real-world RESTful services,
but the rival APIs are more appealing in that they hide many of the details that a
JAX-WS service must handle explicitly. For SOAP-based services, the JAX-WS API
is as good as any and will be the focus in Chapters 4and 5.
 *
 */
package j2ee.mvn.war.b;