package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserArray implements IUserList{
	private User[] users = new User[10000]; 
	


	@Override
	public void addUsers(ArrayList<User> users) {
		for (int i = 0; i < users.size(); i++) {
			if(i >= this.users.length){
				duplicateArrayLength();
			}
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
			user.setExists(false);
			boolean found = false;
			int i = 0;
			Date init = new Date();
			while(!found && (i < users.length)){
				if(users[i].getUserId().equals(user.getUserId())){
					found = true;
					user.setExists(true);
				}
			}
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			user.setTimeArray(result);
		}
	}

	@Override
	public void saveResult() {
		// TODO Auto-generated method stub
		
	}

}
