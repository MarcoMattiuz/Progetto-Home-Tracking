package model;


public class Consumption {

	/** The daily consumption kwh. */
	protected double dailyConsumption_Kwh;
	
	/** The present consumption kwh. */
	protected double presentConsumption_Kwh;
	
	/** The daily consumption gmc. */
	protected double dailyConsumption_Gmc;
	
	/** The daily consumption lh. */
	protected double dailyConsumption_Lh;
	
	public Consumption() {
		this.dailyConsumption_Kwh = 0;
		this.presentConsumption_Kwh = 0;
		this.dailyConsumption_Gmc = 0;
		this.dailyConsumption_Lh = 0;
	}
	
	/**
	 * Round avoid. arrotonda un double in base ai posti decimali inseriti
	 *
	 * @param value the value
	 * @param places the places
	 * @return Math.round(value * scale) / scale
	 */
	protected double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
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
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}

	/**
	 * Adds the to daily consumption khw.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Take from daily consumption khw.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromDailyConsumptionKhw(double consumption) {
		this.dailyConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
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
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Adds the to present consumption kwh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void addToPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh += consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
	}
	
	/**
	 * Take from present consumption kwh.
	 *
	 * @param consumption the consumption
	 */
	public synchronized void takeFromPresentConsumptionKwh(double consumption) {
		this.presentConsumption_Kwh -= consumption;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Kwh, 3);
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
	 * @param dailyConsumption_Gmc the new daily consumption gmc
	 */
	public synchronized void setDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc = dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);
	}
	
	/**
	 * Adds the to daily consumption gmc.
	 *
	 * @param dailyConsumption_Gmc the daily consumption gmc
	 */
	public synchronized void addToDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc += dailyConsumption_Gmc;
		dailyConsumption_Gmc = roundAvoid(dailyConsumption_Gmc, 3);
	}
	
	/**
	 * Take from daily consumption gmc.
	 *
	 * @param dailyConsumption_Gmc the daily consumption gmc
	 */
	public synchronized void takeFromDailyConsumption_Gmc(double dailyConsumption_Gmc) {
		this.dailyConsumption_Gmc -= dailyConsumption_Gmc;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Gmc, 3);

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
	 * @param dailyConsumption_Lh the new daily consumption lh
	 */
	public synchronized void setDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh = dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	
	
	/**
	 * Adds the to daily consumption lh.
	 *
	 * @param dailyConsumption_Lh the daily consumption lh
	 */
	public synchronized void addToDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh += dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	
	/**
	 * Take from daily consumption lh.
	 *
	 * @param dailyConsumption_Lh the daily consumption lh
	 */
	public synchronized void takeFromDailyConsumption_Lh(double dailyConsumption_Lh) {
		this.dailyConsumption_Lh -= dailyConsumption_Lh;
		dailyConsumption_Kwh = roundAvoid(dailyConsumption_Lh, 3);

	}
	
	public String getPresentConsumptio() {
		return "Present Consumption: " + this.getPresentConsumptionKwh() +"kW/h \n";
	}
	
	/**
	 * Gets the daily consumption.
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
