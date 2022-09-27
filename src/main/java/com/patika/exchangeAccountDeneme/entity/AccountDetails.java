package com.patika.exchangeAccountDeneme.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.patika.exchangeAccountDeneme.entity.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "account_details")
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_detail_id")
    private long id;

    @CreatedDate
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /*private Currency currency;*/
    private double operation;

    private String summary;

    @Column(name = "account_id")
    private long accountId;


    /*@ManyToOne
    private Account account;*/

}
