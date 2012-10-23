    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web.converters;

import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.web.GardenController;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author bsmith
 */
//                        <f:converter converterId="GardenConverter"/>
@FacesConverter(forClass=Garden.class)//GardenConverter")
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

//        Application a = context.getApplication();
//        ELResolver b = a.getELResolver();
//        ELContext z = context.getELContext();
//
//        System.out.println("  Application:" + a);
//        System.out.println("  ELResolver:" + b);
//        System.out.println("  ELContext:" + z);
//        Iterator<FeatureDescriptor> i = b.getFeatureDescriptors(z, b);
//        System.out.println("  Iterate over all of context feature descriptors");
//        while (i.hasNext()) {
//            FeatureDescriptor fd = i.next();
//            System.out.println("    fd:"+fd.toString());
//        }
//        GardenController controller = (GardenController) b.getValue(z, null, "gardenController");
//        ServletContext s = ((ServletContext) context.getExternalContext().getContext());
//        Enumeration<String> attrs = s.getAttributeNames();
//        System.out.println("  Iterate over all of ServletContext attributes");
//        while (attrs.hasMoreElements()) {
//            System.out.println("    - "+attrs.nextElement());
//        }
        GardenController controller = getFacade(context);
        
        System.out.println("  Object:"+controller);

//        GardenController controller = (GardenController) context.getApplication().getELResolver().
//                getValue(context.getELContext(), null, "gardenController");
        Garden g = (Garden) controller.getService().find(Garden.class, value);//getCrudService().find(Garden.class, value);
        System.out.println("  return: "+g);
        return null;
    }

    public BeanManager getBeanManager(FacesContext facesContext)
    {
//        return (BeanManager) 
//              ((ServletContext) facesContext.getExternalContext().getContext())
//                   .getAttribute("javax.enterprise.inject.spi.BeanManager"); 
        try{
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            System.out.println("ERROR - Couldn't get BeanManager through JNDI");
            return null;
        }
    }
    
    public GardenController getFacade(FacesContext facesContext)
    {
        BeanManager bm = getBeanManager(facesContext);
        Bean<GardenController> bean = (Bean<GardenController>) bm.getBeans(GardenController.class).iterator().next();
        CreationalContext<GardenController> ctx = bm.createCreationalContext(bean);
        GardenController dao = (GardenController) bm.getReference(bean, GardenController.class, ctx); // this could be inlined, but intentionally left this way
        return dao;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Garden g = (Garden) value;
        System.out.println("-> GardenConverter / getAsString - object:" + g + ", id:" + g.getId());
        return g.getId().toString();
    }
}
