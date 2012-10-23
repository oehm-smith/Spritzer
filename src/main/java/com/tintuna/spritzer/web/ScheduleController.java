/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

