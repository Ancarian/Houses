package dev.chermenin.api.rest;

import dev.chermenin.service.api.StateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/states")
@Api(value = "State controller", produces = "application/json", consumes = "application/json")
@Produces("application/json")
@Consumes("application/json")
@Component
@CrossOrigin(value = "localhost:4200")
@AllArgsConstructor
public class StateController {
    private final StateService stateService;

    @ApiOperation(value = "get states by country id")
    @GET
    @Path("/{id}")
    public Response getCountry(@PathParam("id") Long id) {
        return Response.ok(stateService.findByCountryId(id)).build();
    }
}