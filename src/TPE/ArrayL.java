package TPE;

import java.util.ArrayList;
import java.util.Date;

public class ArrayL implements IList{
	private User[] users = new User[10000];
	private int lastInsert;

	public void insertUsers(ArrayList<User> users) {
		for(int i = 0; i < users.size(); i++){
			Date initU = new Date();
			lastInsert = lastInsert + i;
			if(lastInsert >= this.users.length){
				duplicateArrayLength();
			}
			this.users[lastInsert] = users.get(i);
			Date end = new Date();
			long result = end.getTime() - initU.getTime();
			saveResult(this.users[i], lastInsert, false, result);
		}
	}
	
	@Override
	public void addUsers(ArrayList<User> users) {
		for (int i = 0; i < users.size(); i++) {
			
			if(i >= this.users.length){
				duplicateArrayLength();
			}
			lastInsert = i;
			this.users[i] = users.get(i);
			
		}
		
	}
	private void duplicateArrayLength(){
		User[] usersTemp = new User[this.users.length*2]; 
		for (int i = 0; i < this.users.length; i++) {
			usersTemp[i] = this.users[i];
		}
		users = usersTemp;
	}

	@Override
	public void searchUsers(ArrayList<User> usersQuery) {
		for (User user : usersQuery) {
			boolean found = false;
			int i = 0;
			Date init = new Date();
			while(!found && (i < users.length) && users[i] != null){
				if(users[i].getUserId().equals(user.getUserId())){
					found = true;
				}
				i++;
			}
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			int size = users.length;
			saveResult(user, size, found, result);
		}
	}

	@Override
	public void saveResult(User user, int size, boolean exists, long result) {
		// TODO Auto-generated method stub
		if(size <= 640000){
			user.setExists("500k", exists);
			user.setTimeArray("500k", result);
		}
		else if( size <= 1280000){
			user.setExists("1m", exists);
			user.setTimeArray("1m",result);
		}
		else if( size > 3000000){
			user.setExists("3m", exists);
			user.setTimeArray("3m",result);
		}
	}
}
