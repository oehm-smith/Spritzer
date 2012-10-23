/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.service.AbstractService;
import com.tintuna.spritzer.service.GardenService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
@Named
public class GardenController extends Controller implements Serializable {

    private Garden selected;
    @Inject private GardenService gardenService;

    public AbstractService getService() {
        return gardenService;
    }

    public Object getGardens() {    // List<SelectItem>
        List<Garden> gardenList = gardenService.findAll();
        List<SelectItem> gardenSList = new ArrayList<SelectItem>();
        System.out.println("-> getGardens() - " + gardenList);
        for (Garden g : gardenList) {
            gardenSList.add(new SelectItem(g));
        }
        return gardenSList;
    }

    public Garden getSelected() {
        System.out.println("Garden / getSelected");
        return selected;
    }

    public void setSelected(Garden garden) {
        System.out.println("Garden / setSelected");
        selected = garden;
    }

    public void selectedChanged(AjaxBehaviorEvent e) {
        UIInput input = (UIInput) e.getComponent();
        String contentId = input.getId().substring("inputfield".length());
        Object contentValue = (Object) input.getValue();
//        String value = (String) contentValue;
        System.out.println("selectedChanged - string:" + e.toString() + ","+input.getId()+"=>"+contentValue);

        //setSelected((Garden) e.getNewValue());
    }
}
