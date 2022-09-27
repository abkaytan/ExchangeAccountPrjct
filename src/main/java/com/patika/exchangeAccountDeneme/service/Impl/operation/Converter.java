package com.patika.exchangeAccountDeneme.service.Impl.operation;

import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Converter {

    public Queue<Double> convert(Currency currency1, Currency currency2, double amount){
        ExchangeRate exchangeRate = new ExchangeRate();
        double rate = exchangeRate.findExchangeRate(currency1, currency2);
        double result = amount/rate;

        Queue<Double> resultAndRate = new LinkedList<>();
        resultAndRate.offer(result);
        resultAndRate.offer(rate);
        return  resultAndRate;
    }


}
