/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author mathe
 */
@Entity
public class Candidato implements CadastroVaga,Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
     private String login;
    private String senha;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String endereco;
    private String tipoEndereco;
    private String bairro;
    private String cpf;
    private String cep;
    private String email;
    private String sexo;
    private String estadoCivil;
    private String dataNascimento;
    private String dataExpedicao;
    private String numeroRg;
    private String orgaoExpeditor;
    private String ufExpedicao;
    private boolean receberNoticias;
    private boolean isEmpresa;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Experiencia> experienciaProfissional = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    private List<Vaga> vaga = new ArrayList<>();
    
    @ManyToOne
    private Cargo cargo; //será o cargo de interesse.
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private Estado estado;

    public boolean isIsEmpresa() {
        return isEmpresa;
    }

    public void setIsEmpresa(boolean isEmpresa) {
        this.isEmpresa = isEmpresa;
    }

    public List<Vaga> getVaga() {
        return vaga;
    }

    public void setVaga(List<Vaga> vaga) {
        this.vaga = vaga;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    
    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public List<Experiencia> getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public void setExperienciaProfissional(List<Experiencia> experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getUfExpedicao() {
        return ufExpedicao;
    }

    public void setUfExpedicao(String ufExpedicao) {
        this.ufExpedicao = ufExpedicao;
    }

    public boolean isReceberNoticias() {
        return receberNoticias;
    }

    public void setReceberNoticias(boolean receberNoticias) {
        this.receberNoticias = receberNoticias;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
