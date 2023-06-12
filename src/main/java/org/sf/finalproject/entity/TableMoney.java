package org.sf.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Table_Money", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID"),
                @UniqueConstraint(columnNames = "USER_ID")
        } )
public class TableMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long ID;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_BALANCE")
    private String userBalance;
}
