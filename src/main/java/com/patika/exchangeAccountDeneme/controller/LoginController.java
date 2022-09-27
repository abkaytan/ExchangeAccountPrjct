package com.patika.exchangeAccountDeneme.controller;


import com.patika.exchangeAccountDeneme.dto.LoginDTO;
import com.patika.exchangeAccountDeneme.entity.Customer;
import com.patika.exchangeAccountDeneme.exceptions.CustomException;
import com.patika.exchangeAccountDeneme.exceptions.UsernamePasswordMissMatchException;
import com.patika.exchangeAccountDeneme.repository.CustomerRepository;
import com.patika.exchangeAccountDeneme.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private LoginService loginService;
    private CustomerRepository customerRepository;

    public LoginController(BCryptPasswordEncoder bCryptPasswordEncoder, LoginService loginService, CustomerRepository customerRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loginService = loginService;
        this.customerRepository = customerRepository;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody LoginDTO loginDTO) {

        Optional<Customer> customerCheck = customerRepository.findById(1L);

        if(customerCheck.isPresent()){
            String token = bCryptPasswordEncoder.encode(loginDTO.getPassword());
            loginDTO.setPassword(token);
            loginService.save(loginDTO);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            throw new UsernamePasswordMissMatchException("There is no customer with this username or password");
        }
    }
}
