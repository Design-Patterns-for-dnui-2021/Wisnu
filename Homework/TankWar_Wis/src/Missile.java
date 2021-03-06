import java.awt.*;
import java.util.ArrayList;

public class Missile {
    public static final int XSPEED = 10;
    public static final int YSPEED = 10;

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    private int x, y, oldX, oldY;
    Tank.Direction dir;
    private boolean live = true;
    private TankClient tankClient;
    private boolean good;

    public Missile(int x, int y, Tank.Direction dir) {
        this.x = x; this.y = y; this.dir = dir;
    }

    public Missile(int x, int y, Tank.Direction dir, TankClient tankClient) {
        this(x, y, dir);
        this.tankClient = tankClient;
    }

    public Missile(int x, int y, Tank.Direction dir, TankClient tankClient, Boolean good) {
        this(x, y, dir, tankClient);
        this.good = good;
    }

    public boolean isLive() {
        return live;
    }

    public void draw(Graphics g) {
        if(!live) {
            tankClient.missiles.remove(this);
            return;
        }
        Color c = g.getColor();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
        switch(dir) {
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
                break;
            case D:
                y += YSPEED;
                break;
            case LD:
                x -= XSPEED;
                y += YSPEED;
                break;
        }

        if (x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT) {
            live = false; tankClient.missiles.remove(this);
        }
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public boolean hitTank(Tank t) {
        if(this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.isGood()) {
            t.setLive(false);
            this.live = false;
            Explode e = new Explode(t.getX(), t.getY(), tankClient);
            tankClient.explodes.add(e);
            return true;
        }
        return false;
    }

    public boolean hitTanks(ArrayList<Tank> tanks) {
        for(int i = 0; i < tanks.size(); i++) {
            if(hitTank(tanks.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean hitWall(Wall w) {
        if(this.live &&
                this.getRect().intersects(w.getRect())) {
            this.live = false; return true;
        }
        return false;
    }

    private void stay() {
        x = oldX;
        y = oldY;
    }

    public boolean collidesWithWall(Wall w) {
        if(this.getRect().intersects(w.getRect()) &&
                this.live) {
            this.stay(); return true;
        }
        return false;
    }

    public boolean collidesWithTank(Tank t) {
        if(this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.isGood()) {
            if(t.isGood()) {
                t.setLife(t.getLife() - 20);
                if(t.getLife() <= 0) {
                    t.setLive(false);
                }
            } else {
                t.setLive(false);
            }
            this.live = false;
            Explode e = new Explode(x, y, tankClient); tankClient.explodes.add(e);
            return true;
        }
        return false;
    }

    public boolean collidesWithTanks(ArrayList<Tank> tanks) {
        for(int i = 0; i < tanks.size(); i++) { Tank t = tanks.get(i);
            if(this.live && t.isLive() &&
                    this.getRect().intersects(t.getRect())) { t.stay();
                this.stay();
                return true;
            }
        }
        return false;
    }

}