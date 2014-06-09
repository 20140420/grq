package com.grq.model.dao.product;

import org.springframework.stereotype.Repository;

import com.grq.model.dao.DaoSupport;
import com.grq.model.pojo.product.ProductCategory;

@Repository("productCategoryDao")
public class ProductCategoryDaoImpl extends DaoSupport<ProductCategory> implements ProductCategoryDao {

}
