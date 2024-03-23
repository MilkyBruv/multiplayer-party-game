package event;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

import game.GameEventManager;

public final class MouseEventListener implements MouseListener {

    private GameEventManager game;

    public MouseEventListener(GameEventManager game) {

        this.game = game;

    }



    @Override
    public void mouseClicked(MouseEvent event) {

        if (event.getButton() == MouseEvent.BUTTON1) {

            System.out.println("Button Pressed!");

        }

    }



    @Override
    public void mouseDragged(MouseEvent event) {

        // 

    }



    @Override
    public void mouseEntered(MouseEvent event) {

        // 

    }



    @Override
    public void mouseExited(MouseEvent event) {

        // 

    }



    @Override
    public void mouseMoved(MouseEvent event) {

        // 

    }



    @Override
    public void mousePressed(MouseEvent event) {

        // 

    }



    @Override
    public void mouseReleased(MouseEvent event) {

        // 

    }



    @Override
    public void mouseWheelMoved(MouseEvent event) {

        // 

    }

}
