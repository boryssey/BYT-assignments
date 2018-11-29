package b_Money;

public class Currency {
	private String name;
	private Double rate;
	
	/**
	 * New Currency
	 * The rate argument of each currency indicates that Currency's "universal" exchange rate.
	 * @param name The name of this Currency
	 * @param rate The exchange rate of this Currency
	 */
	Currency (String name, Double rate) {
		this.name = name;
		this.rate = rate;
	}

	/** Convert an amount of this Currency to its value in the general "universal currency"
	 * 
	 * @param amount An amount of cash of this currency.
	 * @return The value of amount in the "universal currency"
	 */
	public Integer universalValue(Integer amount) {
		return (int) (amount * rate);
	}

	/** Get the name of this Currency.
	 * @return name of Currency
	 */
	public String getName() {
		return name;
	}
	
	/** Get the rate of this Currency.
	 * 
	 * @return rate of this Currency
	 */
	public Double getRate() {
		return rate;
	}
	
	/** Set the rate of this currency.
	 * 
	 * @param rate New rate for this Currency
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	/** Convert an amount from another Currency to an amount of this Currency
	 * 
	 * @param amount Amount of the other Currency
	 * @param othercurrency The other Currency
	*/
	public Integer valueInThisCurrency(Integer amount, Currency othercurrency) {
		return (int) (othercurrency.universalValue(amount) / rate);
		
	}
}
