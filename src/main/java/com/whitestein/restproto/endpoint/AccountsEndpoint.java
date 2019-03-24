package com.whitestein.restproto.endpoint;

import com.whitestein.restproto.framework.CollectionDto;
import com.whitestein.restproto.framework.RestFilter;
import com.whitestein.restproto.framework.RestRWResource;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.Map;

@Path("/accounts")
@Api(value = "/accounts", description = "Operations about accounts")
public class AccountsEndpoint implements RestRWResource<AccountDto> {
    private static Map<Long, AccountDto> ACCOUNTS = createDefaultAccounts();

    public AccountsEndpoint() {
    }

    private static void addAccount(Map<Long, AccountDto> accounts, Long id) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(id);
        accountDto.setName("Account " + id);
        accountDto.setVersion(2L);
        accounts.put(id, accountDto);
    }

    private static Map<Long, AccountDto> createDefaultAccounts() {
        HashMap<Long, AccountDto> result = new HashMap<Long, AccountDto>();
        addAccount(result, 1L);
        addAccount(result, 2L);
        addAccount(result, 3L);
        return result;
    }

    @Override
    public CollectionDto<AccountDto> getAll(UriInfo uriInfo) {
        CollectionDto<AccountDto> accounts = new CollectionDto<AccountDto>(ACCOUNTS.values());
        return new RestFilter(uriInfo).filter(accounts);
    }

    @Override
    public AccountDto getOne(Long id) {
        if (ACCOUNTS.containsKey(id)) {
            return ACCOUNTS.get(id);
        } else {
            return null;
        }
    }

    @Override
    public void create(AccountDto item) {
        ACCOUNTS.put(item.getId(), item);
    }

    @Override
    public void update(Long id, AccountDto item) {
        ACCOUNTS.put(id, item);
    }

    @Override
    public void delete(Long id) {
        ACCOUNTS.remove(id);
    }
}
