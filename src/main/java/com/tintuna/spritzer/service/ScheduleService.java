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

import com.tintuna.spritzer.domain.Schedule;
import com.tintuna.spritzer.util.Loggable;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author bsmith
 */
@Stateless
@Loggable
public class ScheduleService extends AbstractService<Schedule> implements Serializable {
//    public List<Schedule> findAll() {
//        List<Schedule> list = crud.findWithNamedQuery("Schedule.FIND_ALL");
//        return list;
//    }

}
