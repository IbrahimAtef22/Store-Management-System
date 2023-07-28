package com.myprojects.storejava.bll;

import java.util.List;
import storejava.dal.hibernate.entity.Categories;
import storejava.dal.hibernate.entity.Products;

/**
 *
 * @author Ibrahim22
 */
public interface MenuModule {

    Categories addCategory(Categories category);

    Categories editCategory(Categories category);

    void deleteCategory(Categories category);

    List<Categories> findAllCategories();

    Categories findCategory(Categories category);

    Products addProduct(Products product);

    Products editProduct(Products product);

    void deleteProduct(Products product);

    List<Products> findAllProducts();

    Products findProduct(Products product);

}
