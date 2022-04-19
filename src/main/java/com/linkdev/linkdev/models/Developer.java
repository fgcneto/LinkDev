package com.linkdev.linkdev.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer extends Person{

    @Column(length = 11, nullable = false)
    private String cpf;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birth_date;

    @OneToMany
    private List<Skill> skills;

    @Column
    private byte resume;

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
