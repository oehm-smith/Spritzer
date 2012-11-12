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

import com.tintuna.spritzer.domain.Programme;
import com.tintuna.spritzer.service.ProgrammeService;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
public class ProgrammeController extends Controller<ProgrammeService> implements Serializable {

    @Inject
    private transient Logger logger;
    private Programme selected;
    
    @Inject
    private ScheduleController scheduleController;

    @Override
    @Inject
    public void setService(ProgrammeService service) {
        this.service = service;
    }

    public DataModel<Programme> getProgrammes() {    // List<SelectItem>, Object
        List<Programme> programmeList = getService().findAll();
        logger.finer("-> getProgrammes() - " + programmeList);
        return new ListDataModel<Programme>(programmeList);
    }

    public DataModel<Programme> getProgrammesFromSchedule() { 
        if (scheduleController.getSelected() == null || scheduleController.getSelected().getProgrammesCollection() == null) {
            return null;
        }
        List<Programme> programmeList = Collections.list(Collections.enumeration(scheduleController.getSelected().getProgrammesCollection()));
        logger.finer("-> programmesFromSchedule() - " + programmeList);
        return new ListDataModel<Programme>(programmeList);        
    }
    
    public Programme getSelected() {
        return selected;
    }

    public void setSelected(Programme programme) {
        selected = programme;
    }

    public String add() {
        //addInformationMessage("NoButonYet", null);
        selected = new Programme();
        return "/view/schedule/Create";
    }

    public String list() {
        return "/view/schedule/List";
    }

    public String create() {
        getService().create(getSelected());
        FacesContext context = FacesContext.getCurrentInstance();  
          
        context.addMessage(null, new FacesMessage("New programme '"+selected+"' created "));  
        return list()+"?faces-redirect=true";
    }
}
