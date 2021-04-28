import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProfile {

    private BufferedImage image;
    private int width;
    private int height;
    //тут храним цвет каждого пикеля
    private Color[][] colors;

    public ImageProfile(BufferedImage image) {
        this.image = image;
        this.height  = image.getHeight();
        this.width = image.getWidth();
        extractColorFromImage();
    }
    //сохраняем цвет каждого пикселя в массив
    private void extractColorFromImage(){
        colors = new Color[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                colors[i][j] =  new Color(image.getRGB(j, i));
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color[][] getColors() {
        return colors;
    }
}
