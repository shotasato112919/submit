package restaurantapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class VacantData implements Serializable{
	private Map<LocalDateTime, Integer> dataMap;
	private Map<String, String> displayData;
	private String[] bookingTable;
	private LocalDateTime bookingLdt;
	private String bookingRequestTime;	// フォームから送られてきたメッセージ  HHmm形式
	private int numberOfPeople;	// 予約人数
	private String name;

	public VacantData() {}


	public boolean parseVacantData() {
		if(this.dataMap != null) {
			displayData = new TreeMap<String, String>();
			for( Map.Entry<LocalDateTime, Integer> entry : this.dataMap.entrySet() ) {
				LocalDateTime ldt = entry.getKey();
				String displayDate = ldt.getDayOfMonth() + "日(" + parseWeekDay(ldt) + ")";
				String displayVacant = parseVacant(entry.getValue());
				displayData.put(displayDate, displayVacant);
			}
			return true;
		}
		return false;
	}

	public String parseVacant(int num) {
		String vacant = "◎";
		if( num == 1 ) {
			vacant = "△";
			return vacant;
		} else if( num <= 0 ) {
			vacant = "×";
			return vacant;
		}
		return vacant;
	}

	public String parseWeekDay(LocalDateTime ldt) {
		String weekDay;
		switch(ldt.getDayOfWeek()) {
			case MONDAY:
				weekDay = "月";
				break;
			case TUESDAY:
				weekDay = "火";
				break;
			case WEDNESDAY:
				weekDay = "水";
				break;
			case THURSDAY:
				weekDay = "木";
				break;
			case FRIDAY:
				weekDay = "金";
				break;
			case SATURDAY:
				weekDay = "土";
				break;
			case SUNDAY:
				weekDay = "日";
				break;
			default:
				weekDay = "不明";
				break;
		}
		return weekDay;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<LocalDateTime, Integer> getDataMap() {
		return dataMap;
	}



	public void setDataMap(Map<LocalDateTime, Integer> dataMap) {
		this.dataMap = dataMap;
	}



	public Map<String, String> getDisplayData() {
		return displayData;
	}

	public void setDisplayData(Map<String, String> displayData) {
		this.displayData = displayData;
	}

	public String[] getBookingTable() {
		return bookingTable;
	}

	public void setBookingTable(String[] bookingTable) {
		this.bookingTable = bookingTable;
	}

	public LocalDateTime getBookingLdt() {
		return bookingLdt;
	}

	public void setBookingLdt(LocalDateTime bookingLdt) {
		this.bookingLdt = bookingLdt;
	}

	public String getBookingRequestTime() {
		return bookingRequestTime;
	}

	public void setBookingRequestTime(String bookingRequestTime) {
		this.bookingRequestTime = bookingRequestTime;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

}
