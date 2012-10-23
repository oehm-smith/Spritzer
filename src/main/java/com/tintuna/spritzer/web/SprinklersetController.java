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
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
 @Named
public class SprinklersetController extends Controller implements Serializable {
    private Sprinklerset selected;
    
    @Inject private SprinklerSetService sprinklerSetService;
    @Inject private GardenController gardenController;
    
    public Object getSprinklerSet() {    // List<SelectItem>
        System.out.println("-> getSprinklerSet()");
        if (gardenController.getSelected() == null) {
            return null;
        }
        List<Sprinklerset> sprinklerSetList = sprinklerSetService.getCrudService().findWithNamedQuery("Sprinklerset.findByGarden", QueryParameter.with("gardenId", gardenController.getSelected()));
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
}   

