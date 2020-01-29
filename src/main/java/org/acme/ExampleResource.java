package org.acme;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public class ExampleResource implements ExampleApi{

    @Inject
    ExampleRepository exampleRepository;

    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public Response find(Long id){
        return Optional.of(exampleRepository
                .findById(id))
                .map(Response::ok)
                .orElse(Response.status(NOT_FOUND))
                .build();
    }

    @Override
    public Response list() {
        return Response.ok(exampleRepository.findAll().list()).build();
    }

    @Override
    public Response testWs(){
        return Response.ok(exampleRepository.annotationsTest()).build();
    }

}