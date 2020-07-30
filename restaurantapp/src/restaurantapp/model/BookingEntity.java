package restaurantapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BookingEntity implements Serializable {
	int bookingId;
	String bookingName;
	int numberOfPeople;
	int bookingTableTaku;
	LocalDateTime bookingDate;
	int courseMeal;
	LocalDateTime startTime;
	LocalDateTime endTime;

	public BookingEntity() {

	}

	public BookingEntity(
			int id,
			String bookingName,
			int numberOfPeople,
			int bookingTableTaku,
			LocalDateTime bookingDate,
			int courseMeal,
			LocalDateTime startTime,
			LocalDateTime endTime
			) {
		this.bookingId = id;
		this.bookingName = bookingName;
		this.numberOfPeople = numberOfPeople;
		this.bookingTableTaku = bookingTableTaku;
		this.bookingDate = bookingDate;
		this.courseMeal = courseMeal;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getBookingTableTaku() {
		return bookingTableTaku;
	}

	public void setBookingTableTaku(int bookingTableTaku) {
		this.bookingTableTaku = bookingTableTaku;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getDisplayBookingDate() {
		return  bookingDate.getYear() + "-" + bookingDate.getMonthValue() + "-" + bookingDate.getDayOfMonth();
	}

	public int getCourseMeal() {
		return courseMeal;
	}

	public void setCourseMeal(int courseMeal) {
		this.courseMeal = courseMeal;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public String getDisplayStartTime() {
		int hour = startTime.getHour();
		String minuts = startTime.getMinute() < 10 ? "0" + startTime.getMinute() : String.valueOf(startTime.getMinute());

		return hour + ":" + minuts;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getDisplayEndTime() {
		int hour = endTime.getHour();
		String minuts = endTime.getMinute() < 10 ? "0" + endTime.getMinute() : String.valueOf(endTime.getMinute());

		return hour + ":" + minuts ;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingName() {
		return bookingName;
	}
	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
}
