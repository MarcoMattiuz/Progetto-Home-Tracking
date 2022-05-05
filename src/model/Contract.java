package model;
/**
 * 
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class Contract {
	private String type;
	private double max_kw;
	private double price_kwh;
	private double price_gmc;
	private double price_lh;
	
	/**
	 * 
	 * @param type
	 * @param max_kw
	 * @param price_kwh
	 * @param price_gmc
	 * @param price_lh
	 */
	public Contract(String type, double max_kw, double price_kwh, double price_gmc, double price_lh) {
		this.type = type;
		this.max_kw = max_kw;
		this.price_kwh = price_kwh;
		this.price_gmc = price_gmc;
		this.price_lh = price_lh;
	}
	/**
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * 
	 * @return max_kw
	 */
	public double getMax_kw() {
		return max_kw;
	}
	/**
	 * 
	 * @return price_kwh
	 */
	public double getPrice_kwh() {
		return price_kwh;
	}
	/**
	 * 
	 * @return price_gmc
	 */
	public double getPrice_gmc() {
		return price_gmc;
	}
	/**
	 * 
	 * @return price_lh
	 */
	public double getPrice_lh() {
		return price_lh;
	}

}
