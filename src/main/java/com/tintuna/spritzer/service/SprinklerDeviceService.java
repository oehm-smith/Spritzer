/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.domain.Sprinkler;
import com.tintuna.spritzer.domain.Sprinklerdevice;
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
public class SprinklerDeviceService extends AbstractService<Sprinklerdevice> implements Serializable {
 
//    public List<Sprinklerdevice> findAll() {
//        List<Sprinklerdevice> list = crud.findWithNamedQuery("Sprinklerdevice.FIND_ALL");
//        return list;
//    }

}
