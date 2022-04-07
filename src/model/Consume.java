package model;

public class Consume {
	private double kwh; 
	private double gmc;
	private double lh;
	private Contract contract;
	
	
	public Consume(double kwh, double gmc, double lh, Contract contract) {
		this.kwh = kwh;
		this.gmc = gmc;
		this.lh = lh;
		this.contract = contract;
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
	public Contract getContract() {
		return contract;
	}
	
	
		
}
