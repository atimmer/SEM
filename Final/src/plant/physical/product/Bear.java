package plant.physical.product;

import plant.physical.resource.*;
import plant.physical.*;

/**
 * Represents a stuffed animal bear
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class Bear extends StuffedAnimal {

	public String requirements() {
		return "Eye (2), Skin";
	}
	
	public boolean isFinished() {
		int eyes = 2;
		int skins = 1;
		
		for(int i = 0; i < resources.size(); i++) {
			if(resources.get(i) instanceof Eye) {
				eyes--;
			}else if(resources.get(i) instanceof Skin) {
				skins--;
			}
		}
		
		return (eyes <= 0) && (skins <= 0);
	}

}
