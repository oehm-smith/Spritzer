/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.crud.QueryParameter;
import com.tintuna.spritzer.domain.Sprinkler;
import com.tintuna.spritzer.domain.Sprinklerset;
import com.tintuna.spritzer.service.SprinklerService;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
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
public class SprinklerController extends Controller<SprinklerService> implements Serializable {

    @Inject
    private transient Logger logger;
    private Sprinkler selected;
    @Inject
    private SprinklersetController sprinklersetController;

    @Inject
    @Override
    public void setService(SprinklerService service) {
        //super.setService(service);
        this.service = service;
    }

    public Object getSprinklers() {    // List<SelectItem>
        List<Sprinkler> sprinklerList = getService().findWithNamedQuery("Sprinkler.findBySprinklerset", QueryParameter.with("sprinklerset", sprinklersetController.getSelected()));
        logger.fine("-> getSprinklers() - " + sprinklerList);
        Map<Sprinkler, String> sprinklersMap = new LinkedHashMap<Sprinkler, String>();
        //sprinklersetsMap.put(null, "-- select one --");
        for (Sprinkler g : sprinklerList) {
            logger.fine("-> getSprinkler - value: " + g.getName() + ", obj:" + g);
            sprinklersMap.put(g, g.getName());
        }
        return sprinklersMap;
    }

    public Sprinkler getSelected() {
        return selected;
    }

    public void setSelected(Sprinkler sprinkler) {
        selected = sprinkler;
    }

    public void selectedChanged(ValueChangeEvent event) {
        Sprinkler newValue = (Sprinkler) event.getNewValue();
        Sprinkler oldValue = (Sprinkler) event.getOldValue();
        //setSelected(newValue);
        logger.fine("-> SprinklerController - selectedChanged - OldValue: " + oldValue + ", NewValue:" + newValue);
    }

    public void selectedChangedAjax(AjaxBehaviorEvent e) {
        UIInput input = (UIInput) e.getComponent();
//        String contentId = input.getId().substring("inputfield".length());
//        Object contentValue = (Object) input.getValue();
//        String value = (String) contentValue;
        logger.fine("SprinklersetController - selectedChanged - string:" + e.toString() + "," + input.getId() + "=> NUTIN");// + contentValue);

        //setSelected((Garden) e.getNewValue());
    }
}
