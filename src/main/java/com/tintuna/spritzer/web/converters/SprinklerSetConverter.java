/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web.converters;

import com.tintuna.spritzer.web.SprinklersetController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bsmith
 */
@FacesConverter("SprinklerSetConverter")
public class SprinklerSetConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        SprinklersetController controller = (SprinklersetController) context.getApplication().getELResolver().
                getValue(context.getELContext(), null, "sprinklersetController");
        System.out.println("-> SprinklerSetConverter / getAsObject - value:"+value);
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("-> SprinklerSetConverter / getAsString - object:"+value);
        return "SprinklerSetConverter";
    }
}
