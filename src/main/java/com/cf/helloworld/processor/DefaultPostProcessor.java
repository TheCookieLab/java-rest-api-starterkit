/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cf.helloworld.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author David Pang
 */
public class DefaultPostProcessor implements Processor
{

    private final Logger logger = LoggerFactory.getLogger(DefaultPostProcessor.class);

    @Override
    public void process(Exchange ex) throws Exception
    {
        final long startTime = System.currentTimeMillis();
        logger.debug("Processing exchange - " + ex.toString());
        final String body = ex.getIn().getBody(String.class);
        final Map<String, Object> headers = ex.getIn().getHeaders();

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> header : headers.entrySet())
        {
            sb.append(header.getKey()).append(" = ").append(header.getValue()).append(System.lineSeparator());

        }
        logger.debug("Headers: " + sb.toString());

        ex.getOut().setHeaders(ex.getIn().getHeaders());
        ex.getOut().setBody("DefaultPostProcessor processing complete");
        logger.info("DefaultPostProcessor process() completed in " + (System.currentTimeMillis() - startTime) + " ms");
    }

}
