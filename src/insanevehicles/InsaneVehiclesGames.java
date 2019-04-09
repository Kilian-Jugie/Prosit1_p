package insanevehicles;

import insanevehicles.element.Element;
import insanevehicles.element.MyVehicle;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javax.sound.midi.SysexMessage;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InsaneVehiclesGames {
    public static final int ROAD_WIDTH = 15;
    public static final int ROAD_HEIGHT = 40;
    public static final int ROAD_VIEW = 27;
    public static final int ROAD_QUOTA = 9;

    public static final char ROAD_MACADAM = ' ';
    public static final char ROAD_DITCH = '|';
    public static final char ROAD_OBSTACLE = 'X';
    public static final char MY_VEHICLE = 'H';

    public static final int ROAD_SPEED = 300;


    public InsaneVehiclesGames() {

    }

    public void play() {
        Road road = getRoad();
        MyVehicle vehicles = new MyVehicle(road);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.out.println("aie");
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        GlobalKeyListener.m_Vehicle = vehicles;

        //char newPos = InsaneVehiclesGames.ROAD_MACADAM;

        GlobalKeyListener.lastPos = new Element(ROAD_MACADAM);

        while((GlobalKeyListener.lastPos.getSprite()!=ROAD_OBSTACLE)&&
                (GlobalKeyListener.lastPos.getSprite()!=ROAD_DITCH)) {
            road.show(vehicles.getY());
            try {
                Thread.sleep(ROAD_SPEED);
            }catch (Exception e) {
                return;
            }
            GlobalKeyListener.lastPos = vehicles.moveForward();
        }
        System.out.println("\nCRASH");
        /*try {
            System.in.read();
        }
        catch (Exception e) {

        }*/

        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            System.out.println("aie");
        }

    }

    public Road getRoad() {
        return new Road(ROAD_WIDTH, ROAD_HEIGHT, ROAD_VIEW, ROAD_QUOTA);
    }

    private void setRoad(Road road) {

    }
}
