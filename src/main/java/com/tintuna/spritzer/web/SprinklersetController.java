/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.crud.QueryParameter;
import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.service.SprinklerSetService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class SprinklersetController extends Controller implements Serializable {

    private Sprinklerset selected;
    @Inject private SprinklerSetService sprinklerSetService;
    @Inject private GardenController gardenController;

    public Object getSprinklerSet() {    // List<SelectItem>
        System.out.println("-> getSprinklerSet()");
        if (gardenController.getSelected() == null) {
            return null;
        }
        List<Sprinklerset> sprinklerSetList = sprinklerSetService.findWithNamedQuery("Sprinklerset.findByGarden", QueryParameter.with("gardenId", gardenController.getSelected()));
        System.out.println("SprinklerSet - " + sprinklerSetList);
        List<SelectItem> sprinklerSetSList = new ArrayList<SelectItem>();
        for (Sprinklerset g : sprinklerSetList) {
            sprinklerSetSList.add(new SelectItem(g));
        }
        return sprinklerSetSList;
    }

    public Sprinklerset getSelected() {
        return selected;
    }

    public void setSelected(Sprinklerset garden) {
        selected = garden;
    }

    public void selectedChanged(ValueChangeEvent event) {
        Sprinklerset newValue = (Sprinklerset) event.getNewValue();
        Sprinklerset oldValue = (Sprinklerset) event.getOldValue();
        //setSelected(newValue);
        System.out.println("-> SprinklersetController - selectedChanged - OldValue: " + oldValue + ", NewValue:" + newValue);
    }

    public void selectedChangedAjax(AjaxBehaviorEvent e) {
        UIInput input = (UIInput) e.getComponent();
//        String contentId = input.getId().substring("inputfield".length());
//        Object contentValue = (Object) input.getValue();
//        String value = (String) contentValue;
        System.out.println("SprinklersetController - selectedChanged - string:" + e.toString() + "," + input.getId() + "=> NUTIN");// + contentValue);

        //setSelected((Garden) e.getNewValue());
    }
}
