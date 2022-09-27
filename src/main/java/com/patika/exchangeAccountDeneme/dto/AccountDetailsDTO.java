package com.patika.exchangeAccountDeneme.dto;

import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class AccountDetailsDTO {
    private Currency currency;
    private double operation;
    private String summary;
}
