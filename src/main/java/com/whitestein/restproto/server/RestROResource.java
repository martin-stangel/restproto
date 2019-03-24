package com.whitestein.restproto.server;

import com.whitestein.restproto.api.AccountDto;

public abstract class RestROResource<T> {
    public ListDto<AccountDto> getMethod() {
        return get();
    }

    protected abstract ListDto<AccountDto> get();
}
