import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {
    private int x = 50; // начальные координаты центра окружности
    private int y = 50;
    private int diameter = 50; // диаметр окружности
    private int dx = 2; // шаг перемещения по оси x
    private int dy = 2; // шаг перемещения по оси y

    public Main() {
        var timer = new Timer(10, this);
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, diameter, diameter);
    }

    public void actionPerformed(ActionEvent e) {
        moveCircle();
        checkCollision();
        repaint();
    }

    private void moveCircle() {
        x += dx;
        y += dy;
    }

    private void checkCollision() {
        if (x < 0 || x + diameter > getWidth()) { // горизонтальные стенки
            dx = -dx;
        }
        if (y < 0 || y + diameter > getHeight()) { // вертикальные стенки
            dy = -dy;
        }
    }

    public static void main(String[] args) {
        var frame = new JFrame("Мячик");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main elasticCircleMotion = new Main();
        frame.add(elasticCircleMotion);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
