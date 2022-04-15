package com.example.bank.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "accounts_transfer_history")
public class TransferEntity {
    @Id
    @GeneratedValue(generator = "accounts_transfer_history_id_gen")
    @SequenceGenerator(name = "accounts_transfer_history_id_gen", sequenceName = "accounts_transfer_history_id_seq", allocationSize = 1)
    private Integer id;
    @Column
    private Integer accountsFrom;
    @Column
    private Integer accountsTo;
    @Column
    private BigDecimal amount;
    @Column
    private Timestamp transferTime;
    @Column
    private String transferStatus;
}
