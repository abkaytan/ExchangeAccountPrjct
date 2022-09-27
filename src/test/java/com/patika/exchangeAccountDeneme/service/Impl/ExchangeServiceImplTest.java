package com.patika.exchangeAccountDeneme.service.Impl;

import com.patika.exchangeAccountDeneme.dto.AccountDetailsDTO;
import com.patika.exchangeAccountDeneme.dto.ExchangeDTO;
import com.patika.exchangeAccountDeneme.entity.Account;
import com.patika.exchangeAccountDeneme.entity.AccountDetails;
import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;
import com.patika.exchangeAccountDeneme.repository.AccountDetailsRepository;
import com.patika.exchangeAccountDeneme.service.Impl.operation.Converter;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExchangeServiceImplTest {

    @Mock
    AccountServiceImpl mockAccountServiceImpl;
    @Mock
    AccountDetailsRepository mockAccountDetailsRepository;
    @Mock
    Converter mockConverter;

    @InjectMocks
    ExchangeServiceImpl exchangeServiceImpl;

    @Test
    void operateExchange() {

        //given
        Account account = new Account();
        Mockito.when(mockAccountServiceImpl.getAccountById(1L)).thenReturn(account);

        Queue<Double> resultAndRate = new LinkedList<>();
        Currency currency1 = Currency.TRY;
        Currency currency2 = Currency.DOLLAR;
        resultAndRate.offer(Mockito.anyDouble());
        resultAndRate.offer(Mockito.anyDouble());
        Mockito.doReturn(resultAndRate).when(mockConverter.convert(currency1, currency2, Mockito.anyDouble()));

        Mockito.doReturn(true).when(mockAccountServiceImpl.checkAccountBalance(account));


        //when

        ExchangeDTO exchangeDTO = new ExchangeDTO(currency1, Mockito.anyDouble(), currency2, 1L, 1L);
        AccountDetailsDTO accountDetailsDTO = this.exchangeServiceImpl.operateExchange(exchangeDTO).get();

        //then

        assertNotNull(accountDetailsDTO);


    }
}