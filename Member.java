import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
public class Member implements Iterable<Interest>, Serializable{
	private String name;
	private int year;
	
	private LinkedList<Interest> interests;



public Member(String name, int year) throws InvalidMemberException {
	setName(name);
	setYear(year);
	interests = new LinkedList<>();
	
}

public void setName(String name) throws InvalidMemberException {
	if(name.contentEquals("")) {
		throw new InvalidMemberException("Name may not be blank");
	}
	this.name = name;
}

public void setYear(int year) throws InvalidMemberException {
	if(year < 1 || year > 5) {
		throw new InvalidMemberException("Year " + year +
				" is invalid; please specify between 1-5");
		
	}
	this.year = year;
}

public void addInterest(Interest interest) {
	interests.add(interest);
	interests.sort(null);

}

public String getName() {
	return name;
}

public int getYear() {
	return year;
}

public String toString() {
	String result = "";
	for(Interest interest: this) {
		result += interest.toString() + "\n";
	}
	return name + " - " + year + "\n" + result;
	
}


public Iterator<Interest> iterator() {
	return interests.iterator();
}

public Interest findInterest(String topic) {
	for(Interest interest: this) {
		if(interest.getTopic().equals(topic)) {
			return interest;
	}
	}
	return null;
}

public LinkedList<Interest> getInterest() {
	
	return interests;
}
}
