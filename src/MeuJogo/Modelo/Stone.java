package MeuJogo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Stone  {
    private int x,y,a,dx,dy,altua,largura;
    private Timer timer;
    private Image img;
    private boolean isVisivel;

    public Stone(int x){
        this.x = 100;
        this.y = 365;
        isVisivel = true;
        a = 0;
        timer = new Timer(0,null);
        timer.start();
    }
    public void load(){
        ImageIcon fimDoJogo =  new ImageIcon("img//mario.gif");
        img = fimDoJogo.getImage();

        altua = img.getHeight(null);
        largura = img.getWidth(null);
    }

    public void pulo(){
        if (a == 1){
            dy = 15;
        }
    }
    public void update(){
        if (x > -100){
            x -= 3;
        }
        if (x == -100){
            x = -100;
        }
    }
    public Rectangle getBounds(){
        return  new Rectangle(x,y,largura,altua);
    }

    public void keyPressed(KeyEvent tecla){
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_SPACE){
            if (a == 0){
                a = 1;
            }
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImg() {
        return img;
    }

    public boolean isVisivel() {
        return isVisivel;
    }
}

