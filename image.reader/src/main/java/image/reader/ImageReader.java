package image.reader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageReader {

	public static void main(String[] args) throws IOException {
		BufferedImage read = ImageIO.read(new File(""));
		List<String> colors = new LinkedList<>();
		for (int i = 0; i < read.getHeight(); i++) {
			for (int j = 0; j < read.getWidth(); j++) {
				int rgb = read.getRGB(i, j);
				Color color = new Color(rgb);
				colors.add((color.getBlue() + color.getGreen() + color.getRed()) / 3 + "");
			}
		}
		String text = "";
		for (int i = 0; i < colors.size(); i++) {
			text += colors.get(i) + " ";
			if (i % 10 == 0) {
				text += "\n";
			}
		}
		System.out.println(text);
	}
}
