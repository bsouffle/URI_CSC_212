import java.util.Calendar;

public class Date{

	private static char SEPARATOR = '/';

	private byte mMonth;
	private byte mDay;
	private int mYear;

	/*
	 * Empty constructor for the recovery of the current day date
	 */
	public Date(){ 
		final Calendar calendar = Calendar.getInstance();
        mMonth = (byte) (calendar.get(Calendar.MONTH) + 1);
        mYear = calendar.get(Calendar.YEAR);
        mDay = (byte) calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/*
	 * Constructor with 3 arguments for the month, day and year of a date
	 */
	public Date(int month, int day, int year){
		setMonth(month);
		setDay(day);
		setYear(year);
	}
	
	
	/*
	 * Public getter to get the year of the date
	 */
	public byte getDay(){
		return mDay;
	}
	
	/*
	 * Public getter to get the year of the date
	 */
	public byte getMonth(){
		return mMonth;
	}
	
	/*
	 * Public getter to get the year of the date
	 */
	public int getYear(){
		return mYear;
	}

	
	/*
	 * Private setter to set the day of a date
	 */
	private void setDay(int day){
		if(day <= getLastDayOfTheMonth(mMonth, mYear)) mDay = (byte) day;
		else throw new IllegalArgumentException();
	}
	
	/*
	 * Private setter to set the month of a date
	 */
	private void setMonth(int month){
		if(month>= 1 && month <= 12) mMonth = (byte) month;
		else throw new IllegalArgumentException();
	}
	
	/*
	 * Private setter to set the year of a date (no verification needed)
	 */
	private void setYear(int year){
		mYear = year;
	}
	
	/*
	 * Private method to add a day to the date
	 */
	private void addDay(){
		setDay(mDay + 1);
	}
	
	/*
	 * Private method to add a month to the date
	 */
	private void addMonth(){
		setMonth(mMonth + 1);
	}
	
	/*
	 * Private method to add a year to the date
	 */
	private void addYear(){
		setYear(mYear + 1);
	}
	
	/*
	 * Static method to check if a given year is a leap year
	 */
	public static boolean isLeapYear(int year){
		if(((year % 4 == 0) && year % 100 != 0) || year % 400 == 0){
			return true;
		}
		
		return false;
	}
	
	/*
	 * Static method to get the last day of a month (associated to a specific year)
	 */
	public static int getLastDayOfTheMonth(byte month, int year){
		switch(month){
			case 2:
				return isLeapYear(year) ? 29 : 28;
			case 4: case 6: case 9: case 11:
				return 30;
			default:
				return 31;
		}
	}
	
	/*
	 * Private method which calls the static getLastDayOfTheMonth method with the params associated with the date
	 * And check if the result corresponds to the day of the date to know if the current day is the last day of its month
	 */
	private boolean isLastDayOfTheMonth(){
		return mDay == getLastDayOfTheMonth(mMonth, mYear);
	}
	
	/*
	 * Private method used to check if the date corresponds to the last day of a year (12/31/XXXX)
	 */
	private boolean isLastDayOfTheYear(){
		return mDay == 31 && mMonth == 12;
	}
	
	/*
	 * Public method to advance the date by one day
	 */
	public void advance(){
		if(isLastDayOfTheYear()){
			setDay(1);
			setMonth(1);
			addYear();
		}
		else if(isLastDayOfTheMonth()){
			setDay(1);
			addMonth();
		}
		else{
			addDay();
		}
	}
	
	/*
	 * Representation of the date object as a readable string
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString() {
        return new StringBuilder()
                .append(mMonth)
                .append(SEPARATOR)
                .append(mDay)
                .append(SEPARATOR)
                .append(mYear)
                .toString();
    }
	
	/*
	 * Public method used to display the string representation of the date directly in the console
	 */
	public void print(){
		System.out.println(toString());
	}
}