package com.example.bank.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "accounts")
public class AccountEntity {
    @GeneratedValue(generator = "accounts_seq_gen")
    @SequenceGenerator(name = "accounts_seq_gen", sequenceName = "accounts_id_seq", allocationSize = 1)
    @Id
    private Integer id;
    @Column
    private Integer userId;
    @Column
    private String accountNumber;
    @Column
    private BigDecimal balance;


}
