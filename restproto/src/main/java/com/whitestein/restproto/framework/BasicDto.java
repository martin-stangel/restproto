package com.whitestein.restproto.framework;

import io.swagger.annotations.ApiModelProperty;

public class BasicDto {
    @ApiModelProperty(value = "Unique identifier of the DTO")
    private Long id = 0L;

    @ApiModelProperty(value = "Version counter of the DTO", notes = "Optional")
    private Long version = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicDto basicDto = (BasicDto) o;
        if (id == null)
            return basicDto.id == null;

        return id.equals(basicDto.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
