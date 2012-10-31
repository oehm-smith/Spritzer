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
package com.tintuna.spritzer.web.converters;

import com.tintuna.spritzer.web.Controller;
import com.tintuna.spritzer.domain.BaseEntity;
import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.web.GardenController;
import java.util.Map;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author bsmith
 */
public abstract class AbstractConverter<T_Entity extends BaseEntity, T_Controller extends Controller> implements Converter {

    Class<T_Entity> entityClass;
    Class<T_Controller> controllerClass;

    protected AbstractConverter(Class<T_Entity> entityClass, Class<T_Controller> controllerClass) {
        this.entityClass = entityClass;
        this.controllerClass = controllerClass;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().length() == 0) {
            return null;
        }
        System.out.println("-> "+this.getClass().getSimpleName() + " / getAsObject - value:" + value);
//            GardenServiceFacade controller = (GardenServiceFacade) facesContext.getApplication().getELResolver().
//                    getValue(facesContext.getELContext(), null, "gardenController");

        T_Controller controller = getFacade(context);

        System.out.println("  Object:" + controller);

//        GardenController controller = (GardenController) context.getApplication().getELResolver().
//                getValue(context.getELContext(), null, "gardenController");
        T_Entity g = (T_Entity) controller.getService().find(entityClass, value);//getCrudService().find(Garden.class, value);
        System.out.println("  return: " + g);
        return g;
    }

    private BeanManager getBeanManager(FacesContext facesContext) {
        BeanManager bm = null;
        bm = (BeanManager) ((ServletContext) facesContext.getExternalContext().getContext())
                .getAttribute("javax.enterprise.inject.spi.BeanManager");
        if (bm != null) {
            return bm;
        }
        try {
            InitialContext initialContext = new InitialContext();
            bm = (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            System.out.println("ERROR - Couldn't get BeanManager through JNDI");
            return null;
        }
        return bm;
    }

    private T_Controller getFacade(FacesContext facesContext) {
        BeanManager bm = getBeanManager(facesContext);
        Bean<GardenController> bean = (Bean<GardenController>) bm.getBeans(GardenController.class).iterator().next();
        CreationalContext<GardenController> ctx = bm.createCreationalContext(bean);
        T_Controller dao = (T_Controller) bm.getReference(bean, controllerClass, ctx); // this could be inlined, but intentionally left this way
        return dao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        System.out.println("-> "+this.getClass().getSimpleName()+" / getAsString - value:" + value);
        T_Entity g = null;
        if (value instanceof BaseEntity) {  // Can't use T_Entity here
//            System.out.println("-> "+this.getClass().getSimpleName()+" / getAsString - its a T_Entity.");
            g = (T_Entity) value;
        } else {
//            System.out.println("-> "+this.getClass().getSimpleName()+" / getAsString - its an entry.");
            Map.Entry<T_Entity, String> entry = (Map.Entry<T_Entity, String>) value;
            g = (T_Entity) entry.getKey();
        }
        if (g == null) {
            return "";
        }
        System.out.println("-> "+this.getClass().getName()+" / getAsString - object:" + g + ", id:" + g.getId());
        return g.getId().toString();
    }
}
