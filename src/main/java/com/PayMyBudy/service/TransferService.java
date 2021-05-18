package com.PayMyBudy.service;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.AccountRepository;
import com.PayMyBudy.repository.TransferRepository;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.TransferForm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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
            User from = userRepository.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));
            User to = userRepository.findUserByMail(form.getTo())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));
            Transfer transfer = new Transfer();
            transfer.setDate(LocalDateTime.now());
            transfer.setAmountBeforeFee(form.getAmount());
            transfer.setAmountAfterFee(form.getAmount() - form.getAmount() * 0.005);
            // get the Account of the coennnected user

            accountRepository.save(from.getAccount().minus(transfer.getAmountBeforeFee()));
            accountRepository.save(to.getAccount().plus(transfer.getAmountAfterFee()));
            transferRepository.save(transfer);


        } else {

        }
    }
    public List<Transfer> findTransactions(){
        String connectedUserMail = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User userConnected = userRepository
                .findUserByMail(connectedUserMail)
                .orElseThrow(()->new RuntimeException("user with email not found"));
        return transferRepository.findTransferById(userConnected.getId());

    }


}

