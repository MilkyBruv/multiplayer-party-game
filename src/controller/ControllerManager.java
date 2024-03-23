package controller;

import net.java.games.input.ControllerEnvironment;

public abstract class ControllerManager {
    
    public static final Controller[] controllers = new Controller[] {null, null, null, null};

    public static final void getControllers() {

        net.java.games.input.Controller[] availableControllers = ControllerEnvironment.getDefaultEnvironment()
            .getControllers();

        for (int i = 0; i < controllers.length; i++) {
            
            System.out.println(availableControllers[i].getName());

        }

    }

}
