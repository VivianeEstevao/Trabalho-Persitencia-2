/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.*;
import Hibernate.HibernatePostgres;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ktia-
 */
public class DAOpostgres {
    //Data Acess Object

    public void Save(Entidades obj) {
        Transaction transaction = null;
        Session session = HibernatePostgres.getSessionFactory().openSession();
        try {

            //Start
            transaction = session.beginTransaction();

            //Salvar
            session.save(obj);
            session.flush();
            //Comitar / gravar no banco e finalizar
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void Update(Entidades obj) {
        Transaction transaction = null;
        Session session = HibernatePostgres.getSessionFactory().openSession();
        try {
            //Start
            transaction = session.beginTransaction();

            //Salvar
            session.saveOrUpdate(obj);
            session.flush();

            //Comitar / gravar no banco e finalizar
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void Delete(String tabela, long id) {
        Transaction transaction = null;
        Entidades obj = null;
        Session session = HibernatePostgres.getSessionFactory().openSession();
        try {

            //Start
            transaction = session.beginTransaction();

            //Salvar
            switch (tabela) {

                case "Clientes":
                    obj = session.get(Clientes.class, id);
                    session.delete(obj);
                    break;

                case "Funcionarios":
                    obj = session.get(Funcionarios.class, id);
                    session.delete(obj);
                    break;

                case "Produtos":
                    obj = session.get(Produtos.class, id);
                    session.delete(obj);
                    break;

                case "Vendas":
                    obj = session.get(Vendas.class, id);
                    session.delete(obj);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!!!\n Verifique: nome da Tabela");
                    break;

            }

            session.flush();
            //Comitar / gravar no banco e finalizar
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            session.close();
        }

    }

    public Entidades getByID(String tabela, long id) {
        Transaction transaction = null;
        Entidades obj = null;
        Session session = HibernatePostgres.getSessionFactory().openSession();
        try {

            //Start
            transaction = session.beginTransaction();

            //Salvar
            switch (tabela) {

                case "Clientes":
                    obj = session.get(Clientes.class, id);
                    break;

                case "Funcionarios":
                    obj = session.get(Funcionarios.class, id);
                    break;

                case "Produtos":
                    obj = session.get(Produtos.class, id);
                    break;

                case "Vendas":
                    obj = session.get(Vendas.class, id);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!!!\n Verifique: nome da Tabela");
                    break;

            }
            session.flush();
            //Comitar / gravar no banco e finalizar
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            session.close();
        }
        return obj;
    }

    public List<Entidades> getLista(String tabela) {
        Transaction transaction = null;
        List<Entidades> lista = null;
        Session session = HibernatePostgres.getSessionFactory().openSession();
        try {

            //Start
            transaction = session.beginTransaction();
            System.out.println("Estado da transaction: " + transaction.getStatus());

            //Salvar
            lista = session.createQuery("from " + tabela).list();
            System.out.println("Estado da sessão: " + session.getStatistics());
            session.flush();

            //Comitar / gravar no banco e finalizar
            transaction.commit();
            System.out.println("Estado da transaction: " + transaction.getStatus());

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Erro: " + e.getMessage());
        } finally {
            session.close();
        }
        return lista;
    }

}
