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
import com.tintuna.spritzer.web.GardenController;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
//                        <f:converter converterId="GardenConverter"/>
//@FacesConverter(forClass = Garden.class)
/*
 * I couldn't make this a @FacesConverter as I want to @Inject the logger.
 * Thus require it to be a ManagedBean though chose a CDI Bean (MBs are managed by JSF, whereas CDI bean managed 
 * by Application Server.
 * 
 * If I'd made it a @FacesConverter I could have used the value of '(forClass = Garden.class)' so it is automagically
 * wired to Convert for that class.  Now I need to explicitly include in the JSF element (eg. '<h:selectOneMenu ..>')
 * the 'converter' attribute or '<f:converter ..>' element.
 * 
 * JSF 2.2 will make FacesConverters CDI Managed objects and I wouldn't have to do any of this.
 */
@Named
@RequestScoped
public class GardenConverter extends AbstractConverter<Garden, GardenController> {

    public GardenConverter() {
        super(Garden.class, GardenController.class);
    }
}
