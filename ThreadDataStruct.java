package tiaa;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ThreadDataStruct {
	List<String> list = new ArrayList<String>();

	public void add(String s) {
		list.add(s);
	}

	public List<String> getList() {
		return Collections.unmodifiableList(list);

	}
}
