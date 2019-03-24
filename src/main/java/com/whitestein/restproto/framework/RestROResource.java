package com.whitestein.restproto.framework;

import com.whitestein.restproto.endpoint.AccountDto;
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
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "Unique ID of the resource",
                    dataType = "Long",
                    paramType = "query"),
            @ApiImplicitParam(
                    name = "offset",
                    value = "Offset from which resources are returned (used for paging)",
                    dataType = "Long",
                    paramType = "query"),
            @ApiImplicitParam(
                    name = "limit",
                    value = "How many items are to be returned (used for paging)",
                    dataType = "Long",
                    paramType = "query")
    })
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
                    message = "The user is not entitled to send the request"),
            @ApiResponse(
                    code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    message = "Internal server error occured",
                    response = RestProblem.class)
    })
    CollectionDto<AccountDto> getAll(@Context UriInfo uriInfo);

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    @ApiOperation(value = "Gets single item")
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "List of items"),
            @ApiResponse(
                    code = 404,
                    message = "Item with given ID doesn't exist"),
            @ApiResponse(
                    code = 500,
                    message = "Internal server error occured",
                    response = RestProblem.class)
    })
    AccountDto getOne(@PathParam("id") Long id);
}
