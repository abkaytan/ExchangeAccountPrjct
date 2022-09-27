package com.patika.exchangeAccountDeneme.service.Impl;

import com.patika.exchangeAccountDeneme.dto.AccountDTO;
import com.patika.exchangeAccountDeneme.dto.AccountDetailsDTO;
import com.patika.exchangeAccountDeneme.dto.CustomerDTO;
import com.patika.exchangeAccountDeneme.entity.Account;
import com.patika.exchangeAccountDeneme.entity.AccountDetails;
import com.patika.exchangeAccountDeneme.entity.Customer;
import com.patika.exchangeAccountDeneme.repository.AccountDetailsRepository;
import com.patika.exchangeAccountDeneme.repository.AccountRepository;
import com.patika.exchangeAccountDeneme.repository.CustomerRepository;
import com.patika.exchangeAccountDeneme.service.AccountService;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountDetailsRepository accountDetailsRepository;




    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository,
                              AccountDetailsRepository accountDetailsRepository){
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.accountDetailsRepository = accountDetailsRepository;

    }

    HashMap<Long, String> tokenStore = new HashMap<>();

    @Override
    public String signin(String username, String password)  {
        String token = "token üretilemedi";
        return token;
    }


    @Override
    public Optional<Customer> checkCustomer(long id) {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.getCustomerById(id));
        return customer;
    }

    @Override
    public Optional<Account> checkAccount() {
        Optional<Account> account = Optional.ofNullable(accountRepository.getAccountById());
        return account;
    }

    @Override
    public Customer saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFullName(customerDTO.getFullName());
        customer.setPassword(customerDTO.getPassword());
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void saveCustomerList(List<Customer> customerList) {
        customerRepository.saveAll(customerList);
    }

    @Override
    public void saveAccountList(List<Account> accountList) {
        accountRepository.saveAll(accountList);
    }

    @Override
    public Account getAccountById(long id) {
        return accountRepository.getAccountByCustomerId(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public boolean checkAccountBalance(Account account) {

        if (account.getDollar() < 0 || account.getGold() < 0 || account.getTl() < 0 || account.getEuro() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public AccountDTO showAccountBalance(long id) {
        Account account = accountRepository.getAccountByCustomerId(id);
        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setDollar(account.getDollar());
        accountDTO.setEuro(account.getEuro());
        accountDTO.setTl(account.getTl());
        accountDTO.setGold(account.getGold());

        return accountDTO;
    }

    @Override
    public List<AccountDetailsDTO> showAccountOperationDetails(long id) {
        List<AccountDetails> accountDetailsList = accountDetailsRepository.showAccountOperationDetails(id);

        List<AccountDetailsDTO> accountDetailsDTOList = new ArrayList<>();

        for (AccountDetails map : accountDetailsList) {

            AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();

            accountDetailsDTO.setOperation(map.getOperation());
            /*accountDetailsDTO.setCurrency(map.getCurrency());*/
            accountDetailsDTO.setSummary(map.getSummary());
            accountDetailsDTOList.add(accountDetailsDTO);

        }

        return accountDetailsDTOList;
    }




}
