package com.patika.exchangeAccountDeneme.service.Impl.operation;

import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;

import java.util.Random;

public class ExchangeRate {
    double rate;
    public double findExchangeRate(Currency currency1, Currency currency2){

        Currency sold = currency2;

        if(currency1.equals(Currency.TRY)){
            switch (sold) {
                case GOLD -> rate= randomMultiplier(120, 150);
                case DOLLAR -> rate = randomMultiplier(18, 19);
                case EURO -> rate = randomMultiplier(20, 21);
            }
        }
        else if(currency1.equals(Currency.GOLD)){
            switch (sold){
                case TRY -> rate = randomMultiplier(120,150);
                case DOLLAR -> rate = randomMultiplier(6,7);
                case EURO -> rate =randomMultiplier(7,8);
            }
        }
        else if(currency1.equals(Currency.DOLLAR)){
            switch (sold){
                case GOLD -> rate = randomMultiplier(0.006,0.008);
                case TRY -> rate = randomMultiplier(0.05,0.06);
                case EURO -> rate = randomMultiplier(1.1,1.2);
            }
        }
        else if(currency1.equals(Currency.EURO)){
            switch (sold){
                case GOLD ->  rate = randomMultiplier(0.009,0.011);
                case DOLLAR -> rate = randomMultiplier(0.85,0.95);
                case TRY ->  rate = randomMultiplier(0.04,0.05);
            }
        }
        return rate;
    }

    private double randomMultiplier (double min, double max){
        return new Random().nextDouble((max-min)) + min;
    }
}
