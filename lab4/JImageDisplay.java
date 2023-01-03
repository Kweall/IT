package lab4;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
public class JImageDisplay extends javax.swing.JComponent{
    //Поле для управления изображением, содержимое которого можно записать
    private BufferedImage img; 
    
    public JImageDisplay(int width, int height) {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension dim = new Dimension(width, height);
        super.setPreferredSize(dim);
    }
    
    @Override
    //Метод для отрисовки изображения
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
    }

    //Метод, который устанавливает все пиксели изображения в черный цвет
    public void clearImage() {
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                // Делает [i][j] пиксель черным
                img.setRGB(i, j, 0);
            }
        }
    }
    //метод, который устанавливает пиксель в определенный цвет
    public void drawPixel(int x, int y, int rgbColor) {
        img.setRGB(x, y, rgbColor);
    }
}