package com.whitestein.restproto.framework;

import javax.ws.rs.core.UriInfo;

public class RestFilter {
    private UriInfo uriInfo;
    private Integer offset;
    private Integer limit;
    private Integer id;

    public RestFilter(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    public <T extends BasicDto> CollectionDto<T> filter(CollectionDto<T> collection) {
        return collection;
    }

    public Integer getOffset() {
        return offset;
    }

    public RestFilter setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public RestFilter setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public RestFilter setId(Integer id) {
        this.id = id;
        return this;
    }
}
