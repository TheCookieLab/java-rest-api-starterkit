package com.cf.helloworld;

import com.cf.helloworld.route.RouteBuilderImpl;
import java.util.concurrent.TimeUnit;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author David Pang
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        Logger logger = LogManager.getLogger();

        try
        {

            logger.info("Starting Java-Rest-API-StarterKit");
            CamelContext context = new DefaultCamelContext();
            context.addRoutes(new RouteBuilderImpl());

            context.start();

            final long sleepDurationInMs = 1000;
            for (int i = 0; i < 600; i++)
            {
                TimeUnit.SECONDS.sleep(sleepDurationInMs);
            }

            context.stop();
            logger.info("Stopping HelloWorld");

        }
        catch (InterruptedException iex)
        {
            throw iex;
        }
        catch (Exception ex)
        {
            logger.error("Main failed - " + ex.getMessage(), ex);
        }
    }
}
