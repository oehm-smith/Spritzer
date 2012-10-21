/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.domain.Programme;
import com.tintuna.spritzer.domain.Schedule;
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
public class ProgrammeService extends AbstractService<Programme> implements Serializable {
//    public List<Programme> findAll() {
//        List<Programme> list = crud.findWithNamedQuery("Programmes.FIND_ALL");
//        return list;
//    }

}
