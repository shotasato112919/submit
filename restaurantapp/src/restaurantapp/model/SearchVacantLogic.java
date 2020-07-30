package restaurantapp.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import restaurantapp.dao.SearchVacantDao;

public class SearchVacantLogic {
	private static final String[] twoTableNames = {"1","2"};
	private static final String[] fourTableNames = {"3", "4", "5"};
	private static final String[] sixTableNames = {"6"};
	private static final String[] tenTableNames = {"7"};
	private static final int searchPeriodDays = 7;
	private String[] searchTables;
	private LocalDateTime searchLdt;
	private VacantData vacantData;

	public SearchVacantLogic(int numOP, String fTime) {
		searchTables = getSearchTableArray(numOP);
		searchLdt = getLocalDateTimeFromForm(fTime);

		vacantData = new VacantData();
		vacantData.setNumberOfPeople(numOP);
		vacantData.setBookingRequestTime(fTime);
		vacantData.setBookingTable(searchTables);
		vacantData.setBookingLdt(searchLdt);
	}

	public VacantData searchData() {
		System.out.println("SearchVacantLogic:searchData");
		SearchVacantDao svd = new SearchVacantDao(searchTables, searchLdt, searchPeriodDays );
		Map<LocalDateTime, Integer> map = svd.countVacant();
		if(map == null)
			return null;

		int numberOfSeat = searchTables.length;
		for( Map.Entry<LocalDateTime, Integer> entry : map.entrySet()) {
			int i = map.get(entry.getKey());
			map.replace(entry.getKey(), numberOfSeat - i);
		}

		vacantData.setDataMap(map);
		if(vacantData.parseVacantData()) {
			return vacantData;
		}

		return null;
	}

	public LocalDateTime getSearchLdt() {
		return searchLdt;
	}

	public String[] getSearchTablesArray() {
		return searchTables;
	}

	// 検索するテーブル（座席）リストを返すメソッド
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

	// フォームから取得した時間形式"hhmm"を「今日のhh:mm」のLocalDateTimeに変換するメソッド
	private static LocalDateTime getLocalDateTimeFromForm(String rTime) {

		String[] split = rTime.split("");
		String rHour = split[0] + split[1];
		String rMin = split[2] + split[3];

		LocalDateTime ldt = LocalDateTime.now().with(LocalTime.of(Integer.parseInt(rHour), Integer.parseInt(rMin)));

		return ldt;
	}
}
