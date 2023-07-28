package com.myprojects.storejava.bll;

import java.util.List;
import storejava.dal.hibernate.entity.Brands;
import storejava.dal.hibernate.entity.Sizes;

public interface BrandsModule {

    Sizes addSize(Sizes size);

    Sizes editSize(Sizes size);

    void deleteSize(Sizes size);

    List<Sizes> findAllSizes();

    Sizes findSize(Sizes size);

    Brands addBrand(Brands brand);

    Brands editBrand(Brands brand);

    void deleteBrand(Brands brand);

    List<Brands> findAllBrands();

    Brands findBrand(Brands brand);
}
