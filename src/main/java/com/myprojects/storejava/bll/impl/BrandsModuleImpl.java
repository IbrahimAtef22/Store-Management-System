package com.myprojects.storejava.bll.impl;

import com.myprojects.storejava.bll.BrandsModule;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import storejava.dal.hibernate.HibernateDBManager;
import storejava.dal.hibernate.entity.Brands;
import storejava.dal.hibernate.entity.Sizes;

public class BrandsModuleImpl implements BrandsModule {

    @Override
    public Sizes addSize(Sizes size) {
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            // start a transaction
            commonRepo.beginTransaction();
            // insert into table  Sizes using save() method
            Integer id = (Integer) commonRepo.save(size);

            size.setId(id);

            // if transaction is successfully done, save this transaction
            commonRepo.getTransaction().commit();

            return size;
        } catch (Exception ex) {
            commonRepo.getTransaction().rollback();
            throw ex;

        }
    }

    @Override
    public Sizes editSize(Sizes size) {
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            // start a transaction
            commonRepo.beginTransaction();
            // update into table Sizes
            String qryString = "UPDATE Sizes SET name = ? WHERE id = ?";
            Query query = commonRepo.createQuery(qryString);
            query.setParameter(0, size.getName());
            query.setParameter(1, size.getId());
            query.executeUpdate();
            // if transaction is successfully done, save this transaction
            commonRepo.getTransaction().commit();

            return size;
        } catch (Exception ex) {
            commonRepo.getTransaction().rollback();
            throw ex;

        }
    }

    @Override
    public void deleteSize(Sizes size) {
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            // start a transaction
            commonRepo.beginTransaction();
            // delete from table Sizes
            String qryString = "DELETE FROM Sizes WHERE id = ?";
            Query query = commonRepo.createQuery(qryString);
            query.setParameter(0, size.getId());
            query.executeUpdate();
            // if transaction is successfully done, save this transaction
            commonRepo.getTransaction().commit();

        } catch (Exception ex) {
            commonRepo.getTransaction().rollback();
            throw ex;

        }
    }

    @Override
    public List<Sizes> findAllSizes() {
         Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();

        try {
            commonRepo.beginTransaction();

            String hqlQuery = "FROM Sizes";

            Query query
                    = commonRepo.createQuery(hqlQuery);

            List<Sizes> resultList = query.getResultList();

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
    public Sizes findSize(Sizes size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Brands addBrand(Brands brand) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Brands editBrand(Brands brand) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteBrand(Brands brand) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Brands> findAllBrands() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Brands findBrand(Brands brand) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
