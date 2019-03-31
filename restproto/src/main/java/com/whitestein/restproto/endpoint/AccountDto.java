package com.whitestein.restproto.endpoint;

import com.whitestein.restproto.framework.BasicDto;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "AccountDto")
public class AccountDto extends BasicDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
