package estateapp.model.logic;

import java.util.ArrayList;
import java.util.List;

import estateapp.dao.SearchDao;
import estateapp.model.entity.RentalProperty;

public class RentalPropertySearchLogic {
	int minRentFeeYen;
	int maxRentFeeYen;
	boolean includingManagementFee;
	boolean hasNoDeposit;
	boolean hasNoKeyMoney;
	int minAreaSquareMeter;
	int maxAreaSquareMeter;
	List<Integer> layoutSearchList;
	int walkingTimeMin;
	int ageYear;
	boolean isSeparatedBathToilet;
	boolean isUpperSecondFloor;
	boolean hasWasherSpace;
	boolean hasAircon;
	boolean hasParking;
	boolean hasAutoLock;
	boolean hasReheat;
	boolean canHavePet;

	List<RentalProperty> rpList;

	public RentalPropertySearchLogic(
		// 賃料
		String minRentFeeYen, String maxRentFeeYen, String includingManagementFee, String hasNoDeposit,
		String hasNoKeyMoney,
		// 面積
		String minAreaSquareMeter, String maxAreaSquareMeter,
		// 間取り ワンルーム 1K 1DK 1LDK 2K 2DK 2LDK 3K 3DK 3LDK 4K 4DK 4LDK 5K以上
		String isOneRoom, String is1K, String is1DK, String is1LDK, String is2K, String is2DK, String is2LDK,
		String is3K, String is3DK, String is3LDK, String is4K, String is4DK, String is4LDK, String is5K,
		// 徒歩
		String walkingTimeMin,
		// 築年数
		String ageYear,
		// こだわりの条件
		String isSeparatedBathToilet, String isUpperSecondFloor,
		String hasWasherSpace, String hasAircon, String hasParking, String hasAutoLock,
		String hasReheat, String canHavePet
		) {

			// 賃貸料
			this.minRentFeeYen = (int) (Double.parseDouble(minRentFeeYen) * 10000);
			this.maxRentFeeYen = (int) (Double.parseDouble(maxRentFeeYen) * 10000);
			if(this.maxRentFeeYen == 0)
				this.maxRentFeeYen = 1000000;

			// 管理費込みフラグ
			this.includingManagementFee  = includingManagementFee != null ? true : false;
			// 敷金なしフラグ
			this.hasNoDeposit = hasNoDeposit != null ? true : false;
			// 礼金なしフラグ
			this.hasNoKeyMoney = hasNoKeyMoney != null ? true : false;
			// 面積
			this.minAreaSquareMeter = Integer.parseInt(minAreaSquareMeter);
			this.maxAreaSquareMeter = Integer.parseInt(maxAreaSquareMeter);

			if(this.maxAreaSquareMeter == 0)
				this.maxAreaSquareMeter = 200;
			// 間取り
			layoutSearchList = new ArrayList<Integer>();
			if(isOneRoom != null) {
				layoutSearchList.add(0);
			}
			if(is1K != null) {
				layoutSearchList.add(1);
			}
			if(is1DK != null) {
				layoutSearchList.add(2);
			}
			if(is1LDK != null) {
				layoutSearchList.add(3);
			}
			if(is2K != null) {
				layoutSearchList.add(4);
			}
			if(is2DK != null) {
				layoutSearchList.add(5);
			}
			if(is2LDK != null) {
				layoutSearchList.add(6);
			}
			if(is3K != null) {
				layoutSearchList.add(7);
			}
			if(is3DK != null) {
				layoutSearchList.add(8);
			}
			if(is3LDK != null) {
				layoutSearchList.add(9);
			}
			if(is4K != null) {
				layoutSearchList.add(10);
			}
			if(is4DK != null) {
				layoutSearchList.add(11);
			}
			if(is4LDK != null) {
				layoutSearchList.add(12);
			}
			if(is5K != null) {
				layoutSearchList.add(13);
			}

			// 徒歩
			this.walkingTimeMin = Integer.parseInt(walkingTimeMin);
			if(this.walkingTimeMin == 0)
				this.walkingTimeMin = 1000;

			// 築年数
			this.ageYear = Integer.parseInt(ageYear);
			if(this.ageYear == 0)
				this.ageYear = 10000;

			// バストイレ別
			this.isSeparatedBathToilet = isSeparatedBathToilet != null ? true : false;

			// 2階以上
			this.isUpperSecondFloor = isUpperSecondFloor != null ? true : false;

			// 洗濯機置き場
			this.hasWasherSpace = hasWasherSpace != null ? true : false;

			// エアコン有
			this.hasAircon = hasAircon != null ? true : false;

			// 駐車場有
			this.hasParking = hasParking != null ? true : false;

			// オートロック
			this.hasAutoLock = hasAutoLock != null ? true : false;

			// 追い炊き
			this.hasReheat = hasReheat != null ? true : false;

			// ペット可
			this.canHavePet = canHavePet != null ? true : false;

			SearchDao sd = new SearchDao();
			rpList = sd.search(this);
	}

	public List<RentalProperty> search(){
		List<RentalProperty> ngRpList = new ArrayList<RentalProperty>();
		if(rpList == null)
			return null;

		for(RentalProperty rp : rpList) {
			if(includingManagementFee) {
				int amountFee = rp.getRentFeeYen() + rp.getManagementFeeYen();
				boolean isOkay = minRentFeeYen <= amountFee && amountFee <= maxRentFeeYen;
				if( !isOkay  ) {
					ngRpList.add(rp);
				}
			}
		}

		for(RentalProperty rp : ngRpList) {
			rpList.remove(rp);
		}
		return rpList;
	}


	public int getMinRentFeeYen() {
		return minRentFeeYen;
	}

	public int getMaxRentFeeYen() {
		return maxRentFeeYen;
	}

	public boolean isIncludingManagementFee() {
		return includingManagementFee;
	}

	public boolean isHasNoDeposit() {
		return hasNoDeposit;
	}

	public boolean isHasNoKeyMoney() {
		return hasNoKeyMoney;
	}

	public int getMinAreaSquareMeter() {
		return minAreaSquareMeter;
	}

	public int getMaxAreaSquareMeter() {
		return maxAreaSquareMeter;
	}

	public List<Integer> getLayoutSearchList() {
		return layoutSearchList;
	}

	public int getWalkingTimeMin() {
		return walkingTimeMin;
	}

	public int getAgeYear() {
		return ageYear;
	}

	public boolean isSeparatedBathToilet() {
		return isSeparatedBathToilet;
	}

	public boolean isUpperSecondFloor() {
		return isUpperSecondFloor;
	}

	public boolean isHasWasherSpace() {
		return hasWasherSpace;
	}

	public boolean isHasAircon() {
		return hasAircon;
	}

	public boolean isHasParking() {
		return hasParking;
	}

	public boolean isHasAutoLock() {
		return hasAutoLock;
	}

	public boolean isHasReheat() {
		return hasReheat;
	}

	public boolean isCanHavePet() {
		return canHavePet;
	}
}
