/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cf.helloworld.route;

import com.cf.helloworld.processor.DefaultGetProcessor;
import com.cf.helloworld.processor.DefaultPostProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
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

        rest("/customers/")
                .get("/{id}").to("direct:customerDetail")
                .get("/{id}/orders").to("direct:customerOrders")
                .post("/neworder").to("direct:customerNewOrder");
        
        from("direct:customerDetail")
                .process(new DefaultGetProcessor())
                .marshal().json(JsonLibrary.Gson)
                .log("customerDetail body: ${body}");
        
         from("direct:customerOrders")
                .process(new DefaultGetProcessor())
                 .marshal().json(JsonLibrary.Gson)
                .log("customerOrders body: ${body}");
         
         from("direct:customerNewOrder")
                .process(new DefaultPostProcessor())
                 .marshal().json(JsonLibrary.Gson)
                .log("customerNewOrder body: ${body}");
    }
}
