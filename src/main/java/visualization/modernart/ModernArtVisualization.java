package visualization.modernart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ModernArtVisualization {

    public static void main(String[] args) throws InterruptedException {
        new ModernArtVisualization();
    }

    public JFrame frame;
    public boolean[] rows = new boolean[10];
    public boolean[] cols = new boolean[10];

    private volatile int mouseX = 0, mouseY = 0;
    private final int CELL_SIZE = 40;

    public ModernArtVisualization() throws InterruptedException {
        frame = new JFrame("Visualization") {
            @Override
            public void paint(Graphics g) {
                BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
                img.getGraphics().setColor(Color.WHITE);
                img.getGraphics().fillRect(0,0, img.getWidth(), img.getHeight());
                render(img.getGraphics());
                g.drawImage(img, 0, 0, null);
            }
        };
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIgnoreRepaint(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getX() <= CELL_SIZE && e.getY() > CELL_SIZE * 1.5) {
                    //Cols
                    int col = (int) ((e.getY() - (CELL_SIZE * 1.5)) / CELL_SIZE);
                    if(cols.length <= col)
                        return;
                    synchronized (ModernArtVisualization.this) {
                        cols[col] ^= true;
                    }
                } else if(e.getY() <= CELL_SIZE * 1.5 && e.getX() > CELL_SIZE) {
                    //Rows
                    int row = (e.getX() - (CELL_SIZE)) / CELL_SIZE;
                    if(rows.length <= row)
                        return;;
                    synchronized (this) {
                        rows[row] ^= true;
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });


        while (true) {
            synchronized (this) {
                frame.paint(frame.getGraphics());
            }
            Thread.sleep(10);
        }
    }

    public void render(Graphics graphics2D) {

        renderGrid(graphics2D, CELL_SIZE, CELL_SIZE + CELL_SIZE / 2, rows, cols, CELL_SIZE);

        for (int i = 0; i < rows.length; i++) {
            int x = CELL_SIZE + CELL_SIZE * i;
            renderButton(graphics2D, x, CELL_SIZE, rows[i],
                    false, CELL_SIZE);
        }
        for (int i = 0; i < cols.length; i++) {
            int y = CELL_SIZE + CELL_SIZE * i + CELL_SIZE / 2;
            renderButton(graphics2D, CELL_SIZE / 2, y, cols[i],
                    true, CELL_SIZE);
        }
    }

    public void renderButton(Graphics g, int x, int y, boolean state, boolean sideways, int scale) {
        Color color = state ? Color.DARK_GRAY : Color.GRAY;
        g.setColor(color);
        g.fillRect(x, y, sideways ? scale/2 : scale, sideways ? scale : scale/2);
    }

    public void renderGrid(Graphics g, int x, int y, boolean[] rows, boolean[] cols, int scale) {
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if(rows[i] ^ cols[j]) {
                    g.setColor(Color.ORANGE);
                } else {
                    g.setColor(Color.DARK_GRAY);
                }
                g.fillRect(i * scale + x, j * scale + y, scale, scale);
                ((Graphics2D)g).setStroke(new BasicStroke(2));
                g.setColor(Color.BLACK);
                g.drawRect(i * scale + x, j * scale + y, scale, scale);

                if(rows[i] & cols[j]) {
                    g.setColor(Color.GREEN.darker());
                    ((Graphics2D)g).setStroke(new BasicStroke(6));
                    g.drawRect(i * scale + x + 4, j * scale + y + 4, scale-8, scale-8);
                }
            }
        }
    }
}
