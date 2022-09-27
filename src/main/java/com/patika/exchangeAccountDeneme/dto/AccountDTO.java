package com.patika.exchangeAccountDeneme.dto;

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
public class AccountDTO {
    private double tl;
    private double gold;
    private double dollar;
    private double euro;
}
