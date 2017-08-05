package com.cf.helloworld.processor;

import com.cf.helloworld.response.CustomerDetailResponse;
import java.util.Date;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultGetProcessor implements Processor
{

    private final Logger logger = LogManager.getLogger(DefaultGetProcessor.class);

    @Override
    public void process(Exchange ex) throws Exception
    {
        final long startTime = System.currentTimeMillis();
        logger.debug("Processing exchange - " + ex.toString());
        final String request = ex.getIn().getBody(String.class);
        final Map<String, Object> headers = ex.getIn().getHeaders();

        final Object id = headers.get("id");
        logger.debug("ID: " + id);

        final Object httpQuery = headers.get("CamelHttpQuery");
        logger.debug("CamelHttpQuery: " + httpQuery);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> header : headers.entrySet())
        {
            sb.append(header.getKey()).append(" = ").append(header.getValue()).append(System.lineSeparator());

        }
        logger.debug("Headers: " + sb.toString());

        CustomerDetailResponse response = new CustomerDetailResponse(id.toString(), "Billy Bob", "b.bob@aol.com", new Date());

        ex.getOut().setHeaders(ex.getIn().getHeaders());
        ex.getOut().setBody(response);
        logger.info("DefaultGetProcessor process() completed in " + (System.currentTimeMillis() - startTime) + " ms");
    }

}
