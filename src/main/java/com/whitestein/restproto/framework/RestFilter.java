package com.whitestein.restproto.framework;

import javax.ws.rs.core.UriInfo;

public class RestFilter {
    private UriInfo uriInfo;

    public RestFilter(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    public <T extends BasicDto> CollectionDto<T> filter(CollectionDto<T> collection) {
        return collection;
    }
}
