package TPE;

public class MergeSort {

	private User[] users;
	private User[] aux;
	private int n;

	public void sort(User[] users) {
		this.users = users;
		n = users.length;
		this.aux = new User[n];
		mergesort(0, n - 1);
	}

	private void mergesort(int min, int max) {
		if (min < max) {
			int mid = (min + max) / 2;
			mergesort(min, mid);
			mergesort(mid + 1, max);
			merge(min, mid, max);
		}
	}

	private void merge(int min, int mid, int max) {
		try{
			for (int i = min; i <= max; i++) {
				aux[i] = users[i];
			}
			int i = min;
			int j = mid + 1;
			int k = min;
			while (i <= mid && j <= max) {
				if (aux[i].getUserId() <= aux[j].getUserId()) {
					users[k] = aux[i];
					i++;
				} else {
					users[k] = aux[j];
					j++;
				}
				k++;
			}

			while (i <= mid) {
				users[k] = aux[i];
				k++;
				i++;
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}