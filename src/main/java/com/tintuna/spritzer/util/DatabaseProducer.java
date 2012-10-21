package com.tintuna.spritzer.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

public class DatabaseProducer {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Produces
    @PersistenceContext( unitName = "applicationSpritzerPU")
    private EntityManager em;
}
