package com.linkdev.linkdev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developers")
public class Developer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDev;

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
}
