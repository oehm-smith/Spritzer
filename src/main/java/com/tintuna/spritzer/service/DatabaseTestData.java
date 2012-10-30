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
import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.domain.Location;
import com.tintuna.spritzer.domain.Programme;
import com.tintuna.spritzer.domain.Schedule;
import com.tintuna.spritzer.domain.Sprinklerdevice;
import com.tintuna.spritzer.domain.Sprinkler;
import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.domain.Sprinklertype;
import com.tintuna.spritzer.domain.Weekday;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author bsmith
 */
/* 
 select * from run; 
 select * from customer; 
 select * from garden; 
 select * from locations; 
 select * from programmes; 
 select * from programmes_to_sprinklers; 
 select * from schedule; 
 select * from schedule_to_programmes; 
 select * from sprinklerdevice; 
 select * from sprinklers; 
 select * from sprinklersets; 
 select * from sprinklertype;
 */
public class DatabaseTestData implements Serializable {

    @Inject private CrudService crudService;
    @Inject private GardenService gardenService;
    @Inject private SprinklerSetService sprinklerSetService;
    @Inject private LocationService locationService;
    @Inject private SprinklerDeviceService sprinklerDeviceService;
    @Inject private SprinklerTypeService sprinklerTypeService;
    @Inject private ProgrammeService programmeService;
    @Inject private ScheduleService scheduleService;
    @Inject private SprinklerService sprinklerService;
    @Inject private WeekdayService weekdayService;
    private Garden garden1;
    private Garden garden2;
    private Map<Days, Weekday> weekMap = new HashMap<Days, Weekday>();
    private Sprinklerset sprinklerset1;
    private Sprinklerset sprinklerset2;
    private Location location1;
    private Location location2;
    private Sprinklertype sprinklerType1;
    private Sprinklertype sprinklerType2;
    private Sprinklerdevice sprinklerDevice1;
    private Sprinklerdevice sprinklerDevice2;
    private Sprinkler sprinkler1;
    private Sprinkler sprinkler2;
    private Programme programme1;
    private Programme programme2;
    private Schedule schedule1;
    private Schedule schedule2;

    public void loadTestData() {
        createGardens();
        createWeekdays();
        createSprinklerSets();
        createLocations();
        createSprinklerTypes();
        createSprinklerDevices();
        createSprinklers();
        createProgrammes();
        createSchedule();
        createScheduleToProgrammes();
        createProgrammesToSprinklers();
    }

    private void createGardens() {
        garden1 = new Garden(1, "Main house Garden");
        garden2 = new Garden(2, "Holiday house Garden");
        gardenService.create(garden1);
        gardenService.create(garden2);
    }

    enum Days {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    };

    private void createWeekdays() {
//        int day = 1;
        for (Days d : Days.values()) {
            Weekday wd = new Weekday();//day++);
            wd.setDayName(d.name());
            weekMap.put(d, wd);
            weekdayService.create(wd);
        }
    }

    private void createSprinklerSets() {
        sprinklerset1 = new Sprinklerset();
        sprinklerset1.setName("Front sprinklers");
        sprinklerset1.setGardenID(garden1);
        sprinklerset2 = new Sprinklerset();
        sprinklerset2.setName("Rear sprinklers");
        sprinklerset2.setGardenID(garden1);
        sprinklerSetService.create(sprinklerset1);
        sprinklerSetService.create(sprinklerset2);
    }

    private void createLocations() {
        location1 = new Location();
        location1.setLatitude(-100.1);
        location1.setLongitude(100.7);
        location1.setDescription("Front yard / North West corner");
        location2 = new Location();
        location2.setLatitude(-102.1);
        location2.setLongitude(102.7);
        location2.setDescription("Rear yard / South East corner");
        locationService.create(location1);
        locationService.create(location2);
    }

    private void createSprinklerTypes() {
        sprinklerType1 = new Sprinklertype();
        sprinklerType1.setType("Lawn pop up");
        sprinklerType2 = new Sprinklertype();
        sprinklerType2.setType("Dripper");
        sprinklerTypeService.create(sprinklerType1);
        sprinklerTypeService.create(sprinklerType2);
    }

    private void createSprinklerDevices() {
        sprinklerDevice1 = new Sprinklerdevice();
        sprinklerDevice1.setName("Green master 3m");
        sprinklerDevice1.setModelNo("7654321");
        sprinklerDevice1.setFlowRate(15.0);
        sprinklerDevice1.setRadiusSpray(5.5);
        sprinklerDevice1.setConfigItems("radius,arc");
        sprinklerDevice1.setSprinklerTypeID(sprinklerType1);

        sprinklerDevice2 = new Sprinklerdevice();
        sprinklerDevice2.setName("Vege patch 7");
        sprinklerDevice2.setModelNo("abcd");
        sprinklerDevice2.setFlowRate(1.0);
        sprinklerDevice2.setRadiusSpray(0.0);
        sprinklerDevice2.setConfigItems("rate");
        sprinklerDevice2.setSprinklerTypeID(sprinklerType2);

        sprinklerDeviceService.create(sprinklerDevice1);
        sprinklerDeviceService.create(sprinklerDevice2);
    }

    private void createSprinklers() {
        sprinkler1 = new Sprinkler();
        sprinkler1.setName("Front lawn sprinkler");
        sprinkler1.setSprinklerDeviceID(sprinklerDevice1);
        sprinkler1.setLocationID(location1);
        sprinkler1.setConfiguration("radius=5.0,arc=360");
        sprinkler1.setSprinklerSetID(sprinklerset1);

        sprinkler2 = new Sprinkler();
        sprinkler2.setName("Rear vege garden sprinkler");
        sprinkler2.setSprinklerDeviceID(sprinklerDevice2);
        sprinkler2.setLocationID(location2);
        sprinkler2.setConfiguration("rate=0.7");
        sprinkler2.setSprinklerSetID(sprinklerset2);

        sprinklerService.create(sprinkler1);
        sprinklerService.create(sprinkler2);
    }

    private void createProgrammes() {
        programme1 = new Programme();
        programme1.setDayOfWeekID(weekMap.get(Days.SATURDAY));
        Calendar onTime = Calendar.getInstance();
        onTime.set(Calendar.HOUR, 16);
        onTime.set(Calendar.MINUTE, 00);
        programme1.setOnTime(onTime.getTime());
        programme1.setDuration(60.0);

        programme2 = new Programme();
        programme2.setDayOfWeekID(weekMap.get(Days.MONDAY));
        onTime.set(Calendar.HOUR, 23);
        onTime.set(Calendar.MINUTE, 00);
        programme2.setOnTime(onTime.getTime());
        programme2.setDuration(60.0);

        programmeService.create(programme1);
        programmeService.create(programme2);
    }

    private void createSchedule() {
        Calendar start = Calendar.getInstance();
        start.set(Calendar.YEAR, 2012);
        start.set(Calendar.MONTH, 0);
        start.set(Calendar.DAY_OF_MONTH, 1);
        Calendar end = Calendar.getInstance();
        end.set(Calendar.YEAR, 2014);
        end.set(Calendar.MONTH, 11);
        end.set(Calendar.DAY_OF_MONTH, 31);

        schedule1 = new Schedule();
        schedule1.setName("Schedule 1");
        schedule1.setStartDate(start.getTime());
        schedule1.setEndDate(end.getTime());

        schedule2 = new Schedule();
        schedule2.setName("Schedule 2");
        schedule2.setStartDate(start.getTime());
        schedule2.setEndDate(end.getTime());

        scheduleService.create(schedule1);
        scheduleService.create(schedule2);
    }

    private void createScheduleToProgrammes() {
        Collection<Programme> programmes = new ArrayList();
        programmes.add(programme1);
        programmes.add(programme2);
        Collection<Schedule> schedules = new ArrayList();
        schedules.add(schedule1);
        schedules.add(schedule2);
        schedule1.setProgrammesCollection(programmes);
        schedule1.setProgrammesCollection(programmes);
        programme1.setScheduleCollection(schedules);
        programme2.setScheduleCollection(schedules);

        programmeService.update(programme1);
        programmeService.update(programme2);

        scheduleService.update(schedule1);
        scheduleService.update(schedule2);
    }

    private void createProgrammesToSprinklers() {
        Collection<Programme> programmes = new ArrayList();
        programmes.add(programme1);
        programmes.add(programme2);
        Collection<Sprinkler> sprinklers = new ArrayList();
        sprinklers.add(sprinkler1);
        sprinklers.add(sprinkler2);
        sprinkler1.setProgrammesCollection(programmes);
        sprinkler2.setProgrammesCollection(programmes);
        programme1.setSprinklersCollection(sprinklers);
        programme2.setSprinklersCollection(sprinklers);

        sprinklerService.update(sprinkler1);
        sprinklerService.update(sprinkler2);

        programmeService.update(programme1);
        programmeService.update(programme2);
    }
}
