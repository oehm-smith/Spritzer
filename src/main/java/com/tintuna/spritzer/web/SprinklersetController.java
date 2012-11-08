/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.crud.QueryParameter;
import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.service.SprinklerSetService;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
@Named
@SessionScoped
public class SprinklersetController extends Controller<SprinklerSetService> implements Serializable {

//    @Inject
//    private transient Logger logger;
    private Sprinklerset selected;
    @Inject
    private GardenController gardenController;

    @Override
    @Inject
    public void setService(SprinklerSetService service) {
        this.service = service;
    }

    public Object getSprinklerSet() {    // List<SelectItem>
        List<Sprinklerset> sprinklersetList = getService().findWithNamedQuery("SprinklerSet.findByGarden", QueryParameter.with("gardenId", gardenController.getSelected()));
        logger.finer("-> getSprinklersets() - " + sprinklersetList);
        Map<Sprinklerset, String> sprinklersetsMap = new LinkedHashMap<Sprinklerset, String>();
        //sprinklersetsMap.put(null, "-- select one --");
        for (Sprinklerset g : sprinklersetList) {
            sprinklersetsMap.put(g, g.getName());
        }
        return sprinklersetsMap;
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
        logger.finer("-> SprinklersetController - selectedChanged - OldValue: " + oldValue + ", NewValue:" + newValue);
    }

    public void selectedChangedAjax(AjaxBehaviorEvent e) {
        UIInput input = (UIInput) e.getComponent();
//        String contentId = input.getId().substring("inputfield".length());
//        Object contentValue = (Object) input.getValue();
//        String value = (String) contentValue;
        logger.finer("SprinklersetController - selectedChanged - string:" + e.toString() + "," + input.getId() + "=> NUTIN");// + contentValue);

        //setSelected((Garden) e.getNewValue());
    }
}
