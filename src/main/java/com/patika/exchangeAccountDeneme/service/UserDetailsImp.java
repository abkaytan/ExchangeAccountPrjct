package com.patika.exchangeAccountDeneme.service;

import com.patika.exchangeAccountDeneme.entity.Login;
import com.patika.exchangeAccountDeneme.repository.LoginRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsImp implements UserDetailsService {
    private LoginRepository loginRepository;

    public UserDetailsImp(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username);
        if (login == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(login.getUsername(), login.getPassword(), emptyList());
    }
}
