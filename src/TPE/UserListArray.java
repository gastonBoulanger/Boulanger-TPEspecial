package TPE;

public class UserListArray implements IUserList {

	@Override
	public void importUserList(User[] users) {
		// TODO Auto-generated method stub
		MySimpleLinkedList msll = new MySimpleLinkedList();
		for(User userSt : users){
			//msll.add(userSt);
		}
	}

	@Override
	public void addUsers(User[] users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchUsers(User[] users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveResult() {
		// TODO Auto-generated method stub
		
	}

}
