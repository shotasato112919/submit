package restaurantapp.model;

import java.time.LocalDateTime;
import java.util.List;

import restaurantapp.dao.SearchBookingDao;

public class BookingListLogic {
	LocalDateTime currentDateTime;


	public BookingListLogic() {
		currentDateTime = LocalDateTime.now();
	}

	public List<BookingEntity> getBookingList() {
		SearchBookingDao sbd = new SearchBookingDao();
		List<BookingEntity> bookingEntityList = sbd.getBookingEntityList(currentDateTime);

		return bookingEntityList;
	}
}
