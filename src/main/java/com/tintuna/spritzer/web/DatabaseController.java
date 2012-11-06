/**
* This file is part of Spritzer.
 
Spritzer is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
 
Spritzer is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
 
You should have received a copy of the GNU General Public License
along with Spritzer.  If not, see http://www.gnu.org/licenses/.
 
* Copyright 2012 Brooke Smith, tintuna.com.
**/
package com.tintuna.spritzer.web;

import com.tintuna.spritzer.service.DatabaseTestData;
import java.io.Serializable;
import java.util.logging.Logger;
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
public class DatabaseController implements Serializable {

    private Boolean alreadyLoaded;
    @Inject private DatabaseTestData dtd;
    @Inject 
    private transient Logger logger;

    @PostConstruct
    public void init() {
        alreadyLoaded = false;
    }

    public void loadTestData() {
        //addInformationMessage("LoadDatabase", null);
        logger.info("Load Database");
        dtd.loadTestData();
        alreadyLoaded = true;
        //addInformationMessage("DatabaseLoaded", null);
        //return "index.faces?faces-redirect=true";
    }

    public boolean isAlreadyLoaded() {
        return alreadyLoaded;
    }
}
