    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web.converters;

import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.web.GardenController;
import java.util.Map.Entry;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author bsmith
 */
//                        <f:converter converterId="GardenConverter"/>
@FacesConverter("GardenConverter") //forClass=Garden.class)//
public class GardenConverter implements Converter {

    //@Inject GardenController controller;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().length() == 0) {
            return null;
        }
        System.out.println("-> GardenConverter / getAsObject - value:" + value);
//            GardenServiceFacade controller = (GardenServiceFacade) facesContext.getApplication().getELResolver().
//                    getValue(facesContext.getELContext(), null, "gardenController");

        GardenController controller = getFacade(context);

        System.out.println("  Object:" + controller);

//        GardenController controller = (GardenController) context.getApplication().getELResolver().
//                getValue(context.getELContext(), null, "gardenController");
        Garden g = (Garden) controller.getService().find(Garden.class, value);//getCrudService().find(Garden.class, value);
        System.out.println("  return: " + g);
        return g;
    }

    public BeanManager getBeanManager(FacesContext facesContext) {
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

    public GardenController getFacade(FacesContext facesContext) {
        BeanManager bm = getBeanManager(facesContext);
        Bean<GardenController> bean = (Bean<GardenController>) bm.getBeans(GardenController.class).iterator().next();
        CreationalContext<GardenController> ctx = bm.createCreationalContext(bean);
        GardenController dao = (GardenController) bm.getReference(bean, GardenController.class, ctx); // this could be inlined, but intentionally left this way
        return dao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("-> GardenConverter / getAsString - value:" + value);
        Garden g = null;
        if (value instanceof Garden) {
            System.out.println("-> GardenConverter / getAsString - its a Garden.");
            g = (Garden) value;
        } else {
            System.out.println("-> GardenConverter / getAsString - its an entry.");
            Entry<Garden, String> entry = (Entry<Garden, String>) value;
            g = (Garden) entry.getKey();
        }
        if (g == null) {
            return "";
        }
        System.out.println("-> GardenConverter / getAsString - object:" + g + ", id:" + g.getId());
        return g.getId().toString();
    }
}
