/* model;

import java.util.Comparator;

import ui.Main.Crew;

public class NameComparator implements Comparator<Client>{

	@Override
	public int compare(Client o1, Client o2) {
		int comp;
		String n1 = o1.getName();
		String n2 = o2.getName();
		if(n1<n2) {
			comp = -1;
		}else if((n1>n2) {
			comp = 1;
		}else {
			comp = 0;
		}
		return comp;
	}
}
*/
