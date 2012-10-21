/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.service.DatabaseTestData;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author bsmith
 */
@Named("database")
@SessionScoped
public class DatabaseController extends Controller implements Serializable {

    private Boolean alreadyLoaded;
    @Inject private DatabaseTestData dtd;

    @PostConstruct
    public void init() {
        alreadyLoaded = false;
    }

    public void loadTestData() {
        //addInformationMessage("LoadDatabase", null);
        System.out.println("Load Database");
        dtd.loadTestData();
        alreadyLoaded = true;
        //addInformationMessage("DatabaseLoaded", null);
        //return "index.faces?faces-redirect=true";
    }

    public boolean isAlreadyLoaded() {
        return alreadyLoaded;
    }
}
