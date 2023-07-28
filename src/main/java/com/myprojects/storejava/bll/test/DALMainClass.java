package com.myprojects.storejava.bll.test;

import storejava.dal.hibernate.HibernateDBManager;


public class DALMainClass {
    public static void main(String[] args) {
        try {
            String filename = "storejava\\dal\\hibernate\\hibernate.cfg.xml";
            HibernateDBManager.setDbConfigFilename(filename);
            HibernateDBManager.buildSessionFactory();
            
            DBTestCases dbtc = new DBTestCases();
            //dbtc.insertCategory();
            
            //dbtc.findAllCategoriesNative();
            dbtc.findAllCategoriesHQL();
            
            
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
