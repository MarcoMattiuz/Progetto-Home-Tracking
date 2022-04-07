package model;

public class Contract {
	private String type;
	private double max_kw;
	private double price_kwh;
	private double price_gmc;
	private double price_lh;
	
	
	public Contract(String type, double max_kw, double price_kwh, double price_gmc, double price_lh) {
		this.type = type;
		this.max_kw = max_kw;
		this.price_kwh = price_kwh;
		this.price_gmc = price_gmc;
		this.price_lh = price_lh;
	}
	public String getType() {
		return type;
	}
	public double getMax_kw() {
		return max_kw;
	}
	public double getPrice_kwh() {
		return price_kwh;
	}
	public double getPrice_gmc() {
		return price_gmc;
	}
	public double getPrice_lh() {
		return price_lh;
	}

}
