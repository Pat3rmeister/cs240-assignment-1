import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.Color;

public class imgCreator {

    public static Color convert(String code) {
        if (code.equals("R")) {
            return new Color(237, 28, 36);
        } else if (code.equals("B")) {
            return new Color(0, 0, 0);
        } else if (code.equals("Y")) {
            return new Color(255, 242, 0);
        } else {
            return Color.BLACK;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner file = new Scanner(new File("smiley1.txt"));

        ArrayList<String[]> lines = new ArrayList<>();

        while (file.hasNextLine()) {
            String line = file.nextLine();
            lines.add(line.trim().split("\\s+"));
        }

        file.close();

        int height = lines.size();
        int width = lines.get(0).length;

        BufferedImage img = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB
        );

        for (int y = 0; y < height; y++) {
            String[] pixels = lines.get(y);

            for (int x = 0; x < width; x++) {
                String pixel = pixels[x];

                Color color = convert(pixel);

                img.setRGB(x, y, color.getRGB());
            }
        }

        ImageIO.write(img, "png", new File("smiley2.png"));

        System.out.println("Image created!");
    }
}