import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class EnergyParticle extends Object {
	
	private int count;
	private boolean remove;
	
	private BufferedImage[] sprites;
	protected Animation animation = new Animation();
	
	public static int UP = 0;
	public static int LEFT = 1;
	public static int DOWN = 2;
	public static int RIGHT = 3;
	private boolean facingRight;
	
	public EnergyParticle(TileMap tm, double x, double y, int dir) {
		
		super(tm);
		
		facingRight = true;
		this.x = x;
		this.y = y;
		double d1 = Math.random() * 2.5 - 1.25;
		double d2 = -Math.random() - 0.8; 
		if(dir == UP) {
			dx = d1;
			dy = d2;
		}
		else if(dir == LEFT) {
			dx = d2;
			dy = d1;
		}
		else if(dir == DOWN) {
			dx = d1;
			dy = -d2;
		}
		else {
			dx = -d2;
			dy = d1;
		}
		
		count = 0;
		sprites = Content.EnergyParticle[0];
		animation.setFrames(sprites);
		animation.setDelay(-1);
	}
	
	public void update() {
		x += dx;
		y += dy;
		count++;
		if(count == 25) remove = true;
	}
	
	public boolean shouldRemove() { return remove; }
	
	public void draw(Graphics2D g) {
		setMapPosition();
		if(facingRight) {
			g.drawImage( animation.getImage(), (int)(x + xmap - width / 2), 		(int)(y + ymap - height / 2), null );
		}
		else {
			g.drawImage( animation.getImage(), (int)(x + xmap - width / 2 + width), (int)(y + ymap - height / 2), -width, height, null );
		}
	}
	
}
