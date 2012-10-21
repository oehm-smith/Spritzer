/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.domain.Programme;
import com.tintuna.spritzer.exception.ValidationException;
import com.tintuna.spritzer.util.Loggable;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author bsmith
 */
@Stateless
@Loggable
public class GardenService extends AbstractService<Garden> implements Serializable {

//    public List<Garden> findAll() {
//        List<Garden> list = crud.findWithNamedQuery("Garden.FIND_ALL");
//        return list;
//    }
}
