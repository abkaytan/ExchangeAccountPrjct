package com.patika.exchangeAccountDeneme.controller;

import com.patika.exchangeAccountDeneme.dto.AccountDTO;
import com.patika.exchangeAccountDeneme.dto.AccountDetailsDTO;
import com.patika.exchangeAccountDeneme.dto.CustomerDTO;
import com.patika.exchangeAccountDeneme.entity.Account;
import com.patika.exchangeAccountDeneme.entity.Customer;
import com.patika.exchangeAccountDeneme.service.Impl.AccountServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountServiceImpl accountServiceImpl;

    public AccountController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }



    @PostMapping("/signin")
    @ApiOperation(value = "Customer - SIGN IN ")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid username/password supplied")})
    public ResponseEntity<String> login(//
                        @ApiParam("Username") @RequestParam String username, //
                        @ApiParam("Password") @RequestParam String password) {
        String result = accountServiceImpl.signin(username, password);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



    /*@PostMapping("/save-customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = accountServiceImpl.saveCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }*/

    @GetMapping("/balance/{id}")
    public ResponseEntity<AccountDTO> showAccountBalance(@PathVariable long id){
        AccountDTO accountDTO = accountServiceImpl.showAccountBalance(id);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<List<AccountDetailsDTO>> showAccountOperationDetails (@PathVariable long id){
        List<AccountDetailsDTO> accountDetailsDTOList = accountServiceImpl.showAccountOperationDetails(id);
        return new ResponseEntity<>(accountDetailsDTOList, HttpStatus.OK);
    }
}
