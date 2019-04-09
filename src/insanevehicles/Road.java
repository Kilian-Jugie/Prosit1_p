package insanevehicles;

import insanevehicles.element.Element;

import javax.sound.midi.SysexMessage;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class Road {
    private int width;
    private int height;
    private int view;
    private int quota;

    private Element[][] m_Road;

    public int getWidth() {
        return width;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    public int getView() {
        return view;
    }

    private void setView(int view) {
        this.view = view;
    }

    public int getQuota() {
        return quota;
    }

    private void setQuota(int quota) {
        this.quota = quota;
    }


    public Road(int width, int height, int view, int quota) {
        m_Road = new Element[height][width];
        for(int y=0; y<height; ++y) {
            for(int x=0; x<width; ++x) {
                if((x==0)||(x==width-1))
                    setOnTheRoadXY(new Element(InsaneVehiclesGames.ROAD_DITCH), x, y);
                else if(((int)(Math.random()*100))%InsaneVehiclesGames.ROAD_QUOTA==0)
                    setOnTheRoadXY(new Element(InsaneVehiclesGames.ROAD_OBSTACLE), x, y);
                else
                    setOnTheRoadXY(new Element(InsaneVehiclesGames.ROAD_MACADAM), x, y);
            }
        }
    }

    public void show(int yStart) {
        //System.out.print("\033[H\033[2J");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
        //try {
        //    Runtime.getRuntime().exec("cls");
        //}catch (Exception e) {}

        for(int y=yStart, view=0; view < InsaneVehiclesGames.ROAD_VIEW; y=(y+1)%InsaneVehiclesGames.ROAD_HEIGHT, ++view) {
            for (int x = 0; x < InsaneVehiclesGames.ROAD_WIDTH; ++x)
                System.out.print(getOnTheRoadXY(x, y).getSprite());
            System.out.println();
        }
    }

    private void fillOnTheRoad() {

    }

    public Element getOnTheRoadXY(int x, int y) {
        return m_Road[y][x];
    }

    public void setOnTheRoadXY(Element element, int x, int y) {
        m_Road[y][x] = element;
    }

}
