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
import com.tintuna.spritzer.domain.Sprinkler;
import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.domain.Weekday;
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
public class WeekdayService extends AbstractService<Weekday> implements Serializable {
//    public List<Weekday> findAll() {
//        List<Weekday> list = crud.findWithNamedQuery("Weekday.FIND_ALL");
//        return list;
//    }
}
