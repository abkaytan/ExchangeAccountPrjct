package com.patika.exchangeAccountDeneme.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "customer")
public class Customer extends AbstractBaseEntity{

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;*/


    private String fullName;
    private String password;


    /*@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    private Account account;*/

}
