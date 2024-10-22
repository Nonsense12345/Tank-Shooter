// Bullet.java
import java.awt.*;

public class Bullet {
    private int x, y;
    private int direction; // 0: up, 1: right, 2: down, 3: left
    private int speed = 10;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case 0: y -= speed; break; // Lên
            case 1: x += speed; break; // Phải
            case 2: y += speed; break; // Xuống
            case 3: x -= speed; break; // Trái
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 5, 5); // Vẽ đạn
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}