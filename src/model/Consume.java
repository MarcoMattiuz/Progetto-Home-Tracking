package model;

public class Consume {
	private double kwh; 
	private double gmc;
	private double lh;
	
	
	public Consume(double kwh, double gmc, double lh) {
		this.kwh = kwh;
		this.gmc = gmc;
		this.lh = lh;
	}
	
	public double getKwh() {
		return kwh;
	}
	public double getGmc() {
		return gmc;
	}
	public double getLh() {
		return lh;
	}
	
	
		
}
