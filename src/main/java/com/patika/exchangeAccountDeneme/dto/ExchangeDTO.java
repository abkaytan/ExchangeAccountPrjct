package com.patika.exchangeAccountDeneme.dto;

import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class ExchangeDTO {

    @ApiModelProperty(position = 1, example = "TRY, GOLD, DOLLAR, EURO")
    @NotNull(message = "purchase is mandatory")
    private Currency buy;

    @ApiModelProperty(position = 2, example = "20")
    @NotNull(message = "amount is mandatory")
    private Double amount;

    @ApiModelProperty(position = 3, example = "TRY, GOLD, DOLLAR, EURO")
    @NotNull(message = "sale is mandatory")
    private Currency sell;

    @ApiModelProperty(position = 4, example = "1")
    @NotNull(message = "customer id mandatory")
    private Long customerId;

    @ApiModelProperty(position = 5, example = "1")
    @NotNull(message = "account id mandatory")
    private Long accountId;


}
