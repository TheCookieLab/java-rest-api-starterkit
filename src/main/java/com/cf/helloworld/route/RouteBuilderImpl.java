package com.cf.helloworld.route;

import com.cf.helloworld.processor.DefaultGetProcessor;
import com.cf.helloworld.processor.DefaultPostProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;

public class RouteBuilderImpl extends RouteBuilder
{
    @Override
    public void configure() throws Exception
    {
        restConfiguration().component("spark-rest").scheme("http").host("localhost").port(9091).bindingMode(RestBindingMode.auto).enableCORS(true);

        rest("/api/v1/")
                .get("customers/{id}").to("direct:customerDetail")
                .get("customers/{id}/orders").to("direct:customerOrders")
                .post("/register").to("direct:register");
        
        from("direct:customerDetail")
                .process(new DefaultGetProcessor())
                .marshal().json(JsonLibrary.Gson)
                .log("customerDetail body: ${body}");
        
         from("direct:customerOrders")
                .process(new DefaultGetProcessor())
                 .marshal().json(JsonLibrary.Gson)
                .log("customerOrders body: ${body}");
         
         from("direct:register")
                .process(new DefaultPostProcessor())
                 .marshal().json(JsonLibrary.Gson)
                .log("register body: ${body}");
    }
}
