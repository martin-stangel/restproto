package com.whitestein.restproto.framework;

import io.swagger.annotations.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public interface RestROResource<T> {

    @GET
    @Produces({"application/json"})
    @ApiOperation(
            value = "Gets all items",
            authorizations = { @Authorization("BASIC-AUTH") })
    @ApiResponses({
            @ApiResponse(
                    code = HttpServletResponse.SC_OK,
                    message = "List of items"),
            @ApiResponse(
                    code = HttpServletResponse.SC_BAD_REQUEST,
                    message = "There was missing or invalid data in the request",
                    response = RestProblem.class ),
            @ApiResponse(
                    code = HttpServletResponse.SC_FORBIDDEN,
                    message = "The user is not entitled to send the request",
                    response = RestProblem.class),
            @ApiResponse(
                    code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    message = "Internal server error occured",
                    response = RestProblem.class)
    })
    CollectionDto<T> getAll(@Context UriInfo uriInfo);

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    @ApiOperation(value = "Gets a single item")
    @ApiResponses({
            @ApiResponse(
                    code = HttpServletResponse.SC_OK,
                    message = "List of items"),
            @ApiResponse(
                    code = HttpServletResponse.SC_NOT_FOUND,
                    message = "The item doesn't exist",
                    response = RestProblem.class ),
            @ApiResponse(
                    code = HttpServletResponse.SC_BAD_REQUEST,
                    message = "There was missing or invalid data in the request",
                    response = RestProblem.class ),
            @ApiResponse(
                    code = HttpServletResponse.SC_FORBIDDEN,
                    message = "The user is not entitled to send the request",
                    response = RestProblem.class),
            @ApiResponse(
                    code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    message = "Internal server error occured",
                    response = RestProblem.class)
    })
    T getOne(@PathParam("id") Long id);
}
