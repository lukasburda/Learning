package org.lukasburda.dockerplaying.javaee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("message")
public class Message {

    @GET
    public String getMessage() {
        return "Hello World, from Docker";
    }
}
