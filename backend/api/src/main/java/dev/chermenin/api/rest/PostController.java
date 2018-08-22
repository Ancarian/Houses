package dev.chermenin.api.rest;

import dev.chermenin.api.configuration.security.service.AuthService;
import dev.chermenin.dao.Post;
import dev.chermenin.repository.util.PageRequestBuilder;
import dev.chermenin.repository.util.SpecsBuilder;
import dev.chermenin.service.api.PostService;
import dev.chermenin.service.dto.create.PostRegistrationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
@Api(value = "Post controller", produces = "application/json", consumes = "application/json")
@Produces("application/json")
@Consumes("application/json")
@Component
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final AuthService authService;

    @ApiOperation(value = "get post by id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Post with this id does not exists")})
    @GET
    @Path("/post/{id}")
    public Response getPostByID(@PathParam("id") Long id) {
        return Response.ok(postService.findById(id)).build();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @ApiOperation(value = "update post")
    @PUT
    @Path("/post/settings")
    public Response updatePost(@Valid PostRegistrationDto postRegistrationDto) {
        Long userId = authService.getMyId();
        if (postService.existsByIdAndUserId(postRegistrationDto.getId(), userId)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        postRegistrationDto.setUserId(userId);
        postService.update(postRegistrationDto);
        return Response.ok().build();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @ApiOperation(value = "save post")
    @POST
    @Path("/post")
    public Response savePost(@Valid PostRegistrationDto postRegistrationDto) {
        Long userId = authService.getMyId();
        postRegistrationDto.setUserId(userId);
        return Response.ok(postService.save(postRegistrationDto)).build();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @ApiOperation(value = "Get client posts by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Client not registered"),
            @ApiResponse(code = 403, message = "Client not admin")})
    @GET
    @Path("/me/posts")
    public Response getPostsByUser(@QueryParam("page") int page,
                                   @QueryParam("sorts") String sorts,
                                   @QueryParam("search") String search) {
        if (search != null) {
            return Response.ok(postService.findAllByUserId(authService.getMyId(),
                    new PageRequestBuilder().setPage(page).setSort(sorts).build(),
                    (Specification<Post>) SpecsBuilder.createSpecification(search))).build();
        }
        return Response.ok(postService.findAllByUserId(authService.
                getMyId(), new PageRequestBuilder().setPage(page).setSort(sorts).build())).build();
    }


    @ApiOperation(value = "get all posts")
    @GET
    @Path("/posts")
    public Response getPosts(@QueryParam("page") int page,
                             @QueryParam("sorts") String sorts,
                             @QueryParam("search") String search) {
        if (search != null) {
            return Response.ok(postService.findAll(new PageRequestBuilder().setPage(page).setSort(sorts).build()
                    , (Specification<Post>) SpecsBuilder.createSpecification(search))).build();
        }
        return Response.ok(postService.findAll(new PageRequestBuilder().setPage(page).setSort(sorts).build())).build();
    }

    @PreAuthorize(value = "isAuthenticated()")
    @ApiOperation(value = "delete post by id")
    @DELETE
    @Path("/post/{id}")
    public Response deletePostById(@PathParam("id") Long id) {
        if (postService.existsByIdAndUserId(id, authService.getMyId())) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        postService.deleteById(id);
        return Response.ok().build();
    }
}
