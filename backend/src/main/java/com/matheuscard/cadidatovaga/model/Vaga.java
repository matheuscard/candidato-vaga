/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mathe
 */
@Entity
public class Vaga implements CadastroVaga, Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private Cargo cargo;
    private String especificacaoDeCargo;
    private double remuneracao;
    private String valeTransporte;
    private String valeRefeicao;
    private String outros;
    private String turno;
    private String formaDeContratacao;
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private Estado estado;
    @ManyToOne
    private Candidato candidato;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getEspecificacaoDeCargo() {
        return especificacaoDeCargo;
    }

    public void setEspecificacaoDeCargo(String especificacaoDeCargo) {
        this.especificacaoDeCargo = especificacaoDeCargo;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFormaDeContratacao() {
        return formaDeContratacao;
    }

    public void setFormaDeContratacao(String formaDeContratacao) {
        this.formaDeContratacao = formaDeContratacao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(String valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public String getValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(String valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }
    
}
