package com.hc.rest.dto.charts;

public class Series {

	public Series() { }
	
//	private List<Bubble> data;
//
//	public List<Bubble> getData() {
//		return data;
//	}
//
//	public void setData(List<Bubble> data) {
//		this.data = data;
//	}
	
	private String bubbles;

	public String getBubbles() {
		return bubbles;
	}

	public void setBubbles(String data) {
		this.bubbles = data;
	}
	
	public void fakeLoad() {	
//		data = new ArrayList<Bubble>();
//		data.add(new Bubble(9, 81, 63));
//		data.add(new Bubble(98, 5, 89));
//		data.add(new Bubble(51, 50, 73));
//		data.add(new Bubble(41, 22, 14));
//		data.add(new Bubble(58, 24, 20));
//		data.add(new Bubble(78, 37, 34));
//		data.add(new Bubble(55, 56, 53));
//		data.add(new Bubble(18, 45, 70));
//		data.add(new Bubble(42, 44, 28));
//		data.add(new Bubble(3, 52, 59));
//		data.add(new Bubble(31, 18, 97));
//		data.add(new Bubble(79, 91, 63));
//		data.add(new Bubble(93, 23, 23));
//		data.add(new Bubble(44, 83, 22));	
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append("[9, 81, 63],");
		buffer.append("[98, 5, 89],");
		buffer.append("[51, 50, 73],");
		buffer.append("[41, 22, 14],");
		buffer.append("[58, 24, 20],");
		buffer.append("[78, 37, 34],");
		buffer.append("[55, 56, 53],");
		buffer.append("[18, 45, 70],");
		buffer.append("[42, 44, 28],");
		buffer.append("[3, 52, 59],");
		buffer.append("[31, 18, 97],");
		buffer.append("[79, 91, 63],");
		buffer.append("[93, 23, 23],");
		buffer.append("[44, 83, 22]");
		buffer.append("]");
		
		this.bubbles = buffer.toString();
	}

}
