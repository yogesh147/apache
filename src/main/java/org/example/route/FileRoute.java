package org.example.route;

import org.apache.camel.builder.RouteBuilder;

public class FileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:src/source")
                .log("File Route from called")
                .to("file:src/destination")
                .end();
    }
}
