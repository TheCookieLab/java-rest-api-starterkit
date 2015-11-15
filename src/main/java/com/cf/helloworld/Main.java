/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cf.helloworld;

import com.cf.helloworld.component.GmailComponent;
import com.cf.helloworld.endpoint.GmailEndpoint;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author David
 */
public class Main {

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);

        try {

            CamelContext context = new DefaultCamelContext();
            
            context.start();
            
            

            logger.info("Hello World!");

            context.stop();
        } catch (Exception ex) {

        }
    }
}
