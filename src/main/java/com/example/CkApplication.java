package com.example;

import com.example.backend.models.Account;
import com.example.backend.models.Log;
import com.example.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class CkApplication {
    @Autowired
    private AccountRepository accountRepository ;
    public static void main(String[] args) {
        SpringApplication.run(CkApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner createSampleAccounts() {
        return args -> {

            for (int i = 1; i < 31; i++){
                String role ;
                if(i%2==0){
                     role = "ADMIN";
                }else{
                     role = "USER";
                }
                Account account = new Account("name "+i,"pass "+i,"email "+i,"phone "+i, "Active",role);
                accountRepository.save(account);
            }
            Log log= new Log(accountRepository.findAll().get(0), Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()),"note");

        };
    }
}
