
package event;

import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.event.WindowUpdateEvent;

public final class WindowEventListener implements WindowListener {

    private GameEventManager game;

    public WindowEventListener(GameEventManager game) {

        this.game = game;

    }




    @Override
    public void windowDestroyNotify(WindowEvent arg0) {

        // 

    }



    @Override
    public void windowDestroyed(WindowEvent arg0) {

        System.exit(0);

    }



    @Override
    public void windowGainedFocus(WindowEvent arg0) {

        // 

    }

    

    @Override
    public void windowLostFocus(WindowEvent arg0) {

        // 

    }

    

    @Override
    public void windowMoved(WindowEvent arg0) {

        // 

    }

    

    @Override
    public void windowRepaint(WindowUpdateEvent arg0) {

        // 

    }

    

    @Override
    public void windowResized(WindowEvent arg0) {
        
        // 

    }
    
}
