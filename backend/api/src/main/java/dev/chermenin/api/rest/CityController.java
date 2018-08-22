package dev.chermenin.api.rest;

import dev.chermenin.service.api.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/cities")
@Api(value = "City controller", produces = "application/json", consumes = "application/json")
@Produces("application/json")
@Consumes("application/json")
@Component
@AllArgsConstructor
public class CityController {
    private final CityService cityService;

    @ApiOperation(value = "get cities by state id")
    @GET
    @Path("/{id}")
    public Response getCountry(@PathParam("id") Long id) {
        return Response.ok(cityService.findAllByStateId(id)).build();
    }
}

