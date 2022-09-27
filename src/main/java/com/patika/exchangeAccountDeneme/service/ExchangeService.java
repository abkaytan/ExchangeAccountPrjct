package com.patika.exchangeAccountDeneme.service;

import com.patika.exchangeAccountDeneme.dto.AccountDetailsDTO;
import com.patika.exchangeAccountDeneme.dto.ExchangeDTO;

import java.util.Optional;

public interface ExchangeService {
    public Optional<AccountDetailsDTO> operateExchange(ExchangeDTO exchangeDTO);
}
