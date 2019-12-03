/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciar;

import DAO.DAOmysql;
import DAO.DAOpostgres;
import Entidades.Clientes;
import Entidades.Funcionarios;
import Entidades.Produtos;
import Entidades.Vendas;
import Gerenciar.CRUD;

/**
 *
 * @author ktia-
 */
public class GerenciarVendas {

    public static void main(String[] args) {
        
       CRUD crud = new CRUD();
        String tabela = null;
        tabela = "Clientes";
       crud.VerificaCliente(true, tabela, 1);


    }
}
