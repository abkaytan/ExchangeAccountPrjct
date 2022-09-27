package com.patika.exchangeAccountDeneme.service;

import com.patika.exchangeAccountDeneme.dto.AccountDTO;
import com.patika.exchangeAccountDeneme.dto.AccountDetailsDTO;
import com.patika.exchangeAccountDeneme.dto.CustomerDTO;
import com.patika.exchangeAccountDeneme.entity.Account;
import com.patika.exchangeAccountDeneme.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public Optional<Customer> checkCustomer (long id);
    public Optional<Account> checkAccount ();
    public Customer saveCustomer(CustomerDTO customerDTO);
    public void saveCustomerList(List<Customer> customerList);
    public void saveAccountList(List<Account> accountList);
    public Account getAccountById(long id);
    public void saveAccount(Account account);
    public boolean checkAccountBalance(Account account);
    public AccountDTO showAccountBalance(long id);
    public List<AccountDetailsDTO> showAccountOperationDetails(long id);

    public String signin(String username, String password);
}
