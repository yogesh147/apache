package org.example;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.example.route.FileRoute;

public class Main {
    static FileRoute d = new FileRoute();

    public static void main(String[] args) throws Exception {

        System.out.println("Hello Camel world!");

        try (CamelContext context = new DefaultCamelContext()) {
            context.addRoutes(
                    new RouteBuilder() {
                        public void configure() throws Exception {
                            from("file:src/source?noop=true")
                                    .log("Main File from called")
                                    .to("file:src/destination")
                                    .end();
                        }
                    });
            context.start();
            Thread.sleep(5000);
            context.stop();
        }

    }
}