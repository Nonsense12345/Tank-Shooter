// GamePanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    private Tank tank;
    private ArrayList<Bullet> bullets;
    private Timer timer;

    public GamePanel() {
        tank = new Tank(100, 100);
        bullets = new ArrayList<>();
        timer = new Timer(50, this);
        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: tank.move(0, -5); break;
                    case KeyEvent.VK_DOWN: tank.move(0, 5); break;
                    case KeyEvent.VK_LEFT: tank.move(-5, 0); break;
                    case KeyEvent.VK_RIGHT: tank.move(5, 0); break;
                    case KeyEvent.VK_SPACE: shoot(); break; // Bắn đạn
                }
                repaint();
            }
        });
    }

    private void shoot() {
        int direction = 0; // Bắn lên
        bullets.add(new Bullet(tank.getX() + 20, tank.getY(), direction));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tank.draw(g);
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.move();
            // Xóa đạn nếu ra ngoài màn hình
            if (bullet.getY() < 0) {
                bullets.remove(i);
                i--;
            }
        }
        repaint();
    }
}