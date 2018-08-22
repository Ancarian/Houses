package dev.chermenin.api.rest;


import dev.chermenin.service.api.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/countries")
@Api(value = "Country controller", produces = "application/json", consumes = "application/json")
@Produces("application/json")
@Consumes("application/json")
@Component
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @ApiOperation(value = "get country by name")
    @GET
    @Path("/{name}")
    public Response getCountry(@PathParam("name") String name) {
        return Response.ok(countryService.findByShortNameOrName(name)).build();
    }

    @ApiOperation(value = "get all countries")
    @GET
    public Response getCountry() {
        return Response.ok(countryService.findAll()).build();
    }

}
