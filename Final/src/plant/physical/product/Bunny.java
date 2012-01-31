package plant.physical.product;

import plant.physical.resource.*;
import plant.physical.*;

/**
 * Represents a bunny
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class Bunny extends StuffedAnimal {

	public String requirements() {
		return "Eye (2), Filling, Skin";
	}
	
	public boolean isFinished() {
		int eyes = 2;
		int skins = 1;
		int fillings = 1;
		
		for(int i = 0; i < resources.size(); i++) {
			if(resources.get(i) instanceof Eye) {
				eyes--;
			}else if(resources.get(i) instanceof Skin) {
				skins--;
			}else if(resources.get(i) instanceof Filling) {
				fillings--;
			}
		}
		
		return (eyes <= 0) && (skins <= 0) && (fillings <= 0);
	}
	
}
