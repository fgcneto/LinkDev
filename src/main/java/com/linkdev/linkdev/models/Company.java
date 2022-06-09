package com.linkdev.linkdev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idCompany;

    @Column
    private String nameCompany;

    @Column(length = 14)
    private String cnpj;

    @Column(length = 100)
    private String contact_email;

    @Column
    private String linkSite;

    @Column
    private String socialMidia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
