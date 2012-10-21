/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.domain.Garden;
import com.tintuna.spritzer.service.GardenService;
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
public class GardenController extends Controller implements Serializable {
    private Garden selected;
    
    @Inject private GardenService gardenService;
    
    public Object getGardens() {    // List<SelectItem>
        List<Garden> gardenList = gardenService.findAll();
        List<SelectItem> gardenSList = new ArrayList<SelectItem>();
        for (Garden g : gardenList) {
            gardenSList.add(new SelectItem(g));
        }
        return gardenSList;
    }
    
    public Garden getSelected() {
        return selected;
    }
    
    public void setSelected(Garden garden) {
        selected = garden;
    }
}
