package com.example.frontend.controllers;

import com.example.backend.models.Account;
import com.example.backend.repositories.AccountRepository;
import com.example.backend.services.AccountServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class Controllers {
    private AccountServices accountServices;
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/accounts")
    public String showAccountListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Account> accountPage = accountServices.findPaginated(currentPage - 1,
                pageSize, "id", "asc");

        model.addAttribute("accountPage", accountPage);

        int totalPages = accountPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "account/listAccount.html";
    }
    @GetMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable("id") Long accountId) {
        accountRepository.deleteById(String.valueOf(accountId));
        return "redirect:/accounts";
    }
    @GetMapping("/accounts/update-account/{id}")
    public String showUpdateForm(@PathVariable("id") Long accountId, Model model) {
        // Retrieve the account by ID from the service
        Account account = accountRepository.findById(String.valueOf(accountId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + accountId));

        model.addAttribute("account", account);
        return "account/editAccount.html";
    }
    @PostMapping("/accounts/update-account/{id}")
    public String updateAccount(@PathVariable("id") Long accountId,
                                @RequestParam("fullName") String fullName,
                                @RequestParam("password") String password,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("status") String status,
                                @RequestParam("role") String role) {
        // Retrieve the account by ID from the service
        Account existingAccount = accountRepository.findById(String.valueOf(accountId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + accountId));

        // Update the account properties
        existingAccount.setFullName(fullName);
        existingAccount.setPassword(password);
        existingAccount.setEmail(email);
        existingAccount.setPhone(phone);
        existingAccount.setStatus(status);
        existingAccount.setRole(role);

        // Save the updated account
        accountRepository.save(existingAccount);

        return "redirect:/accounts";
    }

}
