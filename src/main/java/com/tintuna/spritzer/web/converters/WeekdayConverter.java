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
package com.tintuna.spritzer.web.converters;

import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.domain.Weekday;
import com.tintuna.spritzer.web.GardenController;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
@Named
@RequestScoped
public class WeekdayConverter extends AbstractConverter<Weekday, GardenController> {

    // TODO - Don't actually use this as Weekday doesn't have a controller.  Not that good and will fix later.
    @Inject
    public void setController(GardenController controller) {
        this.controller = controller;
    }

    @Inject
    public void setEntity(Weekday entity) {
        this.entity = entity;
    }
    
    @Override
    protected String getEntitySpecificConverterString(Weekday entity, Integer id) {
        return entity.getDayName();
    }

}
