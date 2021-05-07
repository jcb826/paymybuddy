package com.PayMyBudy.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class Transfer {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSFER_SEQ")
    @SequenceGenerator(name = "TRANSFER_SEQ", sequenceName = "TRANSFER_SEQ")
    private Integer id;
    private LocalDate date;
    private String userFromEmail;
    private String userToEmail;
    private Double amountBeforeFee;
    private Double amountAfterFee;

}