//package com.patika.exchangeAccountDeneme.util;
//
//import com.patika.exchangeAccountDeneme.entity.Account;
//import com.patika.exchangeAccountDeneme.entity.Customer;
//import com.patika.exchangeAccountDeneme.repository.AccountRepository;
//import com.patika.exchangeAccountDeneme.repository.CustomerRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class InitializerRunner implements CommandLineRunner {
//
////    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Autowired
//    AccountRepository accountRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        customerRepository.save(Customer.builder().fullName("abkode").password("123456").build());
//        customerRepository.save(Customer.builder().fullName("Mehmet Türk").password("456789").build());
//
//        accountRepository.save(Account.builder().tl(2000).gold(50).euro(500).dollar(500).customerId(1).build());
//        accountRepository.save(Account.builder().tl(2000).gold(50).euro(500).dollar(500).customerId(2).build());
//
//    }
//
//}
