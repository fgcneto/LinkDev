package com.linkdev.linkdev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "developers")
public class Developer extends Person{

    @Column(length = 11)
    private String cpf;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birth_date;

    @OneToMany
    private List<Skill> skills;

    @Column
    private byte resume;

    public Developer(Long id,
                     @NotBlank(message = "O nome deve ser preenchido")
                     @Size(min = 2, max = 250, message = "O nome deve conter entre 2 e no máximo 250 caracteres")
                     String name, String contact_email, String cell_phone, String telephone,
                     String street, String zip_code, String city, String state, String complement) {
        super(id, name, contact_email, cell_phone, telephone, street, zip_code, city, state, complement);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public byte getResume() {
        return resume;
    }

    public void setResume(byte resume) {
        this.resume = resume;
    }
}
