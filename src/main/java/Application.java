import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Application {

    public static void main(String[] args) {

        System.out.println("Преобразователь изорбражений в символы");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите изображение в формате jpg, png, bmp");
        int action = fileChooser.showOpenDialog(null);
        if(action == JFileChooser.APPROVE_OPTION){
            //если пользователь выбрал файл
            File bitmapFile = fileChooser.getSelectedFile();
            BufferedImage image = null;
            try {
                image = ImageIO.read(bitmapFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageProfile imageProfile = new ImageProfile(image);
            ImageToConsoleConverter converter = new ImageToConsoleConverter(imageProfile);
            //если нужно уменьшить размен выходноо изображения, установите ресайз фактор от 2 до 8 (падает качество)
            converter.setResizeFactor(5);
            converter.showImageToConsole();

        }
    }
}
