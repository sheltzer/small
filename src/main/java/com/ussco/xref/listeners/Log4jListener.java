package com.ussco.xref.listeners;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jListener implements ServletContextListener {
	 
	public Log4jListener() {
		super();
	}  
	
	public void contextInitialized(ServletContextEvent sce) { 
		/*
		String file=sce.getServletContext().getInitParameter("LOG4J_CONFIG_LOCATION");
		URL urlForMassMaintainence = Log4jListener.class.getClassLoader().getResource(file); 
		//System.err.println("FILE IS USING URL>>>>!!!!"+urlForMassMaintainence.getPath());
		
		if(urlForMassMaintainence.getPath()==null){
			System.err.println("PLEASE SPECIFY THE LOG4J.XML, WITHOUT LOG4J GETTING INITIALIZED LOGGING WILL NOT WORK");
		}
		try{ 
		DOMConfigurator.configure(urlForMassMaintainence.getPath());
		}catch(Exception e){
			throw new NestableRuntimeException(this.getClass().getName()+" PROBLEM OCCURED WHILE LOADING UP LOG4J");
		}
		*/
		try{

			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger");
			final String file = System.getProperty("log4j.configuration", "log4j.xml");
			//final String file = "config/logging/local/log4j.xml";
			URL url = this.getClass().getClassLoader().getResource(file);
			DOMConfigurator.configure(url);
		}catch(Exception e){
			throw new NestableRuntimeException(this.getClass().getName()+" PROBLEM OCCURED WHILE LOADING UP LOG4J");
		}
		 
	}

	/* (non-Java-doc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(ServletContextEvent sce)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		 //Turn off logging when the Servlet Context is destroyed
    	LogManager.shutdown();

	}

	

	 

}