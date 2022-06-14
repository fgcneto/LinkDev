package com.linkdev.linkdev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    public Company(String username, String password, String nameCompany,
                   String cnpj, String contact_email, String linkSite,
                   String socialMidia) {
        this.nameCompany = nameCompany;
        this.cnpj = cnpj;
        this.contact_email = contact_email;
        this.linkSite = linkSite;
        this.socialMidia = socialMidia;
    }
}
