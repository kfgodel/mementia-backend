package ar.com.kfgodel.mementia;

import ar.com.kfgodel.proact.config.ConfigurationSelector;
import ar.com.kfgodel.proact.config.HerokuPriorityConfigSelector;
import ar.com.kfgodel.proact.config.MementiaConfiguration;

/**
 * Este tipo es el punto de entrada de la aplicación
 *  
 * Created by kfgodel on 19/02/15.
 */
public class MementiaMain {
    
    public static void main(String[] args) {
        // Configuration depends on environment variables to detect if we are at heroku hosting
        ConfigurationSelector selector = HerokuPriorityConfigSelector.create();
        MementiaConfiguration applicationConfig = selector.selectConfig();

        // Then proceed normally (heroku will connect to postgres, development uses local db)
        MementiaApplication.create(applicationConfig).start();
    }

}
