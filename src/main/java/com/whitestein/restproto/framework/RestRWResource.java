package com.whitestein.restproto.framework;

import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;

public interface RestRWResource<T> extends RestROResource<T> {
    @POST
    @Produces({"application/json"})
    @ApiOperation(value = "Creates a new item")
    void create(T item);

    @POST
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Updates an existing item")
    void update(@PathParam("id") Long id, T item);

    @DELETE
    @Path("/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Deletes single item by ID")
    void delete(@PathParam("id") Long id);
}
