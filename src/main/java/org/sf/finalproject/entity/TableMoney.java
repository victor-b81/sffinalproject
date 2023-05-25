package org.sf.finalproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Table_Money")
public class TableMoney {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_BALANCE")
    private BigDecimal userBalance;
}
