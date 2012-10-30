/**
* This file is part of Spritzer.
 
Spritzer is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
 
Spritzer is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
 
You should have received a copy of the GNU General Public License
along with Spritzer.  If not, see http://www.gnu.org/licenses/.
 
* Copyright 2012 Brooke Smith, tintuna.com.
**/
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.crud.QueryParameter;
import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.exception.ValidationException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bsmith
 */
public class AbstractService<T> {

    @Inject protected CrudService crud;

    /**
     * Pass-through to allow service users to call crud operations directly - such as all the find*() methods
     * @return 
     */
    private CrudService getCrudService() {
        return crud;
    }
    
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

    public <T> T find(Class<T> type,String id) {
        String s = id.replaceAll("\"", "");
        Integer i = Integer.parseInt(s);
        return (T) getCrudService().find(type, i);
    }
    
    public List findWithNamedQuery(String namedQueryName, QueryParameter parameters){
        return crud.findWithNamedQuery(namedQueryName, parameters);
    }
}
