/* 
 * Copyright (c) Tintuna Software (2012).
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
