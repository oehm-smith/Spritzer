/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web.converters;

import com.tintuna.spritzer.domain.Schedule;
import com.tintuna.spritzer.domain.Sprinkler;
import com.tintuna.spritzer.web.ScheduleController;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bsmith
 */
@FacesConverter(forClass=Sprinkler.class)
public class ScheduleConverter extends AbstractConverter<Schedule, ScheduleController> {

    public ScheduleConverter() {
        super(Schedule.class, ScheduleController.class);
    }
}