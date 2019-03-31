package com.whitestein.restproto.framework;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@SuppressWarnings("unused")
public class RestProblem {
    private int statusCode;
    private String type;
    private String title;
    private String detail;

    public RestProblem() {
    }

    public RestProblem(int statusCode) {
        this.statusCode = statusCode;
    }

    public void doThrow() {

    }

    public String getType() {
        return type;
    }

    public RestProblem setType(String type) {
        this.type = type;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public RestProblem setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RestProblem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public RestProblem setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestProblem that = (RestProblem) o;

        return new EqualsBuilder()
                .append(statusCode, that.statusCode)
                .append(type, that.type)
                .append(title, that.title)
                .append(detail, that.detail)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(statusCode)
                .append(type)
                .append(title)
                .append(detail)
                .toHashCode();
    }
}
