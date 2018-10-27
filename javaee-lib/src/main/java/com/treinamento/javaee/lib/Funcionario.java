/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treinamento.javaee.lib;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Gustavo Santos
 */
@Entity
@TableGenerator(name = "funcionario_generator", initialValue = 1, allocationSize = 1)
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "funcionario_generator")
    private Long id;

    @Column(length = 500, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    @CPF(message = "CPF inválido!")
    private String cpf;

    @Column(nullable = false)
    private Double salario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataNascimento;

    private Boolean ativo = true;

    @Column(length = 11)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "funcao_id", referencedColumnName = "id")
    private Funcao funcao;

    public Funcionario() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", dataNascimento=" + dataNascimento + ", ativo=" + ativo + ", telefone=" + telefone + ", funcao=" + funcao + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

}
