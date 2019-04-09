package insanevehicles.element;

import insanevehicles.InsaneVehiclesGames;
import insanevehicles.Road;

public class MyVehicle extends Element {
    private int x;
    private int y;
    private Road m_Road;

    public MyVehicle(Road road) {
        super('H');
        this.x = InsaneVehiclesGames.ROAD_WIDTH/2;
        this.y = 0;
        m_Road=road;

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Element moveLeft() {
        return moveXY((this.x-1+InsaneVehiclesGames.ROAD_WIDTH)%InsaneVehiclesGames.ROAD_WIDTH, this.y);
    }

    public Element moveRight() {
        return moveXY((this.x+1)%InsaneVehiclesGames.ROAD_WIDTH, this.y);
    }

    public Element moveForward() {
        return moveXY(this.x, (this.y+1)%InsaneVehiclesGames.ROAD_HEIGHT);
    }

    private Element moveXY(int x, int y) {
        this.remove();
        this.x=x;
        this.y=y;
        return setOnRoad();
    }

    private void remove() {
        m_Road.setOnTheRoadXY(new Element(InsaneVehiclesGames.ROAD_MACADAM), this.x, this.y);
    }

    private Element setOnRoad() {
        Element lastElementOnRoad = m_Road.getOnTheRoadXY(this.x, this.y);
        m_Road.setOnTheRoadXY(new Element(InsaneVehiclesGames.MY_VEHICLE), this.x, this.y);
        return lastElementOnRoad;
    }
}
