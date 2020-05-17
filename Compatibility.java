import java.util.LinkedList;
import java.util.Iterator;

public class Compatibility {
	
	private Member my;
	private Member their;
	private int score;
	
	

	
	public Compatibility(Member my, Member their) {
		this.my = my;
		this.their = their;
		
		boolean found = false;
		
		for(Interest i : their.getInterest()) {
			for(Interest k : my.getInterest()) {
				if(i.getTopic().equalsIgnoreCase(k.getTopic())) {
					found = true;
					score += (i.getLevel() * k.getLevel());
					break;
				}
				
			}
			if(!found) {
				score += i.getLevel() / 2;
			}	
			found = false;
			
		}
		return;
		
	
	}
	
	public int getScore() {
		return score;
	}
	
	public Member getTheir() {
		return their;
	}
	
	public String toString() {
		return their + "-" + score;
	}
	
	public int compareTo(Compatibility o) {
		if((o.getScore() - this.score==0) && o.their.getName().charAt(0) > this.their.getName().charAt(0)) {
			return -1;
		}
		return o.getScore() - this.score;
		
	}

}
