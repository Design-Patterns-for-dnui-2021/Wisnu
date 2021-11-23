import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TankClient extends Frame {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    private Image offScreenImage = null;
    private Tank tank = new Tank(300, 300, true, Tank.Direction.STOP, this);
    Blood b = new Blood();
    Wall w1 = new Wall(100, 200, 20, 150, this), w2 = new Wall(300, 100, 300, 20, this);
    public ArrayList<Missile> missiles = new ArrayList<>();
    public ArrayList<Explode> explodes = new ArrayList<>();
    public ArrayList<Tank> tanks = new ArrayList<>();
    private Tank.Direction dir = Tank.Direction.STOP;

    public static void main(String[] args) {
        TankClient tc = new TankClient();
        tc.launchFrame();
    }

    public void launchFrame() {
        this.setLocation(300, 100);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setVisible(true);
        this.setTitle("Tank War Game");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        this.setBackground(Color.LIGHT_GRAY);

        for(int i = 0; i < 10; i++) {
            tanks.add(new Tank(50 + 40 * (i + 1), 50, false, this));
        }

        this.addKeyListener(new KeyMonitor());
        new Thread(new PaintThread()).start();
    }

    public void paint(Graphics g) {
        g.drawString("missiles count: " + missiles.size(), 10, 50);
        g.drawString("explodes count: " + explodes.size(), 10, 70);
        g.drawString("tanks count: " + tanks.size(), 10, 90);
        g.drawString("tank life: " + tank.getLife(), 10, 110);
        if (tanks.size() <= 0) {
            for (int i = 0; i < 5; i++) {
                tanks.add(new Tank(50 + 40 * (i + 1), 50, false, Tank.Direction.D, this));
            }
        }
        for (int i = 0; i < missiles.size(); i++) {
            Missile m = missiles.get(i);
            m.collidesWithTanks(tanks);
            m.collidesWithTank(tank);
            m.collidesWithWall(w1);
            m.collidesWithWall(w2);
            m.draw(g);
        }
        for (int i = 0; i < explodes.size(); i++) {
            Explode e = explodes.get(i);
            e.draw(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            Tank t = tanks.get(i);
            t.collidesWithWall(w1);
            t.collidesWithWall(w2);
            t.collidesWithTanks(tanks);
            t.draw(g);
        }
        tank.draw(g);
        tank.eat(b);
        w1.draw(g);
        w2.draw(g);
        b.draw(g);
    }

    public void update(Graphics g) {
        if (this.offScreenImage == null) {
            this.offScreenImage = this.createImage(800, 600);
        }
        Graphics gOffScreen = this.offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.DARK_GRAY);
        gOffScreen.fillRect(0, 0, 800, 600);
        gOffScreen.setColor(c);
        print(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    private class PaintThread implements Runnable {
        @Override
        public void run() {
            while(true) {
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class KeyMonitor extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {tank.keyReleased(e);}
    }
}