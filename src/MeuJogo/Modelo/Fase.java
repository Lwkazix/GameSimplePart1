package MeuJogo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Fase  extends JPanel implements ActionListener {
    private Timer timer;
    private boolean emJogo;
    private Cenario cenario;
    private Player player;
    private List<Stone> stone;

    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);


        emJogo = true;
        timer = new Timer(10,this);
        timer.start();

        cenario = new Cenario();
        cenario.load();

        player = new Player();
        player.load();

        inicializarStone();
    }

    public void inicializarStone(){
        int coordenadas[] = new int [10];
        stone = new ArrayList<>();

        for (int i = 0; i < coordenadas.length;i++){
            int x = (int) Math.random() * 8000 + 1024;
            stone.add(new Stone(x));
        }
    }

    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;
        if (emJogo){
            graphics2D.drawImage(player.getImg(),player.getX(), player.getY(),this);
            graphics2D.drawImage(cenario.getImg(),cenario.getX(),cenario.getY(),this);

            for (int i = 0; i < stone.size(); i++){
                Stone in = stone.get(i);
                in.load();
                graphics2D.drawImage(in.getImg(), in.getX(),420,this);
            }

        }
        else {
            ImageIcon fimDoJogo =  new ImageIcon("img//game-over.png");
            graphics2D.drawImage(fimDoJogo.getImage(),0,0,null);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cenario.update();
        player.update();

        for (int i = 0; i < stone.size(); i++) {
            Stone in = stone.get(i);
            in.update();
        }
        checarColissoes();
        repaint();
    }

    public void checarColissoes(){
        Rectangle formaPlayer = player.getBounds();
        Rectangle formaStone;

        for (int i = 0; i < stone.size(); i++){
            Stone in = stone.get(i);
            formaStone = in.getBounds();
                if (formaPlayer.intersects(formaStone)){
                    player.setVisivel(false);
                    emJogo = false;

                }
        }
    }

    private class TecladoAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}
