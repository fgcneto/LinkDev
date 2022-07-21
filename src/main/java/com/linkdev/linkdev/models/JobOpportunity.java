package com.linkdev.linkdev.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "jobopportunities")
public class JobOpportunity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 250)
    private String title;

    @Column(length = 100)
    private String typeOfContract;

    @Column(length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public JobOpportunity(String title, String typeOfContract, String description, Company company) {
        this.title = title;
        this.typeOfContract = typeOfContract;
        this.description = description;
        this.company = company;
    }

    public String getCompany() {
        if(company == null){
            return "-";
        }
        return company.getNameCompany();
    }
}
