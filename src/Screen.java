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
            
            for(int i=0;1<tileset_ground.length;i++){
                tileset_ground[1] = new ImageIcon("res/tileset_ground.png").getImage();
                tileset_ground[1] = createImage(new FilteredImageSource(tileset_ground[1].getSource(),new CropImageFilter(0,23*i,23,23)));
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
