package TPE;

import java.util.ArrayList;

public class User {
	private User next;
	private Integer userId;
	private ArrayList<String> userInterest = new ArrayList<String>();
	private boolean exists;
	private long timeArray;
	
	public boolean exists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	private long timeFirst;
	private long timeLast;
	
	public Integer getUserId(){
		return userId;
	}
	
	public void setUserId(String id){
		userId = Integer.parseInt(id);
	}
	
	public void addInterest(String interest){
		if(!userInterest.contains(interest)){
			userInterest.add(interest);
		}
	}

	public int compareTo(User user) {
		return this.userId-user.getId();
	}

	private Integer getId() {
		// TODO Auto-generated method stub
		return userId;
	}

	public void setNext(User user) {
		this.next = user;
	}

	public User getNext() {
		return this.next;
	}
	
	public boolean hasNext() {
		if(next != null){
			return true;
		}
		else{
			return false;
		}
	}

	public long getTimeArray() {
		return timeArray;
	}

	public void setTimeArray(long timeArray) {
		this.timeArray = timeArray;
	}

	public long getTimeFirst() {
		return timeFirst;
	}

	public void setTimeFirst(long timeFirst) {
		this.timeFirst = timeFirst;
	}

	public long getTimeLast() {
		return timeLast;
	}

	public void setTimeLast(long timeLast) {
		this.timeLast = timeLast;
	}
}
