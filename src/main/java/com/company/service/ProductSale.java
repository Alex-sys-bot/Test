package com.company.service;

import com.company.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ProductSale implements Dao<ProductSale,Integer> {

    private final SessionFactory factory;

    public ProductSale(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void insert(ProductSale productSale) {

    }

    @Override
    public void update(ProductSale productSale) {

    }

    @Override
    public void delete(ProductSale productSale) {

    }

    @Override
    public List<ProductSale> returnAll() {
        try (Session session = factory.openSession()){
            Query<ProductSale> query = session.createQuery("from ProductSale");
            return query.list();
        }
    }

    @Override
    public ProductSale returnById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(ProductSale.class,id);
        }
    }
}
