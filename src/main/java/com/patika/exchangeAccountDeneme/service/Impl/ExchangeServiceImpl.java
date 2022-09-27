package com.patika.exchangeAccountDeneme.service.Impl;

import com.patika.exchangeAccountDeneme.dto.AccountDetailsDTO;
import com.patika.exchangeAccountDeneme.dto.ExchangeDTO;
import com.patika.exchangeAccountDeneme.entity.Account;
import com.patika.exchangeAccountDeneme.entity.AccountDetails;
import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;
import com.patika.exchangeAccountDeneme.exceptions.NotEnoughBalance;
import com.patika.exchangeAccountDeneme.repository.AccountDetailsRepository;
import com.patika.exchangeAccountDeneme.service.ExchangeService;
import com.patika.exchangeAccountDeneme.service.Impl.operation.Converter;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final AccountDetailsRepository accountDetailsRepository;
    private final AccountServiceImpl accountServiceImpl;
    private final Converter converter;

    public ExchangeServiceImpl(AccountDetailsRepository accountDetailsRepository, AccountServiceImpl accountServiceImpl, Converter converter) {
        this.accountDetailsRepository = accountDetailsRepository;
        this.accountServiceImpl = accountServiceImpl;
        this.converter = converter;
    }

    @Override
    public Optional<AccountDetailsDTO> operateExchange(ExchangeDTO exchangeDTO) {
        Account account = accountServiceImpl.getAccountById(exchangeDTO.getCustomerId());
        Queue<Double> resultAndRate;

        double amount = exchangeDTO.getAmount();
        resultAndRate = converter.convert(exchangeDTO.getBuy(),exchangeDTO.getSell(), exchangeDTO.getAmount());
        double difference = resultAndRate.poll();
        double rate = resultAndRate.poll();

        Currency sold = exchangeDTO.getSell();
        switch (sold){
            case TRY -> account.setTl(account.getTl()-difference);
            case GOLD -> account.setGold(account.getGold()-difference);
            case EURO -> account.setEuro(account.getEuro()-difference);
            case DOLLAR -> account.setDollar(account.getDollar()-difference);
        }
        switch (exchangeDTO.getBuy()){
            case TRY -> account.setTl(account.getTl()+amount);
            case GOLD -> account.setGold(account.getGold()+amount);
            case EURO -> account.setEuro(account.getEuro()+amount);
            case DOLLAR -> account.setDollar(account.getDollar() + amount);
        }
        AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();
        boolean balanceChecker = accountServiceImpl.checkAccountBalance(account);
        if(!balanceChecker){
            throw new NotEnoughBalance("not enough balance");
        } else {
            accountServiceImpl.saveAccount(account);
            AccountDetails accountDetails = new AccountDetails();
            accountDetails.setOperation(exchangeDTO.getAmount());
            accountDetails.setSummary("buy" + " ["+ exchangeDTO.getAmount() + "]" +
                    " @ " +
                    "[" + exchangeDTO.getBuy() +" & " + exchangeDTO.getSell() + " " + String.format("%.2f", rate) +"]");
            accountDetails.setAccountId(exchangeDTO.getAccountId());
            accountDetailsRepository.save(accountDetails);
            accountDetailsDTO.setOperation(accountDetails.getOperation());
            accountDetailsDTO.setSummary(accountDetails.getSummary());
        }
        return Optional.ofNullable(accountDetailsDTO);
    }


}
