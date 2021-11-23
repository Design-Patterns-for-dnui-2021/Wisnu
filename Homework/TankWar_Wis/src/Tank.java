import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Tank {
    private int x, y, step, oldX, oldY, life;
    private boolean bL = false, bU = false, bR = false, bD = false;
    private final int XSPEED = 5, YSPEED = 5;
    public static final int WIDTH = 30, HEIGHT = 30;
    private TankClient tankClient;
    private Direction dir = Direction.STOP;
    private Direction ptDir = Direction.D;
    private boolean good;
    private boolean live;
    private static Random r = new Random();
    Direction[] dirs = Direction.values();
    int rn = r.nextInt(dirs.length);

    public Tank(int x, int y, boolean good, TankClient tankClient) {
        this.x = x;
        this.y = y;
        this.good = good;
        this.tankClient = tankClient;
    }

    public Tank(int x, int y, boolean good, Direction dir, TankClient tankClient) {
        this(x, y, good, tankClient);
        this.dir = dir;
    }

    enum Direction {
        L, LU, U,
        RU, R, RD,
        D, LD, STOP
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isGood() {
        return good;
    }

    public void setLife(int live) {
        this.life = live;
    }

    public int getLife() {
        return life;
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        if(good) g.setColor(Color.CYAN);
        else g.setColor(Color.RED);
        g.fillOval(this.x, this.y, 30, 30);
        g.setColor(c);

        switch(ptDir) {
            case L:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT / 2);
                break;
            case LU:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x, y);
                break;
            case U:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x + Tank.WIDTH /2, y);
                break;
            case RU:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x + Tank.WIDTH, y);
                break;
            case R:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT / 2);
                break;
            case RD:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT);
                break;
            case D:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x + Tank.WIDTH /2, y + Tank.HEIGHT);
                break;
            case LD:
                g.drawLine(x + Tank.WIDTH /2 , y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT);
                break;
            case STOP:
                break;
        }

        move();
    }

    void move() {
        switch (dir) {
            case L:
                x -= XSPEED;
                break;
            case LU:
                x -= XSPEED;
                y -= YSPEED;
                break;
            case U:
                y -= YSPEED;
                break;
            case RU:
                x += XSPEED;
                y -= YSPEED;
                break;
            case R:
                x += XSPEED;
                break;
            case RD:
                x += XSPEED;
                y += YSPEED;
            case D:
                x += YSPEED;
            case LD:
                x -= XSPEED;
                y += YSPEED;
            case STOP:
                break;
        }

        if(this.dir != Direction.STOP) {
            this.ptDir = this.dir;
        }

        if(x < 0) x = 0;
        if(y < 25) y = 25;
        if(x + Tank.WIDTH > TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH - Tank.WIDTH;
        if(y + Tank.HEIGHT > TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT - Tank.HEIGHT;

        if(!good) {
            step = r.nextInt(12) + 3;
            int rn = r.nextInt(dirs.length); dir = dirs[rn];
        }
        step--;
        if(r.nextInt(40) > 38) this.fire();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            // firing
            case KeyEvent.VK_CONTROL:
                fire();
                break;
            // movement
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
        }
        locateDirection();
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_A:
                superFire();
                break;
        }
        locateDirection();
    }

    void locateDirection() {
        if (bL && !bU && !bR && !bD) dir = Direction.L;
        else if (bL && bU && !bR && !bD) dir = Direction.LU;
        else if (!bL && bU && !bR && !bD) dir = Direction.U;
        else if (!bL && bU && bR && !bD) dir = Direction.RU;
        else if (!bL && !bU && bR && !bD) dir = Direction.R;
        else if (!bL && !bU && bR && bD) dir = Direction.RD;
        else if (!bL && !bU && !bR && bD) dir = Direction.D;
        else if (bL && !bU && !bR && bD) dir = Direction.LD;
        else if (!bL && !bU && !bR && !bD) dir = Direction.STOP;
    }

    public Missile fire() {
        int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Missile.WIDTH / 2;
        Missile m = new Missile(x, y, dir, tankClient);
        tankClient.missiles.add(m);
        return m;
    }

    public Missile fire(Direction dir) {
        if(!live) return null;
        int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
        int y = this.y + Tank.HEIGHT /2 - Missile.WIDTH / 2;
        Missile m = new Missile(x, y, dir, this.tankClient, good);
        tankClient.missiles.add(m);
        return m;
    }


    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public boolean collidesWithWall(Wall w) {
        if(this.getRect().intersects(w.getRect()) &&
                this.live) {
            this.stay(); return true;
        }
        return false;
    }

    public void stay() {
        x = oldX;
        y = oldY;
    }

    public boolean collidesWithTanks(ArrayList<Tank> tanks) {
        for(int i = 0; i < tanks.size(); i++) { Tank t = tanks.get(i);
            if(this != t) {
                if(this.live && t.isLive() &&
                    this.getRect().intersects(t.getRect())) { t.stay();
                    this.stay();
                    return true;
                }
            }
        }
        return false;
    }

    private void superFire() {
        Direction[] dirs = Direction.values();
        for(int i = 0; i < 8; i++) { fire(dirs[i]);
        }
    }

    public boolean eat(Blood b) {
        if(this.live && b.isLive() &&
                this.getRect().intersects(b.getRect())) { this.life = 100; b.setLive(false);
            return true;
        }
        return false;
    }

    private class BloodBar {
        public void draw(Graphics g) { Color c = g.getColor(); g.setColor(Color.RED);
            g.drawRect(x, y - 10, WIDTH, 10); int w = WIDTH * life / 100; g.fillRect(x, y - 10, w, 10); g.setColor(c);
        }
    }

}