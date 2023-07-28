package com.myprojects.storejava.bll;

import com.myprojects.storejava.bll.impl.BranchesModuleImpl;
import com.myprojects.storejava.bll.impl.BrandsModuleImpl;
import com.myprojects.storejava.bll.impl.MenuModuleImpl;
import java.util.List;
import storejava.dal.hibernate.HibernateDBManager;
import storejava.dal.hibernate.entity.Branches;
import storejava.dal.hibernate.entity.Brands;
import storejava.dal.hibernate.entity.Categories;
import storejava.dal.hibernate.entity.Products;
import storejava.dal.hibernate.entity.Sizes;
// This is a Delegatorمفوض class just contains all methods of classes which implements all interfaces
// which contain all features of project 
// This class is useful to collect all features of project in one place to be easy to call these functions and used it

public class BusinessLogicCore {

    private MenuModule menuModule;
    private BranchesModule branchesModule;
    private BrandsModule brandsModule;

    public BusinessLogicCore() throws Exception{
        menuModule = new MenuModuleImpl();
        branchesModule = new BranchesModuleImpl();
        brandsModule = new BrandsModuleImpl();
        
        String filename = "storejava\\dal\\hibernate\\hibernate.cfg.xml";
        HibernateDBManager.setDbConfigFilename(filename);
        HibernateDBManager.buildSessionFactory();
    }

    public Categories addCategory(Categories category) throws Exception {
        return menuModule.addCategory(category);
    }

    public Categories editCategory(Categories category) throws Exception {
        return menuModule.editCategory(category);
    }

    public void deleteCategory(Categories category) throws Exception {
        menuModule.deleteCategory(category);
    }

    public List<Categories> findAllCategories() throws Exception {
        return menuModule.findAllCategories();
    }

    public Categories findCategory(Categories category) throws Exception {
        return menuModule.findCategory(category);
    }

    public Products addProduct(Products product) throws Exception {
        return menuModule.addProduct(product);
    }

    public Products editProduct(Products product) throws Exception {
        return menuModule.editProduct(product);
    }

    public void deleteProduct(Products product) throws Exception {
        menuModule.deleteProduct(product);
    }

    public List<Products> findAllProducts() throws Exception {
        return menuModule.findAllProducts();
    }

    public Products findProduct(Products product) throws Exception {
        return menuModule.findProduct(product);
    }

    public Branches addBranch(Branches branch) throws Exception {
        return branchesModule.addBranch(branch);
    }

    public Branches editBranch(Branches branch) throws Exception {
        return branchesModule.editBranch(branch);
    }

    public void deleteBranch(Branches branch) throws Exception {
        branchesModule.deleteBranch(branch);
    }

    public Branches getBranch(Branches branch) throws Exception {
        return branchesModule.getBranch(branch);
    }

    public List<Branches> getAllBranches() throws Exception {
        return branchesModule.getAllBranches();
    }

    public Sizes addSize(Sizes size) {
        return brandsModule.addSize(size);
    }

    public Sizes editSize(Sizes size) {
        return brandsModule.editSize(size);
    }

    public void deleteSize(Sizes size) {
        brandsModule.deleteSize(size);
    }

    public List<Sizes> findAllSizes() {
        return brandsModule.findAllSizes();
    }

    public Sizes findSize(Sizes size) {
        return brandsModule.findSize(size);
    }

    public Brands addBrand(Brands brand) {
        return brandsModule.addBrand(brand);
    }

    public Brands editBrand(Brands brand) {
        return brandsModule.editBrand(brand);
    }

    public void deleteBrand(Brands brand) {
        brandsModule.deleteBrand(brand);
    }

    public List<Brands> findAllBrands() {
        return brandsModule.findAllBrands();
    }

    public Brands findBrand(Brands brand) {
        return brandsModule.findBrand(brand);
    }

    
}
