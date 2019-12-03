/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciar;

import DAO.*;
import Entidades.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ktia-
 */
public class CRUD {

    String registro = "";

    public String save(boolean dbAtual, String tabela, String col1, String col2,
            String col3, String col4, String col5) {

        if (!dbAtual) {
            DAOmysql daoMsql = new DAOmysql();
            switch (tabela) {
                //Cliente(nome, ultimoNome, email, cel, cpf);
                case "Clientes":
                    Clientes c = new Clientes(col1, col2, col3, col4, col5);
                    daoMsql.Save(c);
                    break;
                //Funcionario(nome, ultimoNome, email, cel);    
                case "Funcionarios":
                    Funcionarios f = new Funcionarios(col1, col2, col3, col4);
                    daoMsql.Save(f);
                    break;
                //Produto(nome, fornecedor, preco, codigo);
                case "Produtos":
                    Produtos p = new Produtos(col1, col2, col3, col4, col5);
                    daoMsql.Save(p);
                    break;
                //Vendas(Produto.nome, Cliente.nome, Funcionário.nome, Produto.preco, Produto.codigo);    
                case "Vendas":
                    Vendas v = new Vendas(col1, col2, col3, col4, col5);
                    daoMsql.Save(v);
                    break;
                default:
                    System.out.println("Erro");
            }
        } else {
            DAOpostgres daoPsql = new DAOpostgres();
            switch (tabela) {
                //Cliente(nome, ultimoNome, email, cel, cpf);
                case "Clientes":
                    dbBackup(false, tabela);
                    Clientes c = new Clientes(col1, col2, col3, col4, col5);
                    daoPsql.Save(c);
                    break;
                //Funcionario(nome, ultimoNome, email, cel); 
                case "Funcionarios":
                    dbBackup(false, tabela);
                    Funcionarios f = new Funcionarios(col1, col2, col3, col4);
                    daoPsql.Save(f);
                    break;
                //Produto(nome, fornecedor, preco, codigo);
                case "Produtos":
                    dbBackup(false, tabela);
                    Produtos p = new Produtos(col1, col2, col3, col4, col5);
                    daoPsql.Save(p);
                    break;
                //Vendas(Produto.nome, Cliente.nome, Funcionário.nome, Produto.preco, Produto.codigo);  
                case "Vendas":
                    dbBackup(false, tabela);
                    Vendas v = new Vendas(col1, col2, col3, col4, col5);
                    daoPsql.Save(v);
                    break;
                default:
                    System.out.println("Erro!");
            }
        }
        return "Salvo com sucesso";
    }

    public String getByID(boolean dbAtual, String tabela, long id) {
        try {
            if (false == dbAtual) {
                DAOmysql daoMsql = new DAOmysql();
                switch (tabela) {
                    case "Clientes":
                        Clientes c;
                        c = (Clientes) daoMsql.getByID(tabela, id);
                        registro = "\nCliente: \nNome:" + c.getNome()
                                + "\nSobrenome:" + c.getUltimoNome()
                                + "\nEmail:" + c.getEmail()
                                + "\nCelular:" + c.getCel()
                                + "\nCPF:" + c.getCpf();
                        break;
                    case "Funcionarios":
                        Funcionarios f;
                        f = (Funcionarios) daoMsql.getByID(tabela, id);
                        registro = "\nFuncionario: \nNome:" + f.getNome()
                                + "\nSobrenome:" + f.getUltimoNome()
                                + "\nEmail:" + f.getEmail()
                                + "\nCelular:" + f.getCel();
                        break;
                    case "Produtos":
                        Produtos p;
                        p = (Produtos) daoMsql.getByID(tabela, id);
                        registro = "\nProduto: \nNome:" + p.getNome()
                                + "\nFornecedor:" + p.getFornecedor()
                                + "\nPreço:" + p.getPreco()
                                //+ "\nCodigo:" + p.getCodigo()
                                + "\nQuantidade:" + p.getQuantidade();
                        break;
                    case "Vendas":
                        Vendas v;
                        v = (Vendas) daoMsql.getByID(tabela, id);
                        registro = "\nVenda: \nNome cliente:" + v.getNomeCliente()
                                + "\nNome funcionario:" + v.getNomeFuncionario()
                                + "\nNome produto:" + v.getNomeProduto()
                                + "\nPreco produto:" + v.getPrecoProduto()
                                + "\nQuantidade Poduto:" + v.getQuantidade();
                               
                        break;
                    default:
                        registro = "Ops! Algo deu errado.";
                        break;
                }
            } else {
                DAOpostgres daoPsql = new DAOpostgres();
                switch (tabela) {
                    case "Clientes":
                        Clientes c;
                        c = (Clientes) daoPsql.getByID(tabela, id);
                        registro = "\nCliente: \nNome:" + c.getNome()
                                + "\nSobrenome:" + c.getUltimoNome()
                                + "\nEmail:" + c.getEmail()
                                + "\nCelular:" + c.getCel() + "\nCPF:" + c.getCpf();
                        break;
                    case "Funcionarios":
                        Funcionarios f;
                        f = (Funcionarios) daoPsql.getByID(tabela, id);
                        registro = "\nFuncionario: \nNome:" + f.getNome()
                                + "\nSobrenome:" + f.getUltimoNome()
                                + "\nEmail:" + f.getEmail()
                                + "\nCelular:" + f.getCel();
                        break;
                    case "Produtos":
                        Produtos p;
                        p = (Produtos) daoPsql.getByID(tabela, id);
                        registro = "\nProduto: \nNome:" + p.getNome()
                                + "\nSobrenome:" + p.getFornecedor()
                                + "\nEmail:" + p.getPreco()
                                //+ "\nCelular:" + p.getCodigo()
                                + "\nQuantidade Produto:" + p.getQuantidade();

                        break;
                    case "Vendas":
                        Vendas v;
                        v = (Vendas) daoPsql.getByID(tabela, id);
                        registro = "\nVenda: \nNome cliente:" + v.getNomeCliente()
                                + "\nNome funcionario:" + v.getNomeFuncionario()
                                + "\nNome produto:" + v.getNomeProduto()
                                + "\nPreco produto:" + v.getPrecoProduto()
                                + "\nQuanitadade produto:" + v.getQuantidadeProduto();
                        break;
                    default:
                        System.out.println("Ops! Algo deu errado.");
                        break;
                }
            }
        } catch (Exception e) {
            registro = "Ops! Algo deu errado.\nErro: " + e.getMessage();
        }
        return registro;

    }

    public long getAllTable(boolean dbAtual, String tabela) {
        long id = 0;
        if (!dbAtual) {
            DAOmysql daoMsql = new DAOmysql();
            switch (tabela) {
                case "Clientes":
                    List<Entidades> listaC = daoMsql.getLista(tabela);
                    for (int i = 0; i < listaC.size(); i++) {
                        System.out.println("Lista  id: " + listaC.get(i).getId() + "\nNome: " + listaC.get(i).getNome()
                                + "\nSobrenome: " + listaC.get(i).getUltimoNome()
                                + "\nEmail:" + listaC.get(i).getEmail()
                                + "\nCelular:" + listaC.get(i).getCel()
                                + "\nCPF:" + listaC.get(i).getCpf());
                    }
                    id = listaC.size();
                    break;
                case "Funcionarios":
                    List<Entidades> listaF = daoMsql.getLista(tabela);
                    for (int i = 0; i < listaF.size(); i++) {
                        System.out.println("Lista  id: " + listaF.get(i).getId() + "\nNome: " + listaF.get(i).getNome()
                                + "\nSobrenome: " + listaF.get(i).getUltimoNome()
                                + "\nEmail:" + listaF.get(i).getEmail()
                                + "\nCelular:" + listaF.get(i).getCel());
                    }
                    id = listaF.size();
                    break;
                case "Produtos":
                    List<Entidades> listaP = daoMsql.getLista(tabela);
                    for (int i = 0; i < listaP.size(); i++) {
                        System.out.println("Lista  id: " + listaP.get(i).getId() + "\nNome: " + listaP.get(i).getNome()
                                + "\nFornecedor: " + listaP.get(i).getFornecedor()
                                + "\nPreco produto:" + listaP.get(i).getPreco()
                              //  + "\nCodigo produto:" + listaP.get(i).getCodigo()
                                + "\nQuantidade produto:" + listaP.get(i).getQuantidade());
                    }
                    id = listaP.size();
                    break;
                case "Vendas":
                    List<Entidades> listaV = daoMsql.getLista(tabela);
                    for (int i = 0; i < listaV.size(); i++) {
                        System.out.println("Lista  id: " + listaV.get(i).getId() + "\nNome cliente: " + listaV.get(i).getNomeCliente()
                                + "\nNome funcionario: " + listaV.get(i).getNomeFuncionario()
                                + "\nNome produto:" + listaV.get(i).getNomeProduto()
                                + "\nPreco produto:" + listaV.get(i).getPrecoProduto()
                                + "\nQuantidade produto:" + listaV.get(i).getQuantidadeProduto());
                    }
                    id = listaV.size();
                    break;
            }
        } else {
            DAOpostgres daoPsql = new DAOpostgres();
            switch (tabela) {
                case "Clientes":
                    List<Entidades> listaC = daoPsql.getLista(tabela);
                    for (int i = 0; i < listaC.size(); i++) {
                        System.out.println("Lista  id: " + listaC.get(i).getId() + "\nNome: " + listaC.get(i).getNome()
                                + "\nSobrenome: " + listaC.get(i).getUltimoNome()
                                + "\nEmail:" + listaC.get(i).getEmail()
                                + "\nCelular:" + listaC.get(i).getCel()
                                + "\nCPF:" + listaC.get(i).getCpf());
                    }
                    id = listaC.size();
                    break;
                case "Funcionarios":
                    List<Entidades> listaF = daoPsql.getLista(tabela);
                    for (int i = 0; i < listaF.size(); i++) {
                        System.out.println("Lista  id: " + listaF.get(i).getId() + "\nNome: " + listaF.get(i).getNome()
                                + "\nSobrenome: " + listaF.get(i).getUltimoNome()
                                + "\nEmail:" + listaF.get(i).getEmail()
                                + "\nCelular:" + listaF.get(i).getCel());
                    }
                    id = listaF.size();
                    break;
                case "Produtos":
                    List<Entidades> listaP = daoPsql.getLista(tabela);
                    for (int i = 0; i < listaP.size(); i++) {
                        System.out.println("Lista  id: " + listaP.get(i).getId() + "\nNome: " + listaP.get(i).getNome()
                                + "\nFornecedor: " + listaP.get(i).getFornecedor()
                                + "\nPreco produto:" + listaP.get(i).getPreco()
                               // + "\nCodigo produto:" + listaP.get(i).getCodigo()
                                + "\nQuantidade produto:" + listaP.get(i).getQuantidade());
                    }
                    id = listaP.size();
                    break;
                case "Vendas":
                    List<Entidades> listaV = daoPsql.getLista(tabela);
                    for (int i = 0; i < listaV.size(); i++) {
                        System.out.println("Lista  id: " + listaV.get(i).getId() + "\nNome cliente: " + listaV.get(i).getNomeCliente()
                                + "\nNome funcionario: " + listaV.get(i).getNomeFuncionario()
                                + "\nNome produto:" + listaV.get(i).getNomeProduto()
                                + "\nPreco produto:" + listaV.get(i).getPrecoProduto()
                                + "\nQuantidade produto:" + listaV.get(i).getQuantidadeProduto());
                    }
                    id = listaV.size();
                    break;
            }
        }
        id++;
        return id;

    }

    public boolean checkID(boolean dbAtual, String tabela, long id) {
        boolean idCheck;
        if (getByID(dbAtual, tabela, id).equalsIgnoreCase("Ops! Algo deu errado.\nErro: null")) {
            idCheck = false;
        } else if (getByID(dbAtual, tabela, id).equalsIgnoreCase("Ops! Algo deu errado.")) {
            idCheck = false;
        } else {
            idCheck = true;
        }
        return idCheck;

    }

    public String update(boolean dbAtual, String tabela, long id, String col1, String col2,
            String col3, String col4, String col5) {
        CRUD crud = new CRUD();
        if (!crud.checkID(dbAtual, tabela, id)) {
            System.out.println("Ops! Algo deu errado.");
        } else {
            try {
                if (false == dbAtual) {
                    DAOmysql daoMsql = new DAOmysql();
                    switch (tabela) {
                        //Cliente(nome, ultimoNome, email, cel, cpf);
                        case "Clientes":
                            Clientes c = (Clientes) daoMsql.getByID(tabela, id);
                            c.setNome(col1);
                            c.setUltimoNome(col2);
                            c.setEmail(col3);
                            c.setCel(col4);
                            c.setCpf(col5);
                            daoMsql.Update(c);
                            break;
                        //Funcionario(nome, ultimoNome, email, cel);    
                        case "Funcionarios":
                            Funcionarios f = (Funcionarios) daoMsql.getByID(tabela, id);
                            f.setNome(col1);
                            f.setUltimoNome(col2);
                            f.setEmail(col3);
                            f.setCel(col4);
                            daoMsql.Update(f);
                            break;
                        //Produto(nome, fornecedor, preco, codigo);
                        case "Produtos":
                            Produtos p = (Produtos) daoMsql.getByID(tabela, id);
                            p.setNome(col1);
                            p.setFornecedor(col2);
                            p.setPreco(col3);
                            p.setQuantidade(col4);
                            daoMsql.Update(p);
                            break;
                        //Vendas(Produto.nome, Cliente.nome, Funcionário.nome, Produto.preco, Produto.codigo);    
                        case "Vendas":
                            Vendas v = (Vendas) daoMsql.getByID(tabela, id);
                            v.setNomeProduto(col1);
                            v.setNomeCliente(col2);
                            v.setNomeFuncionario(col3);
                            v.setPrecoProduto(col4);
                            v.setQuantidadeProduto(col5);
                            daoMsql.Update(v);
                            break;
                        default:
                            System.out.println("Erro");
                    }
                }
                DAOpostgres daoPsql = new DAOpostgres();
                switch (tabela) {
                    //Cliente(nome, ultimoNome, email, cel, cpf);
                    case "Clientes":
                        Clientes c = (Clientes) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, c.getNome(), c.getUltimoNome(),
                                    c.getEmail(), c.getCel(), c.getCpf());
                        } else {
                            update(false, tabela, c.getId(), c.getNome(),
                                    c.getUltimoNome(), c.getEmail(), c.getCel(), c.getCpf());
                        }
                        c.setNome(col1);
                        c.setUltimoNome(col2);
                        c.setEmail(col3);
                        c.setCel(col4);
                        c.setCpf(col5);
                        daoPsql.Update(c);
                        break;
                    //Funcionario(nome, ultimoNome, email, cel);    
                    case "Funcionarios":
                        Funcionarios f = (Funcionarios) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, f.getNome(), f.getUltimoNome(),
                                    f.getEmail(), f.getCel(), "");
                        } else {
                            update(false, tabela, f.getId(), f.getNome(), f.getUltimoNome(),
                                    f.getEmail(), f.getCel(), "");
                        }
                        f.setNome(col1);
                        f.setUltimoNome(col2);
                        f.setEmail(col3);
                        f.setCel(col4);
                        daoPsql.Update(f);
                        break;
                    //Produto(nome, fornecedor, preco, codigo);
                    case "Produtos":
                        Produtos p = (Produtos) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, p.getNome(), p.getFornecedor(),
                                    p.getPreco(), p.getQuantidade(), "");
                        } else {
                            update(false, tabela, p.getId(), p.getNome(), p.getFornecedor(),
                                    p.getPreco(), p.getQuantidade(), "");
                        }
                        p.setNome(col1);
                        p.setFornecedor(col2);
                        p.setPreco(col3);
                        p.setQuantidade(col4);
                        daoPsql.Update(p);
                        break;
                    //Vendas(Produto.nome, Cliente.nome, Funcionário.nome, Produto.preco, Produto.codigo);    
                    case "Vendas":
                        Vendas v = (Vendas) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, v.getNomeProduto(), v.getNomeCliente(), v.getNomeFuncionario(),
                                    v.getPrecoProduto(), v.getQuantidadeProduto());
                        } else {
                            update(false, tabela, v.getId(), v.getNomeProduto(), v.getNomeCliente(),
                                    v.getNomeFuncionario(), v.getPrecoProduto(), v.getQuantidadeProduto());
                        }
                        v.setNomeProduto(col1);
                        v.setNomeCliente(col2);
                        v.setNomeFuncionario(col3);
                        v.setQuantidadeProduto(col4);
                        daoPsql.Update(v);
                        break;
                    default:
                        System.out.println("Erro");
                }
            } catch (Exception e) {
                System.out.println("Ops! Algo deu errado.\nErro: " + e.getMessage());
            }
        }
        return "Atualizado";
    }

    public long lastID(boolean dbAtual, String tabela) {

        long id = getAllTable(dbAtual, tabela);

//        boolean quit = false;        
//        long id = 0;
//        registro = "";
//        do {
//            id++;
//            registro = getByID(dbAtual, tabela, id);
//            if (!"Ops! Algo deu errado.\nErro: null".equalsIgnoreCase(registro)
//                    && !"Ops! Algo deu errado.".equalsIgnoreCase(registro)) {
//                quit = false;
//            } else {
//                quit = true;
//            }
//        } while (!quit);
        return --id;
    }

    public void dbBackup(boolean dbAtual, String tabela) {
        try {
            if (!checkID(dbAtual, tabela, lastID(true, tabela)) && checkID(true, tabela, lastID(true, tabela))) {
                DAOpostgres daoPsql = new DAOpostgres();
                switch (tabela) {
                    //Cliente(nome, ultimoNome, email, cel, cpf);
                    case "Clientes":
                        Clientes c = (Clientes) daoPsql.getByID(tabela, lastID(true, tabela));
                        save(false, tabela, c.getNome(), c.getUltimoNome(),
                                c.getEmail(), c.getCel(), c.getCpf());
                        break;
                    //Funcionario(nome, ultimoNome, email, cel);    
                    case "Funcionarios":
                        Funcionarios f = (Funcionarios) daoPsql.getByID(tabela, lastID(true, tabela));
                        save(false, tabela, f.getNome(), f.getUltimoNome(),
                                f.getEmail(), f.getCel(), "");
                        break;
                    //Produto(nome, fornecedor, preco, codigo);
                    case "Produtos":
                        Produtos p = (Produtos) daoPsql.getByID(tabela, lastID(true, tabela));
                        save(false, tabela, p.getNome(), p.getFornecedor(),p.getPreco(), 
                                p.getQuantidade(), "");
                        break;
                    //Vendas(Produto.nome, Cliente.nome, Funcionário.nome, Produto.preco, Produto.codigo);    
                    case "Vendas":
                        Vendas v = (Vendas) daoPsql.getByID(tabela, lastID(true, tabela));
                        save(false, tabela, v.getNomeProduto(), v.getNomeCliente(), v.getNomeFuncionario(),
                                v.getPrecoProduto(), v.getQuantidadeProduto());
                        break;
                    default:
                        System.out.println("Ops! Algo deu errado.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ops! Algo deu errado.\nErro: " + e.getMessage());
        }

    }

    public String delete(boolean dbAtual, String tabela, long id) {
        CRUD crud = new CRUD();
        if (!crud.checkID(dbAtual, tabela, id)) {
            System.out.println("Ops! Algo deu errado.");
        } else {
            try {
                if (!dbAtual) {
                    DAOmysql daoMsql = new DAOmysql();
                    daoMsql.Delete(tabela, id);
                    crud.getAllTable(dbAtual, tabela);
                }
                DAOpostgres daoPsql = new DAOpostgres();
                switch (tabela) {
                    //Cliente(nome, ultimoNome, email, cel, cpf);
                    case "Clientes":
                        Clientes c = (Clientes) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, c.getNome(), c.getUltimoNome(),
                                    c.getEmail(), c.getCel(), c.getCpf());
                        } else {
                            update(false, tabela, c.getId(), c.getNome(),
                                    c.getUltimoNome(), c.getEmail(), c.getCel(), c.getCpf());
                        }
                        daoPsql.Delete(tabela, id);
                        crud.getAllTable(dbAtual, tabela);
                        break;
                    //Funcionario(nome, ultimoNome, email, cel);    
                    case "Funcionarios":
                        Funcionarios f = (Funcionarios) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, f.getNome(), f.getUltimoNome(),
                                    f.getEmail(), f.getCel(), "");
                        } else {
                            update(false, tabela, f.getId(), f.getNome(), f.getUltimoNome(),
                                    f.getEmail(), f.getCel(), "");
                        }
                        daoPsql.Delete(tabela, id);
                        crud.getAllTable(dbAtual, tabela);
                        break;
                    //Produto(nome, fornecedor, preco, codigo);
                    case "Produtos":
                        Produtos p = (Produtos) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, p.getNome(), p.getFornecedor(),
                                    p.getPreco(), p.getQuantidade(), "");
                        } else {
                            update(false, tabela, p.getId(), p.getNome(), p.getFornecedor(),
                                    p.getPreco(), p.getCodigo(), "");
                        }
                        daoPsql.Delete(tabela, id);
                        crud.getAllTable(dbAtual, tabela);
                        break;
                    //Vendas(Produto.nome, Cliente.nome, Funcionário.nome, Produto.preco, Produto.codigo);    
                    case "Vendas":
                        Vendas v = (Vendas) daoPsql.getByID(tabela, id);
                        if (!checkID(false, tabela, id)) {
                            save(false, tabela, v.getNomeProduto(), v.getNomeCliente(), v.getNomeFuncionario(),
                                    v.getPrecoProduto(), v.getQuantidadeProduto());
                        } else {
                            update(false, tabela, v.getId(), v.getNomeProduto(), v.getNomeCliente(),
                                    v.getNomeFuncionario(), v.getPrecoProduto(), v.getQuantidadeProduto());
                        }
                        daoPsql.Delete(tabela, id);
                        crud.getAllTable(dbAtual, tabela);
                        break;
                    default:
                        System.out.println("Erro");
                }
            } catch (Exception e) {
                System.out.println("Ops! Algo deu errado.\nErro: " + e.getMessage());
            }
        }
        return "Excluído com sucesso";
    }
    
     public String VerificaCliente(boolean dbAtual, String tabela, long id  ) {
 CRUD crud = new CRUD();
   
        String registro= "";
        try{
            
            if(true == dbAtual){
                if (crud.checkID(dbAtual, tabela, id)){
                    JOptionPane.showMessageDialog(null, "ID não econtrado");
                }else{
                    DAOpostgres daoPsql = new DAOpostgres();
                    Clientes c;
                    c = (Clientes) daoPsql.getByID(tabela, id);
                    registro = c.getNome();
                }
            }else{
                 if (crud.checkID(dbAtual, tabela, id)){
                DAOmysql daoMsql = new DAOmysql();
                 Clientes c;
                        c = (Clientes) daoMsql.getByID(tabela, id);
                        registro = c.getNome();
                 }else{
                     JOptionPane.showMessageDialog(null, "ID não econtrado");
                 }
            
            }
        } catch (Exception e) {
            registro = "Ops! Algo deu errado. CRUD.getById: linha 172\nErro: " + e.getMessage();
        }
        return registro;
    }

}
