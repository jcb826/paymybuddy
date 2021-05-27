package com.PayMyBudy.service;

import com.PayMyBudy.model.Account;
import com.PayMyBudy.model.Connection;
import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.AccountRepository;
import com.PayMyBudy.repository.TransferRepository;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.TransferForm;
import com.PayMyBudy.service.form.TransferToBankForm;
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
            transfer.setFrom(from);
            transfer.setTo(to);
            // get the Account of the coennnected user

            accountRepository.save(from.getAccount().minus(transfer.getAmountBeforeFee()));
            accountRepository.save(to.getAccount().plus(transfer.getAmountAfterFee()));
            transferRepository.save(transfer);


        } else {

        }
    }
    public List<Transfer> findTransactions(){
        User connectedUser = userRepository.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));
        return transferRepository.findTransferByUserId(connectedUser.getId());

    }
    public String findIban(){
        User connectedUser = userRepository.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));
        Account account = accountRepository.findAccountByUserId(connectedUser.getId());
       return account.getIban();

    }
    public void transferToBank(TransferToBankForm form) {
        if (form != null) {
            User from = userRepository.findUserByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));


            // get the Account of the coennnected user

            accountRepository.save(from.getAccount().minus(form.getAmount()));




        } else {

        }
    }


}

