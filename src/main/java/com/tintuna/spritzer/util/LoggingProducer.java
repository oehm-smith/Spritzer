package com.tintuna.spritzer.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.LogManager;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

/**
 * @author Antonio Goncalves http://www.antoniogoncalves.org --
 * @author Brooke Smith brooke@tintuna.com -- Modified
 */
//@Singleton
public class LoggingProducer implements Serializable {

    // ======================================
    // =          Business methods          =
    // ======================================
    //@PostConstruct
    // Doesn't work but may so leaving in - will only run if @PostConstruct is uncommented
    /* TODO - Fix up logging.  The only way to set the Level per module is in the Glassfish logging.properties
     *   but I'd rather be able to set it in the application's own logging.properties file (but as I tried below, all
     *   this does is overwrite the glassfish logging configuration and cause weird errors).  It would be nice if could
     *   do it in code.
     *   For now I'm just setting a logging level here and I can change that as I see fit.
     */
    public void init() {
        // @PostConstruct is needed to make this execute
        final InputStream inputStream = this.getClass().getResourceAsStream("/logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(inputStream);
        }
        catch (final IOException e) {
            Logger.getAnonymousLogger().severe("Could not load default logging.properties file");
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Logger logger = Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
        System.out.println("produceLogger:"+logger);
        logger.setLevel(Level.FINEST);
        return logger;
    }
}
