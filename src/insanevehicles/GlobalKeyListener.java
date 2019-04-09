package insanevehicles;

import insanevehicles.element.Element;
import insanevehicles.element.MyVehicle;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.sound.midi.SysexMessage;

public class GlobalKeyListener implements NativeKeyListener {
    public static MyVehicle m_Vehicle;
    public static Element lastPos;
    public void nativeKeyPressed(NativeKeyEvent e) {
        switch (e.getKeyCode()) {
            case NativeKeyEvent.VC_LEFT:
                lastPos = m_Vehicle.moveLeft();
                //System.out.println("left");
                break;
            case NativeKeyEvent.VC_RIGHT:
                //System.out.println("right");
                lastPos = m_Vehicle.moveRight();
                break;
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {

    }

    public void nativeKeyTyped(NativeKeyEvent e) {

    }


}
