package com.patika.exchangeAccountDeneme.controller;

import com.patika.exchangeAccountDeneme.dto.AccountDetailsDTO;
import com.patika.exchangeAccountDeneme.dto.ExchangeDTO;
import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;
import com.patika.exchangeAccountDeneme.service.Impl.ExchangeServiceImpl;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class ExchangeController {

    private final ExchangeServiceImpl exchangeServiceImpl;

    public ExchangeController(ExchangeServiceImpl exchangeServiceImpl) {
        this.exchangeServiceImpl = exchangeServiceImpl;
    }

    @PostMapping()
    public ResponseEntity<AccountDetailsDTO> exchangeOperation (@RequestBody ExchangeDTO exchangeDTO){

        Optional<AccountDetailsDTO> accountDetailsDTO = exchangeServiceImpl.operateExchange(exchangeDTO);
        if(accountDetailsDTO.isPresent()){
            return new ResponseEntity<>(accountDetailsDTO.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

}
