package at.tuwien.ss17.dp.lab3.datascience.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataWrapper implements Serializable{
	
	private static final long serialVersionUID = 3979897011346104021L;
	
	List<Data> data;

	public DataWrapper(Data apiData) {
		data = new ArrayList<Data>();
		data.add(apiData);
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	

	
	

}
