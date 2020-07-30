package restaurantapp.model;

import java.io.Serializable;

import restaurantapp.dao.BookingDao;

public class BookingLogic implements Serializable{
	private static final String[] twoTableNames = {"1","2"};
	private static final String[] fourTableNames = {"3", "4", "5"};
	private static final String[] sixTableNames = {"6"};
	private static final String[] tenTableNames = {"7"};

	private String[] searchTables;
	String name;
	String date;
	String startTime;
	String endTime;
	int numOfPeople;



	public BookingLogic(String name, String DateTimePeople) {
		parseDateTime(DateTimePeople);
		this.name = name;
		searchTables = getSearchTableArray(numOfPeople);
	}

	public boolean insertBooking() {
		BookingDao bd = new BookingDao(this.name, this.date, this.startTime, this.endTime, this.numOfPeople, this.searchTables);
		boolean result = bd.makeBooking();
		return result ? true : false;
	}

	private void parseDateTime(String dateTime) {
		System.out.println("BookingLogic:parseDateTime");
		String[] list = dateTime.split("_");
		this.date = list[0] + "-" + list[1] + "-" + list[2];

		// 分が一桁なら00表示にする
		if(Integer.parseInt(list[4]) < 10){
			list[4] = list[4] + "0";
		}

		this.startTime = list[3] + ":" + list[4] + ":00";

		// 2時間後を設定する
		this.endTime =  String.valueOf(Integer.parseInt(list[3]) + 2) + ":" + list[4] + ":00";
		this.numOfPeople = Integer.parseInt(list[5]);
	}

	private String[] getSearchTableArray(int numberOfPeople) {
		switch(numberOfPeople) {
		case 1:
		case 2:
			return twoTableNames;
		case 3:
		case 4:
			return fourTableNames;
		case 5:
		case 6:
			return sixTableNames;
		case 7:
		case 8:
		case 9:
		case 10:
			return tenTableNames;
		default:
			return null;
		}
	}


	public String[] getSearchTables() {
		return searchTables;
	}

	public void setSearchTables(String[] searchTables) {
		this.searchTables = searchTables;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	public int getNumOfPeople() {
		return numOfPeople;
	}



	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}



	public static String[] getTwotablenames() {
		return twoTableNames;
	}



	public static String[] getFourtablenames() {
		return fourTableNames;
	}



	public static String[] getSixtablenames() {
		return sixTableNames;
	}



	public static String[] getTentablenames() {
		return tenTableNames;
	}



}
