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
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.domain.Schedule;
import com.tintuna.spritzer.service.ScheduleService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
@Named
public class ScheduleController extends Controller implements Serializable {

    private Schedule selected;
    @Inject private ScheduleService scheduleService;

    public Object getGardens() {    // List<SelectItem>
        List<Garden> gardenList = scheduleService.findAll();
        List<SelectItem> gardenSList = new ArrayList<SelectItem>();
        for (Garden g : gardenList) {
            gardenSList.add(new SelectItem(g));
        }
        return gardenSList;
    }

    public Schedule getSelected() {
        return selected;
    }

    public void setSelected(Schedule schedule) {
        selected = schedule;
    }
}

