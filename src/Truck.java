import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Truck extends Unit implements Creatable, Removable {
	
	private static final String TRUCK_PATH = "assets/units/truck.png";
	private static final double SPEED = 0.25;
	
	public Truck(double x, double y, Camera camera) throws SlickException{
		super(x, y, TRUCK_PATH, SPEED, camera);
	}
	
	@Override
	public CommandCenter create(String input, double x, double y) {
			try {
				return new CommandCenter(getX(), getY(), getCamera());
			} catch (SlickException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public void remove() {setImage(null);}
	
	@Override
	public void render(Graphics g) {
		if(getImage() != null) {
			super.render(g);
			getImage().drawCentered((int)getCamera().globalXToScreenX(getX()), (int)getCamera().globalYToScreenY(getY()) );
			if (isSelect()) {
				g.drawString("1- create command centre", 32, 100);
			}
		}
		
	}
}
