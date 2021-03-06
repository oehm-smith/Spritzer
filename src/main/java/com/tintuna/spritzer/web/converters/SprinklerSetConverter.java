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

import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.web.SprinklersetController;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
//@FacesConverter(forClass=Sprinklerset.class) - see GardenConverter
@Named
@RequestScoped
public class SprinklerSetConverter extends AbstractConverter<Sprinklerset, SprinklersetController> {

    @Inject
    public void setController(SprinklersetController controller) {
        this.controller = controller;
    }
    
    @Inject
    public void setEntity(Sprinklerset entity) {
        this.entity = entity;
    }
}
