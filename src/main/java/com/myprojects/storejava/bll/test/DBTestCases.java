package com.myprojects.storejava.bll.test;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import storejava.dal.hibernate.HibernateDBManager;
import storejava.dal.hibernate.entity.Categories;

public class DBTestCases {

    public void insertCategory() {
        // from SessionFactory, give me a current session
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();
        
        // state 1  :  newCategory  -->  Transient Object ---> means " created by myself and not yet associated with database
        Categories newCategory = new Categories();
        newCategory.setName("Maven Java");
        newCategory.setDescription("some text");

        try {
            // start a transaction
            commonRepo.beginTransaction();
            // insert into table Category using save() method
            Integer savedCategoryId = (Integer) commonRepo.save(newCategory);
            // state 2 :  newCategory --> Persistent Object --> associated with hibernate session (database)

            if (null != savedCategoryId) {
                System.out.println(savedCategoryId);
            }
            // if transaction is successfully done, save this transaction
            commonRepo.getTransaction().commit();

        } catch (HibernateException ex) {
            System.err.println("Database Error : " + ex.getMessage());
            // if transaction is still active, rollback this tranaction and don't save
            // if transaction is not active, this mean exception occurs before beginning the transaction, so don't rollback
            if (commonRepo.getTransaction().isActive()) {
                commonRepo.getTransaction().rollback();
            }
        }
        // state 3 : newCategory --> Detached Object --> was associated with database and now not 
    }
    
    public void findAllCategoriesNative(){
            Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();
            
            try{
                commonRepo.beginTransaction();
                
                String nativeQuery = "SELECT * FROM categories;";
                
                Query query =
                            commonRepo.createNativeQuery(nativeQuery, Categories.class);
                
                List<Categories> resultList = query.getResultList();
                
                for(Categories iCategory : resultList){
                    System.out.print(iCategory.getId());
                    System.out.print(" : ");
                    System.out.println(iCategory.getName());
                }

                commonRepo.getTransaction().commit();

            } catch(Exception ex){
                System.err.println("Database Error : " + ex.getMessage());
                // if transaction is still active, rollback this tranaction and don't save
                // if transaction is not active, this mean exception occurs before beginning the transaction, so don't rollback
                if (commonRepo.getTransaction().isActive()) {
                    commonRepo.getTransaction().rollback();
                }
            }
    }
    
    public void findAllCategoriesHQL(){
        Session commonRepo = HibernateDBManager.getDbSessionFactory().getCurrentSession();
            
            try{
                commonRepo.beginTransaction();
                
                String hqlQuery = "FROM Categories";
                
                
                Query query
                                    = commonRepo.createQuery(hqlQuery);
                
                List<Categories> resultList = query.getResultList();
                
                for(Categories iCategory : resultList){
                    System.out.print(iCategory.getId());
                    System.out.print(" : ");
                    System.out.println(iCategory.getName());
                }

                commonRepo.getTransaction().commit();

            } catch(Exception ex){
                System.err.println("Database Error : " + ex.getMessage());
                // if transaction is still active, rollback this tranaction and don't save
                // if transaction is not active, this mean exception occurs before beginning the transaction, so don't rollback
                if (commonRepo.getTransaction().isActive()) {
                    commonRepo.getTransaction().rollback();
                }
            }
    }
    
    
    
}
