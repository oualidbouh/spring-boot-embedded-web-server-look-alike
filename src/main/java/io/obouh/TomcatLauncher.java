package io.obouh;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.annotation.PostConstruct;

public class TomcatLauncher {

    @PostConstruct
    public void launch() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Context context = tomcat.addContext("",null);
        Tomcat.addServlet(context,"hiServlet",new HiServlet());
        context.addServletMappingDecoded("/","hiServlet");
        tomcat.setPort(8081);
        tomcat.start();
        new Thread(()->tomcat.getServer().await()).start();
    }
}
