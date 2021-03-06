package com.linkdev.linkdev.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;


@Entity
@Data
@NoArgsConstructor
@Table(name = "companies")
public class Company extends User {

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

    @OneToMany(mappedBy = "company")
    private Collection<JobOpportunity> jobOpportunityList = new LinkedHashSet<JobOpportunity>();;

    public Company(String username, String password, String nameCompany,
                   String cnpj, String contact_email, String linkSite,
                   String socialMidia) {
        super(username, password);
        this.nameCompany = nameCompany;
        this.cnpj = cnpj;
        this.contact_email = contact_email;
        this.linkSite = linkSite;
        this.socialMidia = socialMidia;
    }

}
