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
@FacesConverter(forClass=Garden.class)
public class GardenConverter extends AbstractConverter<Garden, GardenController> {

    public GardenConverter() {
        super(Garden.class, GardenController.class);
    }
}
