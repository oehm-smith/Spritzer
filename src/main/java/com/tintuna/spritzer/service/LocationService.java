/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.service;

import com.tintuna.spritzer.crud.CrudService;
import com.tintuna.spritzer.domain.Location;
import com.tintuna.spritzer.domain.Sprinkler;
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
public class LocationService extends AbstractService<Location> implements Serializable {
 
//    public List<Location> findAll() {
//        List<Location> list = crud.findWithNamedQuery("Locations.FIND_ALL");
//        return list;
//    }

}
