/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAO.DAOmysql;
import DAO.DAOpostgres;
import Gerenciar.CRUD;
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
import javax.swing.JOptionPane;

/**
 *
 * @author ktia-
 */
@Entity
@Table(name = "vendas")
public class Vendas extends Entidades implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nomeProduto")
    private String nomeProduto;

    @Column(name = "nomeCliente")
    private String nomeCliente;

    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;

    @Column(name = "preco")
    private String precoProduto;

    @Column(name = "quantidadeProdutos")
    private String quantidadeProduto;

    public Vendas() {
    }

    public Vendas(String nomeProduto, String nomeCliente, String nomeFuncionario, String precoProduto, String codigoProduto) {
        this.nomeProduto = nomeProduto;
        this.nomeCliente = nomeCliente;
        this.nomeFuncionario = nomeFuncionario;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = codigoProduto;
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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        String oldNomeProduto = this.nomeProduto;
        this.nomeProduto = nomeProduto;
        changeSupport.firePropertyChange("nomeProduto", oldNomeProduto, nomeProduto);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        String oldNomeCliente = this.nomeCliente;
        this.nomeCliente = nomeCliente;
        changeSupport.firePropertyChange("nomeCliente", oldNomeCliente, nomeCliente);
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionarios) {
        String oldNomeFuncionarios = this.nomeFuncionario;
        this.nomeFuncionario = nomeFuncionarios;
        changeSupport.firePropertyChange("nomeFuncionario", oldNomeFuncionarios, nomeFuncionarios);
    }

    public String getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(String precoProduto) {
        String oldPrecoProduto = this.precoProduto;
        this.precoProduto = precoProduto;
        changeSupport.firePropertyChange("precoProduto", oldPrecoProduto, precoProduto);
    }


    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(String quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
     public String VerificaProduto(String registro3) {
//        CRUD novaVenda = new CRUD();
//        boolean dbAtual;
        long id;
        String tabela;
//        String col1, col2, col3, col4, col5;
        registro3 = "";
        tabela = "Produtos";
        id = 1;

        DAOmysql daoMsql = new DAOmysql();
        if (id == id) {
            Produtos p;
            p = (Produtos) daoMsql.getByID(tabela, id);
                    p = (Produtos) daoMsql.getByID(tabela, id);
                        registro3 = "\n" + p.getNome()
                                + "\n" + p.getPreco()
                                //+ "\nCelular:" + p.getCodigo()
                                + "\n" + p.getQuantidade();
            System.out.println(registro3);
//            tabela = "Vendas";
//            dbAtual = true;
//            col1 = "";
//            col2 = "";
//            col3 = ""+registro3;
//            col4 = ""+registro4;
//            col5 = ""+registro5;
//            novaVenda.save(dbAtual, tabela, col1, col2, col3, col4, col5);

        } else {
            System.out.println("ID INEXISTENTE");
        }
        return registro3;


    }

}