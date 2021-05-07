package com.PayMyBudy.service;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.AccountRepository;
import com.PayMyBudy.repository.TransferRepository;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.TransferForm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service("TransferService")
public class TransferService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository, UserRepository userRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public void transfer(TransferForm form) {
        if (form != null) {

            Transfer transfer = new Transfer();
            LocalDate date = null;
            transfer.setDate(date);
            transfer.setUserFromEmail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
            transfer.setUserToEmail(form.getUserToEmail());
            transfer.setAmountAfterFee((form.getAmountBeforeFee() - form.getAmountBeforeFee() / 200));
            User userConnected = userRepository
                    .findUserByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));
            // get the Account of the coennnected user
            Account userConnectedAccount = accountRepository.findAccountByUser(userConnected).orElseThrow(() -> new RuntimeException("user with email  not found"));
            userConnectedAccount.setAmount(userConnectedAccount.getAmount() - transfer.getAmountAfterFee());
            accountRepository.save(userConnectedAccount);
            transferRepository.save(transfer);


        } else {

        }
    }


}

