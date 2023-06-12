package org.sf.finalproject.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "TABLE_HISTORY_OPERATION", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID"),
        } )
public class TableHistoryOperation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long ID;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "OPERATION_ID")
    private String OPERATION_ID;

    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "date")
    @Basic
    private java.sql.Date date;

    @Column(name = "AMOUNT_TRANSACTION")
    private String AMOUNT_TRANSACTION;

    @Column(name = "COMMENT_TRANSACTION")
    private String COMMENT_TRANSACTION;

    public TableHistoryOperation() {
        super();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOPERATION_ID() {
        return OPERATION_ID;
    }

    public void setOPERATION_ID(String OPERATION_ID) {
        this.OPERATION_ID = OPERATION_ID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getAMOUNT_TRANSACTION() {
        return AMOUNT_TRANSACTION;
    }

    public void setAMOUNT_TRANSACTION(String AMOUNT_TRANSACTION) {
        this.AMOUNT_TRANSACTION = AMOUNT_TRANSACTION;
    }

    public String getCOMMENT_TRANSACTION() {
        return COMMENT_TRANSACTION;
    }

    public void setCOMMENT_TRANSACTION(String COMMENT_TRANSACTION) {
        this.COMMENT_TRANSACTION = COMMENT_TRANSACTION;
    }
}