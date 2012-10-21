/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.domain.Sprinkler;
import com.tintuna.spritzer.domain.Sprinklertype;
import com.tintuna.spritzer.exception.ValidationException;
import com.tintuna.spritzer.util.Loggable;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author bsmith
 */
@Stateless
@Loggable
public class SprinklerTypeService extends AbstractService<Sprinklertype> implements Serializable {
//      public List<Sprinklertype> findAll() {
//        List<Sprinklertype> list = crud.findWithNamedQuery("Sprinklertype.FIND_ALL");
//        return list;
//    }

}
