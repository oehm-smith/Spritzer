/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web.converters;

import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.web.SprinklersetController;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bsmith
 */
@FacesConverter(forClass=Sprinklerset.class)
public class SprinklerSetConverter extends AbstractConverter<Sprinklerset, SprinklersetController> {

    public SprinklerSetConverter() {
        super(Sprinklerset.class, SprinklersetController.class);
    }
}