package com.PayMyBudy.service.form;

import com.PayMyBudy.model.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransferForm {

    private Integer id;
    private LocalDate date;
    private String to;
    private Double amount;

}
