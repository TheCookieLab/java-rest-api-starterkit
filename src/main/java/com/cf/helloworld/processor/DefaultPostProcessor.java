package com.cf.helloworld.processor;

import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author David Pang
 */
public class DefaultPostProcessor implements Processor
{

    private final Logger logger = LogManager.getLogger(DefaultPostProcessor.class);

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
