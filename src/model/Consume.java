package model;


/**
 * The Class Consume.
 *
 * @author Marco&Davide <br>
 * {@docRoot}
 * @version 4.21.0
 */
public class Consume {
	
	/** The kwh. */
	private double kwh; 
	
	/** The gmc. */
	private double gmc;
	
	/** The lh. */
	private double lh;
	
	/**
	 * Instantiates a new consume.
	 *
	 * @param kwh the kwh
	 * @param gmc the gmc
	 * @param lh the lh
	 */
	public Consume(double kwh, double gmc, double lh) {
		this.kwh = kwh;
		this.gmc = gmc;
		this.lh = lh;
	}
	
	/**
	 * Gets the kwh.
	 *
	 * @return kwh
	 */
	public double getKwh() {
		return kwh;
	}
	
	/**
	 * Gets the gmc.
	 *
	 * @return gmc
	 */
	public double getGmc() {
		return gmc;
	}
	
	/**
	 * Gets the lh.
	 *
	 * @return lh
	 */
	public double getLh() {
		return lh;
	}
	
	
		
}
