/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dani
 */
@Entity
@Table(name = "produtos")
public class Produtos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Produtos() {
    }

    public Long getID() {
        return id;
    }

    @Column(name = "Fornecedor")
    private String fornecedor;

    @Column(name = "preco")
    private String preco;

    @Column(name = "codigo")
    private String codigo;

    public Produtos(String fornecedor, String preco, String codigo) {
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.codigo = codigo;
    }

}
