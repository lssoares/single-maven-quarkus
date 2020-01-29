package org.acme;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author jorgepereira
 */
@Path("example")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public interface ExampleApi {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    String hello();

    @GET
    @Path("/{id}")
    Response find(@PathParam("id") Long id);

    @GET
    @Path("/list")
    Response list();

    @GET
    @Path("/testAnnotations")
    @Timeout(1000)
    @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 1, delay = 60000)
    Response testWs();
}
