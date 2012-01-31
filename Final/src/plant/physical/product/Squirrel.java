package plant.physical.product;

import plant.physical.*;
import plant.physical.resource.*;

/**
 * Represents a cute squirrel stuffed animal
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class Squirrel extends StuffedAnimal {

	public String requirements() {
		return "Eye (2), Skin, Filling, Button (3)";
	}
	
	public boolean isFinished() {
		int eyes = 2;
		int skins = 1;
		int fillings = 1;
		int buttons = 3;
		
		for(int i = 0; i < resources.size(); i++) {
			if(resources.get(i) instanceof Eye) {
				eyes--;
			}else if(resources.get(i) instanceof Skin) {
				skins--;
			}else if(resources.get(i) instanceof Filling) {
				fillings--;
			}else if(resources.get(i) instanceof Button) {
				buttons--;
			}
		}
		
		return (eyes <= 0) && (skins <= 0) && (fillings <= 0) && (buttons <= 0);
	}

}
