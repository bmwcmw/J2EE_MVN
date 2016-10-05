package j2ee.mvn.war.test;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;


public class EmbeddedTomcatRunner {
	public static void main(String[] args) throws Exception {

		String webappDirLocation = "src/main/webapp/";
		Tomcat tomcat = new Tomcat();

		// The port that we should run on can be set into an environment
		// variable
		// Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8999";
		}

		tomcat.setPort(Integer.valueOf(webPort));
		
		Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

		// XXX : put servlet here
//	    Tomcat.addServlet(ctx, "hello", new PredictionsServlet());
	    ctx.addServletMapping("/*", "hello");

//		StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
//		System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
//
//		// Declare an alternative location for your "WEB-INF/classes" dir
//		// Servlet 3.0 annotation will work
//		File additionWebInfClasses = new File("target/classes");
//		WebResourceRoot resources = new StandardRoot(ctx);
//		resources.addPreResources(
//				new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
//		ctx.setResources(resources);

		tomcat.start();
		tomcat.getServer().await();
	}
}
