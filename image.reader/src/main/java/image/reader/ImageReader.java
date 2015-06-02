package image.reader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageReader {

	public static void main(String[] args) throws IOException {
		File input = new File("/home/fernandobt8/github/javaNNS.images/image.reader/src/main/resources/0.png");
		System.out.println(input.getAbsolutePath());
		BufferedImage read = ImageIO.read(input);
		List<Integer> colors = new LinkedList<>();
		for (int i = 0; i < read.getHeight(); i++) {
			for (int j = 0; j < read.getWidth(); j++) {
				int rgb = read.getRGB(j, i);
				Color color = new Color(rgb);
				colors.add((color.getBlue() + color.getGreen() + color.getRed()) / 3);
			}
		}
		String text = "";
		NumberFormat instance = NumberFormat.getInstance();
		instance.setMinimumIntegerDigits(3);
		for (int i = 0; i < colors.size(); i++) {
			if (i % 10 == 0) {
				text += "\n";
			}
			text += instance.format(colors.get(i)) + " ";
		}
		System.out.println(text);
	}
}
