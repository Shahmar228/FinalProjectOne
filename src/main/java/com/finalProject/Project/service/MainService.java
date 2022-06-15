package com.finalProject.Project.service;

import com.finalProject.Project.model.Account;
import com.finalProject.Project.model.Computer;
import com.finalProject.Project.repository.AccountRepository;
import com.finalProject.Project.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class MainService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ComputerRepository computerRepository;

@Transactional
    public Account getAccountByUsername(String username){
return accountRepository.findAccountByUsername(username);
    }



    @Transactional
    public void addComputer(Computer theComputer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Account owner_account = getAccountByUsername(authentication.getName());


theComputer.setTheAccount(owner_account);

        computerRepository.save(theComputer);

    }

    @Transactional
    public void saveAccount(Account theAccount) {
        accountRepository.save(theAccount);
    }

    @Transactional
    public List<Computer> getComputerList() {
        return computerRepository.findAll();
    }

@Transactional
    public List<Computer> getMyComputerList(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Account owner_account = getAccountByUsername(authentication.getName());

List<Computer> computerList = new ArrayList<>();

for(Computer computer : computerRepository.findAll()){
    if(computer.getTheAccount().equals(owner_account)){
        computerList.add(computer);
    }

}
        return computerList;
}


    public Computer getComputerById(long id) {
    return computerRepository.getComputerById(id);
    }

    public void deleteComputerById(long id) {
    computerRepository.deleteById(id);
    }
}
