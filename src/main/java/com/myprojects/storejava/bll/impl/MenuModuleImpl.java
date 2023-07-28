package com.myprojects.storejava.bll.impl;

import com.myprojects.storejava.bll.MenuModule;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import storejava.dal.hibernate.HibernateDBManager;
import storejava.dal.hibernate.entity.Categories;
import storejava.dal.hibernate.entity.Products;

/**
 *
 * @author Ibrahim22
 */
public class MenuModuleImpl implements MenuModule {

    @Override
    public Categories addCategory(Categories category) {
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            // start a transaction
            commonRepo.beginTransaction();
            // insert into table Category using save() method
            Integer id = (Integer) commonRepo.save(category);

            category.setId(id);

            // if transaction is successfully done, save this transaction
            commonRepo.getTransaction().commit();

            return category;
        } catch (Exception ex) {
            commonRepo.getTransaction().rollback();
            throw ex;

        }
    }

    @Override
    public Categories editCategory(Categories category) {
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            // start a transaction
            commonRepo.beginTransaction();
            // update into table Category
            String qryString = "UPDATE Categories  SET name = ?, description = ? WHERE id = ?";
            Query query = commonRepo.createQuery(qryString);
            query.setParameter(0, category.getName());
            query.setParameter(1, category.getDescription());
            query.setParameter(2, category.getId());
            query.executeUpdate();
            // if transaction is successfully done, save this transaction
            commonRepo.getTransaction().commit();

            return category;
        } catch (Exception ex) {
            commonRepo.getTransaction().rollback();
            throw ex;

        }
    }

    @Override
    public void deleteCategory(Categories category) {
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            // start a transaction
            commonRepo.beginTransaction();
            // delete from table Category
            String qryString = "DELETE FROM Categories WHERE id = ?";
            Query query = commonRepo.createQuery(qryString);
            query.setParameter(0, category.getId());
            query.executeUpdate();
            // if transaction is successfully done, save this transaction
            commonRepo.getTransaction().commit();

        } catch (Exception ex) {
            commonRepo.getTransaction().rollback();
            throw ex;

        }
    }

    @Override
    public List<Categories> findAllCategories() {
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            commonRepo.beginTransaction();

            String hqlQuery = "FROM Categories";

            Query query
                    = commonRepo.createQuery(hqlQuery);

            List<Categories> resultList = query.getResultList();

            commonRepo.getTransaction().commit();
            return resultList;

        } catch (Exception ex) {

            // if transaction is still active, rollback this tranaction and don't save
            // if transaction is not active, this mean exception occurs before beginning the transaction, so don't rollback
            if (commonRepo.getTransaction().isActive()) {
                commonRepo.getTransaction().rollback();

            }
            throw ex;
        }
    }

    @Override
    public Categories findCategory(Categories category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Products addProduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Products editProduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteProduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Products> findAllProducts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Products findProduct(Products product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
