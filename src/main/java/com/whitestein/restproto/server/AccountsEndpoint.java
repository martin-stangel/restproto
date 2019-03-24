package com.whitestein.restproto.server;

import com.whitestein.restproto.api.AccountDto;
import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/accounts")
@Api(value="/accounts", description = "Operations about accounts")
@Produces({"application/json"})
public class AccountsEndpoint {

    @GET
    public ListDto<AccountDto> get() {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(1);
        accountDto.setName("Name");
        accountDto.setVersion(3);

        List<AccountDto> accountDtoList = new ArrayList<AccountDto>();
        accountDtoList.add(accountDto);

        ListDto<AccountDto> accounts = new ListDto<AccountDto>();
        accounts.setItems(accountDtoList);

        return accounts;
    }
}
