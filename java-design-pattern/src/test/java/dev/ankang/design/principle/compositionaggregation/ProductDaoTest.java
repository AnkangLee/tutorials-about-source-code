package dev.ankang.design.principle.compositionaggregation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDaoTest {

    @Test
    public void addProduct() {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new OracleConnection());
        productDao.addProduct();
    }
}