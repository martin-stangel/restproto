package com.whitestein.restproto.endpoint;

import com.whitestein.restproto.framework.CollectionDto;
import com.whitestein.restproto.framework.RestFilter;
import com.whitestein.restproto.framework.RestProblem;
import com.whitestein.restproto.framework.RestRWResource;
import io.swagger.annotations.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.Map;

@Path("/accounts")
@Api(value = "/accounts", description = "Endpoint managing Account resources")
public class AccountsEndpoint implements RestRWResource<AccountDto> {
    private static Map<Long, AccountDto> ACCOUNTS = createDefaultAccounts();

    public AccountsEndpoint() {
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
    @POST
    @Path("/mandate/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Mandates single item by ID")
    public AccountDto mandate(Long id, AccountDto item) {
        return null;
    }

    @Override
    public void delete(Long id) {
        ACCOUNTS.remove(id);
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
}
