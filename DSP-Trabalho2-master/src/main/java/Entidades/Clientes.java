/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dani
 */
@Entity
@Table(name = "clientes")
public class Clientes extends Entidades implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ultimoNome")
    private String ultimoNome;

    @Column(name = "email")
    private String email;

    @Column(name = "cel")
    private String cel;

    @Column(name = "cpf")
    private String cpf;

    public Clientes() {
    }

    public Clientes(String nome, String ultimoNome, String email, String cel, String cpf) {
        this.nome = nome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.cel = cel;
        this.cpf = cpf;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        String oldUltimoNome = this.ultimoNome;
        this.ultimoNome = ultimoNome;
        changeSupport.firePropertyChange("ultimoNome", oldUltimoNome, ultimoNome);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        String oldCel = this.cel;
        this.cel = cel;
        changeSupport.firePropertyChange("cel", oldCel, cel);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
