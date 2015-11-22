/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cf.helloworld.processor;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author David
 */
public class DefaultGetProcessor implements Processor
{

    private final Logger logger = LoggerFactory.getLogger(DefaultGetProcessor.class);
    
    @Override
    public void process(Exchange ex) throws Exception
    {
         String body = ex.getIn().getBody(String.class);
        logger.debug("Processing exchange " + ex.toString());
        
        Map<String, Object> headers = ex.getIn().getHeaders();
        
        final String id = headers.get("id").toString();
        logger.debug("ID: " + id);
        
        final String httpQuery = headers.get("CamelHttpQuery").toString();
        logger.debug("CamelHttpQuery: " + httpQuery);
        

        for (Map.Entry<String, Object> header : headers.entrySet())
        {
            logger.debug(header.getKey() + " = " + header.getValue());            
        }
                        

        ex.getOut().setHeaders(ex.getIn().getHeaders());
        ex.getOut().setBody("DefaultGetProcessor processing complete");
    }

}
