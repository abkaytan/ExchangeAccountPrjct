package com.patika.exchangeAccountDeneme.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double tl; //bigdecimal
    private double gold;
    private double dollar;
    private double euro;

    private long customerId;


    /*@OneToOne
    private Customer customer;


    @JsonManagedReference
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AccountDetails> details = new ArrayList<>();*/
}
