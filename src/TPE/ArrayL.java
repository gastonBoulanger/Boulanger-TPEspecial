package TPE;

import java.util.ArrayList;
import java.util.Date;

public class ArrayL implements IList{
	private User[] users = new User[10000];
	private int lastInsert = 0;
	private Boolean isSort;
	private Boolean exist = false;

	public void insertUsers(ArrayList<User> users) {
		for(int i = 0; i < users.size(); i++){
			Date initU = new Date();
			lastInsert++;
			if(lastInsert >= this.users.length){
				duplicateArrayLength();
			}
			this.users[lastInsert] = users.get(i);
			Date end = new Date();
			long result = end.getTime() - initU.getTime();
			saveResult(this.users[i], lastInsert, false, result);
		}
		isSort = false;
	}
	
	@Override
	public void addUsers(ArrayList<User> users) {
		for (int i = 0; i < users.size(); i++) {
			lastInsert++;
			if(lastInsert >= this.users.length){
				duplicateArrayLength();
			}
			this.users[i] = users.get(i);
		}
		isSort = false;
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
	
	public void searchUsersSort(ArrayList<User> usersQuery) {
		if(!isSort){
			MergeSort ms = new MergeSort();
			ms.sort(users);
			isSort = true;
		}
		for(User user : usersQuery){
			Date init = new Date();
			exist = false;
			boolean exists = searchUser(user, 0, lastInsert);
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			int size = users.length;
			saveResult(user, size, exists, result);
		}
	}
	
	private Boolean searchUser(User user, int min, int max){
		int tot = min + max;
		int mid = tot/2;
		int resultUser = users[mid].getUserId().compareTo(user.getUserId());
		if(users[mid].getUserId().equals(user.getUserId())){
			exist = true;
		}
		else if(!(min >= max)){
			if(resultUser < 0){
				searchUser(user, mid + 1, max);
			}
			else if(resultUser > 0){
				searchUser(user, min, mid);
			}
		}
		return exist;
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
