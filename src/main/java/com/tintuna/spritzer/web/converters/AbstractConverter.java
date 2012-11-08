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

import com.tintuna.spritzer.domain.BaseEntity;
import com.tintuna.spritzer.web.Controller;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author bsmith
 */
public abstract class AbstractConverter<T_Entity extends BaseEntity, T_Controller extends Controller> implements Converter, Serializable {
    // Can't @Inject into Converters (but will in JSF 2.2) - see http://stackoverflow.com/questions/3630403/how-do-i-access-ejb-bean-when-inside-a-custom-converter

    @Inject
    protected transient Logger logger;
    /**
     * Set by @Injecting in subclass - see methods setController(T_Controller controller) and setEntity(T_Entity entity)
     * Relates to Generic BaseEntity parameter
     */
    protected Controller controller;
     /**
     * Set by @Injecting in subclass - see methods setController(T_Controller controller) and setEntity(T_Entity entity).
     * Relates to Generic Controller parameter
     */
    protected BaseEntity entity;

    public AbstractConverter() {
    }

    /**
     * Force a check that the required Entity and Controller were injected.
     */
    @PostConstruct
    private void validate() {
        if (controller == null) {
            throw new IllegalArgumentException("Required property controller not set - subclass should have it Inject'ed");
        }
        if (entity == null) {
            throw new IllegalArgumentException("Required property entity not set - subclass should have it Inject'ed");
        }
    }
    /**
     * The subclass needs to set the Controller it uses (eg. GardenController for Garden entity).  It can @Inject it like:
     * @Inject public void setController(GardenController controller) {this.controller = controller}
     * This causes the specified Controller to be @Injected.
     * @param controller is the subclass of Controller to set.
     */
    protected abstract void setController(T_Controller controller);

   /**
     * The subclass needs to set the BaseEntity it uses (eg. Garden entity).  It can @Inject it like:
     * @Inject public void setEntity(GardenEntity controller) {this.controller = controller}
     * This causes the specified Controller to be @Injected.
     * @param controller is the subclass of Controller to set.
     */
    protected abstract void setEntity(T_Entity entity);
    
    /**
     * Give entities a chance to return specific information about itself instead of just an Id.  Such as the name.
     * @param id
     * @return 
     */
    protected String getEntitySpecificConverterString(T_Entity entity, Integer id) {
        return id.toString();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().length() == 0) {
            return null;
        }

        T_Entity g = (T_Entity) controller.getService().find(entity.getClass(), value);//entityClass
        logger.finer("-> " + this.getClass().getSimpleName() + " / getAsObject - return: " + g);
        return g;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        logger.finer("-> " + this.getClass().getSimpleName() + " / getAsString - value:" + value);
        T_Entity g = null;
        if (value instanceof BaseEntity) {  // Can't use T_Entity here
            g = (T_Entity) value;
        } else {
            Map.Entry<T_Entity, String> entry = (Map.Entry<T_Entity, String>) value;
            g = (T_Entity) entry.getKey();
        }
        if (g == null) {
            return "";
        }
        logger.finer("-> " + this.getClass().getName() + " / getAsString - object:" + g + ", id:" + g.getId());
        return getEntitySpecificConverterString(g, g.getId());
    }
}
