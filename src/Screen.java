import java.awt.image.*;
import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel implements Runnable{
	public Thread thread = new Thread(this);
        public static Image[] tileset_ground = new Image[100];
        public static Image[] tileset_air = new Image[100];
        public static int myWidth, myHeight;
        public static boolean isFirst = true;
        public static Room room;
        
        public Screen(){
		thread.start();
	}
        public void define(){
            room = new Room(); 
            
            for(int i=0;i<tileset_ground.length;i++){
                tileset_ground[i] = new ImageIcon("res/tileset_ground.png").getImage();
                tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(),new CropImageFilter(0,23*i,23,23)));
            }
             for(int i=0;i<tileset_air.length;i++){
                tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
                tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(),new CropImageFilter(0,23*i,23,23)));
            }
        }
        @Override
	public void paintComponent(Graphics g){
            if(isFirst){
                myWidth = getWidth();
                myHeight = getHeight();
                define();
                isFirst= false;
            }
            g.clearRect(0,0, getWidth(), getHeight());
            
            room.draw(g);

	}
        @Override
	public void run(){
            while(true){
                if(!isFirst){
                    room.physic();
                }
                repaint();
                try{
                    Thread.sleep(1);
                } catch(Exception e){}
            }
        }
}
