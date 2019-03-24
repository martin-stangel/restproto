package com.whitestein.restproto.server;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Hold list of items. Mostly for GET method.")
public class ListDto<T>  {

    @ApiModelProperty(value="Items of the collection")
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
