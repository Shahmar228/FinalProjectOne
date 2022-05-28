package com.finalProject.Project.service;

import com.finalProject.Project.model.Account;
import com.finalProject.Project.model.AccountUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.finalProject.Project.security.Role.GUEST;


@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    MainService mainService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getAccountUserDetails(username);
    }

    private AccountUserDetails getAccountUserDetails(String username){
        Account theAccount = mainService.getAccountByUsername(username);

        AccountUserDetails accountUserDetails = new AccountUserDetails(
                theAccount.getUsername(),
                passwordEncoder.encode(theAccount.getPassword()),
                GUEST.getSimpleGrantedAuthority(),
                true,
                true,
                true,
                true
        );
        return accountUserDetails;
    }
}
