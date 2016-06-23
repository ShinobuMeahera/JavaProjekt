import java.awt.image.BufferedImage;

//PLIK GOTOWY

public class Tile {
	
	private BufferedImage image;
	private int type;
	
	// tile types
	public static final int AIR = 0;
	public static final int SOLID = 1;
	
	public Tile(BufferedImage image, int type) {
		this.image = image;
		this.type = type;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getType() {
		return type;
	}
	
}
