package model;


// TODO: Auto-generated Javadoc
/**
 * The Class Consumption.
 */
public class Consumption {

	/** The daily consumption kwh. */
	protected double dailyConsumption_Kwh;
	
	/** The present consumption kwh. */
	protected double presentConsumption_Kwh;
	
	/** The daily consumption gmc. */
	protected double dailyConsumption_Gmc;
	
	/** The daily consumption lh. */
	protected double dailyConsumption_Lh;
	
	/**
	 * Instantiates a new consumption.
	 */
	public Consumption() {
		this.dailyConsumption_Kwh = 0;
		this.presentConsumption_Kwh = 0;
		this.dailyConsumption_Gmc = 0;
		this.dailyConsumption_Lh = 0;
	}
	
	/**
	 * arrotonda un double alla quarta cifra decimale
	 *
	 * @param value the value
	 * @return Math.round(value * scale) / scale
	 */
	protected double round(double value) {
		double ret =Math.round(value*10000.0)/10000.0;
		return ret;
	}
	
	/**
	 * Gets the daily consumption kwh.
	 *
	 * @return dailyConsumption_Kwh
	 */
	public synchronized double getDailyConsumptionKwh() {
		return dailyConsumption_Kwh;
	}

	/**
	 * Sets the daily consumption kwh.
	 *
	 * @param consumption the new daily consumption kwh
	 */
	public synchronized void setDailyConsumptionKwh(double consumption) {
		this.dailyConsumption_Kwh = consumption;
		dailyConsumption_Kwh = round(dailyConsumption_Kwh);
	}

	/**
	 * Adds the to daily consumption khw.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh += consumption;
		dailyConsumption_Kwh = round(dailyConsumption_Kwh);
	}
	
	/**
	 * Take from daily consumption khw.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = round(dailyConsumption_Kwh);
	}
	
	/**
	 * Gets the present consumption kwh.
	 *
	 * @return presentConsumption_Kwh
	 */
	public synchronized double getPresentConsumptionKwh() {
		return presentConsumption_Kwh;

	}
	
	/**
	 * Sets the present consumption kwh.
	 *
	 * @param consumption the new present consumption kwh
	 */
	public synchronized void setPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh = consumption;
		presentConsumption_Kwh = round(presentConsumption_Kwh);
	}
	
	/**
	 * Adds the to present consumption kwh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh += consumption;
		presentConsumption_Kwh = round(presentConsumption_Kwh);
	}
	
	/**
	 * Take from present consumption kwh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh -= consumption;
		presentConsumption_Kwh = round(presentConsumption_Kwh);
	}
	
	/**
	 * Gets the daily consumption gmc.
	 *
	 * @return dailyConsumption_Gmc
	 */
	public synchronized double getDailyConsumption_Gmc() {
		return dailyConsumption_Gmc;
	}
	
	/**
	 * Sets the daily consumption gmc.
	 *
	 * @param consumption the new daily consumption gmc
	 */
	public synchronized void setDailyConsumption_Gmc(double consumption) {
		this.dailyConsumption_Gmc = consumption;
		dailyConsumption_Kwh = round(dailyConsumption_Gmc);
	}
	
	/**
	 * Adds the to daily consumption gmc.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToDailyConsumption_Gmc(double consumption) {
		this.dailyConsumption_Gmc += consumption;
		dailyConsumption_Gmc = round(dailyConsumption_Gmc);
	}
	
	/**
	 * Take from daily consumption gmc.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromDailyConsumption_Gmc(double consumption) {
		this.dailyConsumption_Gmc -= consumption;
		dailyConsumption_Gmc= round(dailyConsumption_Gmc);

	}
	
	/**
	 * Gets the daily consumption lh.
	 *
	 * @return dailyConsumption_Lh
	 */
	public synchronized double getDailyConsumption_Lh() {
		return dailyConsumption_Lh;
	}
	
	/**
	 * Sets the daily consumption lh.
	 *
	 * @param consumption the new daily consumption lh
	 */
	public synchronized void setDailyConsumption_Lh(double consumption) {
		this.dailyConsumption_Lh = consumption;
		dailyConsumption_Lh = round(dailyConsumption_Lh);

	}
	
	
	/**
	 * Adds the to daily consumption lh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToDailyConsumption_Lh(double consumption) {
		this.dailyConsumption_Lh += consumption;
		dailyConsumption_Lh = round(dailyConsumption_Lh);

	}
	
	/**
	 * Take from daily consumption lh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromDailyConsumption_Lh(double consumption) {
		this.dailyConsumption_Lh -= consumption;
		dailyConsumption_Lh = round(dailyConsumption_Lh);

	}
	
	/**
	 * ritorna una stringa con la presentConsumption
	 *
	 * @return the present consumption
	 */
	public String getPresentConsumption() {
		return "Present Consumption: " + this.getPresentConsumptionKwh() +"kW/h \n";
	}
	
	/**
	 * ritorna una stringa con i dailyConsumption
	 *
	 * @return the daily consumption
	 */
	public String getDailyConsumption() {
		return "Daily Consumption: \n"
				+ "Electricity: " + this.getDailyConsumptionKwh() + " kW/h \n"
						+ " Gas: " + this.getDailyConsumption_Gmc() + " Gm/h \n"
								+ " Water: " + this.getDailyConsumption_Lh() + " l/h";
	
	}
}
