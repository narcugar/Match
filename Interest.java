import java.io.Serializable;

public class Interest implements Comparable<Interest>, Serializable{
	private String topic;
	private int level;
	
	
public Interest(String topic, int level) throws InvalidInterestException {
	setTopic(topic);
	setLevel(level);
}

public void setTopic(String topic) throws InvalidInterestException {
	if(topic.contentEquals("")) {
		throw new InvalidInterestException("topic may not be blank");
	}
	this.topic = topic;
}

public void setLevel(int level) throws InvalidInterestException {
	if(level < 0 || level > 10) {
		throw new InvalidInterestException("Level" + level +
				"is invalid; Please select a level between 0-10");
	}
	this.level = level;
}

public String getTopic() {
	return topic;
}

public int getLevel() {
	return level;
}

public String toString() {
	return topic + " - " + level;
}

public int compareTo(Interest o) {
	if((o.getLevel() - this.level == 0) && o.getTopic().charAt(0) > this.getTopic().charAt(0)) {
		return -1;
	}
	return o.getLevel() - this.level;

}
}

