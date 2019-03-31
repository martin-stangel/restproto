package com.whitestein.restproto.framework;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;

@ApiModel(description = "Holds list of items. Mostly for GET method.")
public class CollectionDto<T>  {
    public CollectionDto() {
    }

    public CollectionDto(Collection<T> items) {
        this.items = items;
    }

    @ApiModelProperty(value="Items of the collection")
    private Collection<T> items;

    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }
}
