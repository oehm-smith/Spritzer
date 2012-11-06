/**
 * This file is part of Spritzer.
 *
 * Spritzer is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Spritzer is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Spritzer. If not, see http://www.gnu.org/licenses/.
 *
 * Copyright 2012 Brooke Smith, tintuna.com.
 *
 */
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.domain.Schedule;
import com.tintuna.spritzer.service.ScheduleService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
@Named
@SessionScoped
public class ScheduleController extends Controller<ScheduleService> implements Serializable {

    @Inject
    private transient Logger logger;
    private Schedule selected;

    @Override
    @Inject
    public void setService(ScheduleService service) {
        this.service = service;
    }

    public DataModel<Schedule> getSchedules() {    // List<SelectItem>, Object
        List<Schedule> scheduleList = getService().findAll();
        logger.fine("-> getSchedules() - " + scheduleList);
        return new ListDataModel<Schedule>(scheduleList);
    }

    public Schedule getSelected() {
        return selected;
    }

    public void setSelected(Schedule schedule) {
        selected = schedule;
    }

    public String add() {
        //addInformationMessage("NoButonYet", null);
        selected = new Schedule();
        return "/view/schedule/Create";
    }

    public String list() {
        return "/view/schedule/List";
    }

    public String create() {
        getService().create(getSelected());
        return list();
    }
}
