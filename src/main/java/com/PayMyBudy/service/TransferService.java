package com.PayMyBudy.service;

import com.PayMyBudy.model.Transfer;
import com.PayMyBudy.model.User;
import com.PayMyBudy.repository.TransferRepository;
import com.PayMyBudy.repository.UserRepository;
import com.PayMyBudy.service.form.RegistrationForm;
import com.PayMyBudy.service.form.TransferForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service("TransferService")
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public void transfer(TransferForm form) {
        if (form != null) {

                Transfer transfer = new Transfer();

                transfer.setDate(form.getDate());
                transfer.setDescription(form.getDescription());
                transfer.setUserFromEmail(form.getUserFromEmail());
                transfer.setUserToEmail(form.getUserToEmail());
                transfer.setAmountBeforeFee(form.getAmountBeforeFee());
                transfer.setAmountAfterFee((form.getAmountBeforeFee()-form.getAmountBeforeFee()/200));

            transferRepository.save(transfer);

        } else {

        }
    }
}

