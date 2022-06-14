package com.linkdev.linkdev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nameDev;

    @Column
    private String last_name;

    @Column(length = 11)
    private String cpf;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private String birth_date; //Mudança de 'Date' para 'String' para conseguir cadastrar data

    @Column(length = 100)
    private String contact_email;

    @Column(length = 9)
    private String telephone;

    @Column
    private String resume;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    public Developer(String username, String password, String nameDev,
                     String last_name, String cpf, String birth_date,
                     String contact_email, String telephone) {
        this.nameDev = nameDev;
        this.last_name = last_name;
        this.cpf = cpf;
        this.birth_date = birth_date;
        this.contact_email = contact_email;
        this.telephone = telephone;
    }
}
