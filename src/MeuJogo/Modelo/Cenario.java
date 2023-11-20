package MeuJogo.Modelo;

import javax.swing.*;
import java.awt.*;

public class Cenario {
    private int x;
    private int y;

    public int getY() {
        return y;
    }

    private Image img;
    private boolean isVisivel;

    public Cenario(){
        this.x = 0;
        isVisivel = true;
    }
    public void load(){
        ImageIcon fimDoJogo =  new ImageIcon("img//clouds.png");
        img = fimDoJogo.getImage();
    }
    public void update(){
        x -= 3;
        if (x < -4000){
            x = 0;
        }
    }

    public int getX() {
        return x;
    }

    public Image getImg() {
        return img;
    }

    public boolean isVisivel() {
        return isVisivel;
    }
}
