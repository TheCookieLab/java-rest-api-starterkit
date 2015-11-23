/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cf.helloworld;

import com.cf.helloworld.route.RouteBuilderImpl;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author David Pang
 */
public class Main {

    public static void main(String[] args) throws InterruptedException  {
        final Logger logger = LoggerFactory.getLogger(Main.class);

        try {

            logger.info("Starting HelloWorld");
            CamelContext context = new DefaultCamelContext();
            context.addRoutes(new RouteBuilderImpl());
            
            context.start();
      
            for (int i = 0; i < 600; i++)
            {
                final long sleepDurationInMs = 1000;
                Thread.sleep(sleepDurationInMs);
            }
                 
            context.stop();
            logger.info("Stopping HelloWorld");
            
        }catch (InterruptedException iex) {
            throw iex;
        }
        catch (Exception ex) {
            logger.error("Main failed - " + ex.getMessage(), ex);
        }
    }
}
