package model;
/**
 * 
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class Consume {
	private double kwh; 
	private double gmc;
	private double lh;
	
	/**
	 * 
	 * @param kwh
	 * @param gmc
	 * @param lh
	 */
	public Consume(double kwh, double gmc, double lh) {
		this.kwh = kwh;
		this.gmc = gmc;
		this.lh = lh;
	}
	/**
	 * 
	 * @return kwh
	 */
	public double getKwh() {
		return kwh;
	}
	/**
	 * 
	 * @return gmc
	 */
	public double getGmc() {
		return gmc;
	}
	/**
	 * 
	 * @return lh
	 */
	public double getLh() {
		return lh;
	}
	
	
		
}
