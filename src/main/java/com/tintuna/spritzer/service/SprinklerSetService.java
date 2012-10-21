/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.domain.Programme;
import com.tintuna.spritzer.domain.Sprinklerset;
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
public class SprinklerSetService extends AbstractService<Sprinklerset> implements Serializable {

//    public List<Sprinklerset> findAll() {
//        List<Sprinklerset> list = crud.findWithNamedQuery("Sprinklersets.FIND_ALL");
//        return list;
//    }
}
