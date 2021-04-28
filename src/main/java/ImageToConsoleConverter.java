import java.awt.*;

public class ImageToConsoleConverter {
    private final char[] consoleColorSymbol = {'.', ',', ':', '+', '*', '?', '%', 'S', '#', '@'};
    private ImageProfile imageProfile;
    private int resizeFactor = 1;

    public ImageToConsoleConverter(ImageProfile imageProfile){
        this.imageProfile = imageProfile;
    }
    //конвертирует из RGB -> серую гамму
    private int convertToGrayscale(Color color){
        return (int)(color.getBlue() + color.getGreen() + color.getRed())/3;
    }


    public void showImageToConsole(){
        Color[][] colors = imageProfile.getColors();
        for(int i = 0; i < imageProfile.getHeight(); i=i+resizeFactor){
            for(int j = 0; j < imageProfile.getWidth(); j=j+resizeFactor){
                int el = (int)colorNumberToSymbolConverter(convertToGrayscale(colors[i][j]), 0, 255, 0, consoleColorSymbol.length-1);
                System.out.print(consoleColorSymbol[el]);
            }
            System.out.println();
        }
    }

    private float colorNumberToSymbolConverter(float value, float start1, float stop1, float start2, float stop2) {
        return ((value - start1) / (stop1 - start1)) * (stop2 - start1) + start2;
    }

    public void setResizeFactor(int resizeFactor) {
        this.resizeFactor = resizeFactor;
    }
}
