package TPE;

import java.util.ArrayList;

public class User {
	protected final static String k500 = "500k";
	protected final static String m1 = "1m";
	protected final static String m3 = "3m";
	private User next;
	private Integer userId;
	private ArrayList<String> userInterest = new ArrayList<String>();
	private boolean existsIn500k = false;
	private boolean existsIn1m = false;
	private boolean existsIn3m = false;
	private long timeLast500k;
	private long timeLast1m;
	private long timeLast3m;
	private long timeFirst500k;
	private long timeFirst1m;
	private long timeFirst3m;
	private long timeArray500k;
	private long timeArray1m;
	private long timeArray3m;
	
	public boolean exists(String value) {
		if(value.equals(k500)){
			return existsIn500k;
		} else if(value.equals(m1)){
			return existsIn1m;
		} else{
			return existsIn3m;
		}
	}

	public void setExists(String value, boolean exists) {
		if(value.equals(k500)){
			this.existsIn500k = exists;
		} else if(value.equals(m1)){
			this.existsIn1m = exists;
		} else if(value.equals(m3)){
			this.existsIn3m = exists;
		}	
	}
	
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
		return this.userId.compareTo(user.getId());
	}

	private Integer getId() {
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

	public long getTimeArray(String value) {
		if(value.equals(k500)){
			return timeArray500k;
		} else if(value.equals(m1)){
			return timeArray1m;
		} else{
			return timeArray3m;
		}
	}

	public void setTimeArray(String value, long timeArray) {
		if(value.equals(k500)){
			this.timeArray500k = timeArray;
		} else if(value.equals(m1)){
			this.timeArray1m = timeArray;
		} else if(value.equals(m3)){
			this.timeArray3m = timeArray;
		}
	}

	public long getTimeFirst(String value) {
		if(value.equals(k500)){
			return timeFirst500k;
		} else if(value.equals(m1)){
			return timeFirst1m;
		} else{
			return timeFirst3m;
		}
	}

	public void setTimeFirst(String value, long timeFirst) {
		if(value.equals(k500)){
			this.timeFirst500k = timeFirst;
		} else if(value.equals(m1)){
			this.timeFirst1m = timeFirst;
		} else if(value.equals(m3)){
			this.timeFirst3m = timeFirst;
		}
	}

	public long getTimeLast(String value) {
		if(value.equals(k500)){
			return timeLast500k;
		} else if(value.equals(m1)){
			return timeLast1m;
		} else{
			return timeLast3m;
		}
	}

	public void setTimeLast(String value, long timeLast) {
		if(value.equals(k500)){
			this.timeLast500k = timeLast;
		} else if(value.equals(m1)){
			this.timeLast1m = timeLast;
		} else if(value.equals(m3)){
			this.timeLast3m = timeLast;
		}
	}
}
