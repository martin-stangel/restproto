package com.whitestein.restproto.framework;

import com.whitestein.restproto.endpoint.AccountDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;

public interface RestRWResource<T> extends RestROResource<T> {

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Creates a new item")
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
    void create(T item);

    @POST
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Updates an existing item")
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
    void update(@PathParam("id") Long id, T item);

    @POST
    @Path("/mandate/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Mandates single item by ID")
    T mandate(@PathParam("id") Long id, @ApiParam() T item);

    @DELETE
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Deletes single item by ID")
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
    void delete(@PathParam("id") Long id);
}
