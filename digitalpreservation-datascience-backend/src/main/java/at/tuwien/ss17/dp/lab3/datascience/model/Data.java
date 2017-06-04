package at.tuwien.ss17.dp.lab3.datascience.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{

	private static final long serialVersionUID = 3981528081984652454L;

	public List<String> series;
	public List<String> labels;
	public List<BigDecimal[]> data;
	

	public Data(List series, List labels, List<BigDecimal[]> data) {
		this.series=series;
		this.labels=labels;
		this.data=data;
	}
	public List<String> getSeries() {
		return series;
	}
	public List<String> getLabels() {
		return labels;
	}
	public List<BigDecimal[]> getData() {
		return data;
	}
	public void setSeries(List<String> series) {
		this.series = series;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public void setData(List<BigDecimal[]> data) {
		this.data = data;
	}
	
}
