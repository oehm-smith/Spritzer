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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
@Named
@SessionScoped
public class GardenController extends Controller implements Serializable {

    private Garden selected;
    //@Inject private GardenService gardenService;

    // TODO - There should be a more automagic way of doing this such as with @Produces and @SomeQualifier
    //@PostConstruct
    @Inject
    public void setService(GardenService gardenService) {
        super.setService(gardenService);
    }

    public Object getGardens() {    // List<SelectItem>
        List<Garden> gardenList = getService().findAll();
        List<SelectItem> gardenSList = new ArrayList<SelectItem>();
        System.out.println("-> getGardens() - " + gardenList);
        Map<Garden, String> gardensMap = new LinkedHashMap<Garden, String>();
        gardensMap.put(null, "-- select one --");
        for (Garden g : gardenList) {
            gardensMap.put(g, g.getName());
        }
        System.out.println("-> getGardens() - the selected is - " + selected);
        return gardensMap;
    }

    public Garden getSelected() {
        System.out.println("GardenController / getSelected - " + selected);
        return selected;
    }

    public void setSelected(Garden garden) {
        selected = garden;
        System.out.println("GardenController / setSelected - " + selected);
    }

    public void selectedChanged(ValueChangeEvent event) {
        Garden newValue = (Garden) event.getNewValue();
        Garden oldValue = (Garden) event.getOldValue();
        //setSelected(newValue);
        System.out.println("-> selectedChanged - OldValue: " + oldValue + ", NewValue:" + newValue);
    }

    public void selectedChangedAjax(AjaxBehaviorEvent e) {
        UIInput input = (UIInput) e.getComponent();
//        String contentId = input.getId().substring("inputfield".length());
//        Object contentValue = (Object) input.getValue();
//        String value = (String) contentValue;
        System.out.println("selectedChanged - string:" + e.toString() + "," + input.getId() + "=> NUTIN");// + contentValue);

        //setSelected((Garden) e.getNewValue());
    }
}
