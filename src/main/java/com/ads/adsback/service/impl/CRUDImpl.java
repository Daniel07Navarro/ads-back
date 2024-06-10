package com.ads.adsback.service.impl;

import com.ads.adsback.repository.IGenericRepository;
import com.ads.adsback.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    abstract IGenericRepository<T,ID> getRepo();

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void deleteById(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
