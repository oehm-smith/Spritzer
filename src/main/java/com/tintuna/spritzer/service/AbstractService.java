/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.exception.ValidationException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bsmith
 */
class AbstractService<T> {

    @Inject protected CrudService crud;

    public <T> T create(final T item) {
        if (item == null) {
            throw new ValidationException("AbstractService<T> / create() - object is null.");
        }
        crud.create(item);

        return item;
    }

    public <T> T update(final T item) {
        if (item == null) {
            throw new ValidationException("AbstractService<T> / update() - object is null.");
        }
        crud.update(item);

        return item;
    }

    public <T> void delete(final T item) {
        if (item == null) {
            throw new ValidationException("AbstractService<T> / delete() - object is null.");
        }
        crud.delete(item);
    }

    public <T> List<T> findAll() {
        // Expect all Entity classes to have namedQueries and inparticular "<entity class name>.FIND_ALL"
        String namedQueryString = this.getClass().getName().replace("Service","").replace("com.tintuna.spritzer.service.","") + ".findAll";
        List<T> list = crud.findWithNamedQuery(namedQueryString);
        return list;
    }
}
