/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cf.helloworld.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

/**
 *
 * @author David
 */
public class RouteBuilderImpl extends RouteBuilder
{
    

    @Override
    public void configure() throws Exception
    {
        restConfiguration().component("spark-rest").scheme("http").host("localhost").port(9091).bindingMode(RestBindingMode.auto).enableCORS(true);
        
        rest("/say")
                .get("/hello").to("direct:hello")
                .get("/bye").consumes("application/json").to("direct:bye")
                .post("/bye").to("mock:update");
 
            from("direct:hello")
                    .log("inside direct:hello")
                .transform().constant("Hello World");
            from("direct:bye")
                .transform().constant("Bye World");
    }
}
