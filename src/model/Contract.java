package model;
// TODO: Auto-generated Javadoc

/**
 * The Class Contract.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class Contract {
	
	/** The type. */
	private String type;
	
	/** The max kw. */
	private double max_kw;
	
	/** The price kwh. */
	private double price_kwh;
	
	/** The price gmh. */
	private double price_gmh;
	
	/** The price lh. */
	private double price_lh;
	
	/**
	 * Instantiates a new contract.
	 *
	 * @param type the type
	 * @param max_kw the max kw
	 */
	public Contract(String type, double max_kw) {
		this.type = type;
		this.max_kw = max_kw;
		this.price_kwh = 0;
		this.price_gmh = 0;
		this.price_lh = 0;
	}
	
	/**
	 * Sets the prices.
	 * 
	 * @param price_kwh the price kwh
	 * @param price_gmh the price gmh
	 * @param price_lh the price lh
	 */
	public void setPrices(double price_kwh, double price_gmh,double price_lh) {
		this.price_kwh = price_kwh;
		this.price_gmh = price_gmh;
		this.price_lh = price_lh;
	}



	/**
	 * Gets the type.
	 *
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the max kw.
	 *
	 * @return max_kw
	 */
	public double getMax_kw() {
		return max_kw;
	}
	
	/**
	 * Gets the price kwh.
	 *
	 * @return price_kwh
	 */
	public double getPrice_kwh() {
		return price_kwh;
	}
	
	/**
	 * Gets the price gmh.
	 *
	 * @return price_gmc
	 */
	public double getPrice_gmh() {
		return price_gmh;
	}
	
	/**
	 * Gets the price lh.
	 *
	 * @return price_lh
	 */
	public double getPrice_lh() {
		return price_lh;
	}

}
