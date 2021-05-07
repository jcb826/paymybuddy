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

@Service("TransferService")
public class TransferService {

    private TransferRepository transferRepository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public TransferService(TransferRepository transferRepository, UserRepository userRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public void transfer(TransferForm form) {
        if (form != null) {

                Transfer transfer = new Transfer();
                transfer.setDate(form.getDate());
                transfer.setDescription(form.getDescription());
            String connectedUserMail = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            User userConnected = userRepository
                    .findUserByMail(connectedUserMail)
                    .orElseThrow(()->new RuntimeException("user with email "+form.getUserFromEmail()+" not found"));
                transfer.setUserToEmail(form.getUserToEmail());
                transfer.setAmountBeforeFee(form.getAmountBeforeFee());
                transfer.setAmountAfterFee((form.getAmountBeforeFee()-form.getAmountBeforeFee()/200));
      /*          // get the Account of the coennnected user
  Account userConnectedAccount= accountRepository.findById(SecurityContextHolder.getContext().getAuthentication().getId());
Double amount = userConnectedAccount.getAmount();
amount = amount - transfer.getAmountAfterFee();
accountRepository.save(userConnectedAccount);
            transferRepository.save(transfer);


       */
        } else {

        }
    }
}

