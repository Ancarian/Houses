package dev.chermenin.api.rest;

import dev.chermenin.api.configuration.security.service.AuthService;
import dev.chermenin.service.api.UserService;
import dev.chermenin.service.dto.create.UserRegistrationDto;
import dev.chermenin.service.dto.login.LoginRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
@Api(value = "/api", description = "Client controller")
@Produces("application/json")
@Consumes("application/json")
@Component
@CrossOrigin(value = "localhost:4200")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @ApiOperation(value = "Get client by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Client not registered"),
            @ApiResponse(code = 403, message = "Client not admin")})
    @GET
    @Path("/client/{id}")
    public Response getUser(@PathParam("id") Long id) {
        return Response.ok(userService.findById(id)).build();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @ApiOperation(value = "get client profile")
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Client not registered")})
    @GET
    @Path("/me")
    public Response getProfile() {
        return Response.ok(authService.getUserByAuthentication()).build();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @ApiOperation(value = "update client")
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Client not registered")})
    @PUT
    @Path("/settings")
    public Response updateProfile(@Valid UserRegistrationDto userRegistrationDto) {
        userRegistrationDto.setId(authService.getUserByAuthentication().getId());
        userService.update(userRegistrationDto);

        return Response.ok().build();
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @ApiOperation(value = "get all users")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Client not registered"),
            @ApiResponse(code = 403, message = "Client not admin")})
    @GET
    @Path("/users")
    public Response getUser(@QueryParam("page") Integer page) {
        return Response.ok(userService.findAll(PageRequest.of(page, 10))).build();
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @ApiOperation(value = "delete client by id")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Client not registered"),
            @ApiResponse(code = 403, message = "Client not admin")})
    @DELETE
    @Path("/client/{id}")
    public Response deleteUserById(@PathParam("id") Long id) {
        userService.deleteById(id);
        return Response.ok().build();
    }

    @ApiOperation(value = "login")
    @POST
    @Path("/login")
    public Response login(LoginRequestDto loginRequestDto) throws Exception {
        return Response.ok(authService.login(loginRequestDto)).build();
    }

    @ApiOperation(value = "registration")
    @POST
    @Path("/registration")
    public Response registration(@Valid UserRegistrationDto userRegistrationDto) {
        return Response.ok(userService.save(userRegistrationDto)).build();
    }
}
