package estateapp.model.entity;

import java.io.Serializable;
import java.util.Date;

public class RentalProperty implements Serializable{
	private int estateId;		// 不動産ID
	private String estateName; // 不動産名
	private int building_floors; // 階数
	private int floor;				// 所在会
	private int rentFeeYen;		// 賃貸料
	private int managementFeeYen;	// 管理費
	private int depositYen;		// 敷金
	private int keyMoneyYen;		// 礼金
	private int exMoney1Yen;		// 保証金
	private int exMoney2Yen;		 // 償却金
	private String nearStation;	// 最寄駅
	private int walkTimeMin;		// 徒歩
	private String address;		// 住所
	private int ageYear;			// 築年月
	private String lightingDirection;	// 主要最高面
	private int areaSquareMeter;		// 面積
	private int balconyAreaSquareMeter;	// バルコニー面積
	private String layout;					// 間取り
	private Date entryDate;				// 登録日
	private Date expireDate;				// 有効期限
	private Date updateDate;				// 更新日
	private String structure;				// 構造
	private int contractDays;				// 契約期間
	private int renewFeeYen;				// 更新料
	private String suretyCompany;			// 保証会社
	private String insurance;				// 住宅保険
	private String situation;				// 現況
	private String delivery;				// 引き渡し
	private boolean hasKitchen;			// キッチン有フラグ
	private boolean haskitchenGasStove;	// ガスコンロ有
	private boolean hasKitchenIHstove;	// IHコンロあり
	private int numberOfKitchenStove;		// コンロ数
	private boolean hasCounterKitchen;	// カウンターキッチン
	private boolean hasSystemKitchen;		// システムキッチン
	private boolean hasBath;				// バス有
	private boolean hasToilet;			// トイレ有
	private boolean isSeparatedBathToilet;	// バストイレ別
	private boolean hasReheatBath;			// 追い炊き機能
	private boolean hasToiletShower;			// トイレットシャワー
	private boolean hasBathDryer;				// 浴室乾燥機
	private boolean hasSingleLavatory;		// 独立洗面所
	private boolean hasWasherSpace;			// 室内洗濯機置き場有
	private boolean hasAircon;				// エアコン
	private boolean hasFloorHeater;			// 床暖房有
	private boolean hasToyuHeater;			// 灯油暖房有
	private boolean hasGasHeater;				// ガス暖房有
	private boolean hasCarParking;			// 駐車場有
	private boolean hasBikeParking;			// 駐輪場有
	private boolean hasMotorcycleParking;		// バイク置き場有
	private boolean hasElevator;				// エレベーター有
	private boolean hasDeliveryBox;			// 宅配ボックス有
	private boolean hasGabageArea;			// 敷地内ごみ置き場
	private boolean hasAutolock;				// オートロック有
	private boolean hasFulltimeManager;		// 管理人常駐
	private boolean hasMonitorPhone;			// モニタ付きインターホン
	private boolean hasToshiGas;				// 都市ガス有
	private boolean hasAllElectronic;			// オール電化
	private boolean hasWoodenFlooring;		// フローリング
	private boolean canHavePet;				// ペット相談可
	private String Requirement;				// 条件
	private String facilities;					// 設備・サービス
	private String note;						// 備考
	private String imageFileName001;
	private String imageFileName002;
	private String imageFileName003;
	private String imageFileName004;
	private String imageFileName005;
	private String imageFileName006;
	private String imageFileName007;
	private String imageFileName008;
	private String imageFileName009;
	private String imageFileName010;

	public RentalProperty() {}

	public RentalProperty(int estateId, String estateName, int building_floors, int floor, int rentFeeYen,
			int managementFeeYen, int depositYen, int keyMoneyYen, int exMoney1Yen, int exMoney2Yen, String nearStation,
			int walkTimeMin, String address, int ageYear, String lightingDirection, int areaSquareMeter,
			int balconyAreaSquareMeter, String layout, Date entryDate, Date expireDate, Date updateDate,
			String structure, int contractDays, int renewFeeYen, String suretyCompany, String insurance,
			String situation, String delivery, boolean hasKitchen, boolean haskitchenGasStove,
			boolean hasKitchenIHstove, int numberOfKitchenStove, boolean hasCounterKitchen, boolean hasSystemKitchen,
			boolean hasBath, boolean hasToilet, boolean isSeparatedBathToilet, boolean hasReheatBath,
			boolean hasToiletShower, boolean hasBathDryer, boolean hasSingleLavatory, boolean hasWasherSpace,
			boolean hasAircon, boolean hasFloorHeater, boolean hasToyuHeater, boolean hasGasHeater,
			boolean hasCarParking, boolean hasBikeParking, boolean hasMotorcycleParking, boolean hasElevator,
			boolean hasDeliveryBox, boolean hasGabageArea, boolean hasAutolock, boolean hasFulltimeManager,
			boolean hasMonitorPhone, boolean hasToshiGas, boolean hasAllElectronic, boolean hasWoodenFlooring,
			boolean canHavePet, String requirement, String facilities, String note, String imageFileName001,
			String imageFileName002, String imageFileName003, String imageFileName004, String imageFileName005,
			String imageFileName006, String imageFileName007, String imageFileName008, String imageFileName009,
			String imageFileName010) {
		this.estateId = estateId;
		this.estateName = estateName;
		this.building_floors = building_floors;
		this.floor = floor;
		this.rentFeeYen = rentFeeYen;
		this.managementFeeYen = managementFeeYen;
		this.depositYen = depositYen;
		this.keyMoneyYen = keyMoneyYen;
		this.exMoney1Yen = exMoney1Yen;
		this.exMoney2Yen = exMoney2Yen;
		this.nearStation = nearStation;
		this.walkTimeMin = walkTimeMin;
		this.address = address;
		this.ageYear = ageYear;
		this.lightingDirection = lightingDirection;
		this.areaSquareMeter = areaSquareMeter;
		this.balconyAreaSquareMeter = balconyAreaSquareMeter;
		this.layout = layout;
		this.entryDate = entryDate;
		this.expireDate = expireDate;
		this.updateDate = updateDate;
		this.structure = structure;
		this.contractDays = contractDays;
		this.renewFeeYen = renewFeeYen;
		this.suretyCompany = suretyCompany;
		this.insurance = insurance;
		this.situation = situation;
		this.delivery = delivery;
		this.hasKitchen = hasKitchen;
		this.haskitchenGasStove = haskitchenGasStove;
		this.hasKitchenIHstove = hasKitchenIHstove;
		this.numberOfKitchenStove = numberOfKitchenStove;
		this.hasCounterKitchen = hasCounterKitchen;
		this.hasSystemKitchen = hasSystemKitchen;
		this.hasBath = hasBath;
		this.hasToilet = hasToilet;
		this.isSeparatedBathToilet = isSeparatedBathToilet;
		this.hasReheatBath = hasReheatBath;
		this.hasToiletShower = hasToiletShower;
		this.hasBathDryer = hasBathDryer;
		this.hasSingleLavatory = hasSingleLavatory;
		this.hasWasherSpace = hasWasherSpace;
		this.hasAircon = hasAircon;
		this.hasFloorHeater = hasFloorHeater;
		this.hasToyuHeater = hasToyuHeater;
		this.hasGasHeater = hasGasHeater;
		this.hasCarParking = hasCarParking;
		this.hasBikeParking = hasBikeParking;
		this.hasMotorcycleParking = hasMotorcycleParking;
		this.hasElevator = hasElevator;
		this.hasDeliveryBox = hasDeliveryBox;
		this.hasGabageArea = hasGabageArea;
		this.hasAutolock = hasAutolock;
		this.hasFulltimeManager = hasFulltimeManager;
		this.hasMonitorPhone = hasMonitorPhone;
		this.hasToshiGas = hasToshiGas;
		this.hasAllElectronic = hasAllElectronic;
		this.hasWoodenFlooring = hasWoodenFlooring;
		this.canHavePet = canHavePet;
		this.Requirement = requirement;
		this.facilities = facilities;
		this.note = note;
		this.imageFileName001 = imageFileName001;
		this.imageFileName002 = imageFileName002;
		this.imageFileName003 = imageFileName003;
		this.imageFileName004 = imageFileName004;
		this.imageFileName005 = imageFileName005;
		this.imageFileName006 = imageFileName006;
		this.imageFileName007 = imageFileName007;
		this.imageFileName008 = imageFileName008;
		this.imageFileName009 = imageFileName009;
		this.imageFileName010 = imageFileName010;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public boolean isCanHavePet() {
		return canHavePet;
	}

	public void setCanHavePet(boolean canHavePet) {
		this.canHavePet = canHavePet;
	}


	public int getEstateId() {
		return estateId;
	}
	public void setEstateId(int estateId) {
		this.estateId = estateId;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	public int getBuilding_floors() {
		return building_floors;
	}
	public void setBuilding_floors(int building_floors) {
		this.building_floors = building_floors;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getRentFeeYen() {
		return rentFeeYen;
	}
	public void setRentFeeYen(int rentFeeYen) {
		this.rentFeeYen = rentFeeYen;
	}
	public int getManagementFeeYen() {
		return managementFeeYen;
	}
	public void setManagementFeeYen(int managementFeeYen) {
		this.managementFeeYen = managementFeeYen;
	}
	public int getDepositYen() {
		return depositYen;
	}
	public void setDepositYen(int depositYen) {
		this.depositYen = depositYen;
	}
	public int getKeyMoneyYen() {
		return keyMoneyYen;
	}
	public void setKeyMoneyYen(int keyMoneyYen) {
		this.keyMoneyYen = keyMoneyYen;
	}
	public int getExMoney1Yen() {
		return exMoney1Yen;
	}
	public void setExMoney1Yen(int exMoney1Yen) {
		this.exMoney1Yen = exMoney1Yen;
	}
	public int getExMoney2Yen() {
		return exMoney2Yen;
	}
	public void setExMoney2Yen(int exMoney2Yen) {
		this.exMoney2Yen = exMoney2Yen;
	}
	public String getNearStation() {
		return nearStation;
	}
	public void setNearStation(String nearStation) {
		this.nearStation = nearStation;
	}
	public int getWalkTimeMin() {
		return walkTimeMin;
	}
	public void setWalkTimeMin(int walkTimeMin) {
		this.walkTimeMin = walkTimeMin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAgeYear() {
		return ageYear;
	}
	public void setAgeYear(int ageYear) {
		this.ageYear = ageYear;
	}
	public String getLightingDirection() {
		return lightingDirection;
	}
	public void setLightingDirection(String lightingDirection) {
		this.lightingDirection = lightingDirection;
	}
	public int getAreaSquareMeter() {
		return areaSquareMeter;
	}
	public void setAreaSqureMeter(int areaSqureMeter) {
		this.areaSquareMeter = areaSqureMeter;
	}
	public int getBalconyAreaSqureMeter() {
		return balconyAreaSquareMeter;
	}
	public void setBalconyAreaSqureMeter(int balconyAreaSqureMeter) {
		this.balconyAreaSquareMeter = balconyAreaSqureMeter;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public int getContractDays() {
		return contractDays;
	}
	public void setContractDays(int contractDays) {
		this.contractDays = contractDays;
	}
	public int getRenewFeeYen() {
		return renewFeeYen;
	}
	public void setRenewFeeYen(int renewFeeYen) {
		this.renewFeeYen = renewFeeYen;
	}
	public String getSuretyCompany() {
		return suretyCompany;
	}
	public void setSuretyCompany(String suretyCompany) {
		this.suretyCompany = suretyCompany;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public boolean isHasKitchen() {
		return hasKitchen;
	}
	public void setHasKitchen(boolean hasKitchen) {
		this.hasKitchen = hasKitchen;
	}
	public boolean isHaskitchenGasStove() {
		return haskitchenGasStove;
	}
	public void setHaskitchenGasStove(boolean haskitchenGasStove) {
		this.haskitchenGasStove = haskitchenGasStove;
	}
	public boolean isHasKitchenIHstove() {
		return hasKitchenIHstove;
	}
	public void setHasKitchenIHstove(boolean hasKitchenIHstove) {
		this.hasKitchenIHstove = hasKitchenIHstove;
	}
	public int getNumberOfKitchenStove() {
		return numberOfKitchenStove;
	}
	public void setNumberOfKitchenStove(int numberOfKitchenStove) {
		this.numberOfKitchenStove = numberOfKitchenStove;
	}
	public boolean isHasCounterKitchen() {
		return hasCounterKitchen;
	}
	public void setHasCounterKitchen(boolean hasCounterKitchen) {
		this.hasCounterKitchen = hasCounterKitchen;
	}
	public boolean isHasSystemKitchen() {
		return hasSystemKitchen;
	}
	public void setHasSystemKitchen(boolean hasSystemKitchen) {
		this.hasSystemKitchen = hasSystemKitchen;
	}
	public boolean isHasBath() {
		return hasBath;
	}
	public void setHasBath(boolean hasBath) {
		this.hasBath = hasBath;
	}
	public boolean isHasToilet() {
		return hasToilet;
	}
	public void setHasToilet(boolean hasToilet) {
		this.hasToilet = hasToilet;
	}
	public boolean isSeparatedBathToilet() {
		return isSeparatedBathToilet;
	}
	public void setSeparatedBathToilet(boolean isSeparatedBathToilet) {
		this.isSeparatedBathToilet = isSeparatedBathToilet;
	}
	public boolean isHasReheatBath() {
		return hasReheatBath;
	}
	public void setHasReheatBath(boolean hasReheatBath) {
		this.hasReheatBath = hasReheatBath;
	}
	public boolean isHasToiletShower() {
		return hasToiletShower;
	}
	public void setHasToiletShower(boolean hasToiletShower) {
		this.hasToiletShower = hasToiletShower;
	}
	public boolean isHasBathDryer() {
		return hasBathDryer;
	}
	public void setHasBathDryer(boolean hasBathDryer) {
		this.hasBathDryer = hasBathDryer;
	}
	public boolean isHasSingleLavatory() {
		return hasSingleLavatory;
	}
	public void setHasSingleLavatory(boolean hasSingleLavatory) {
		this.hasSingleLavatory = hasSingleLavatory;
	}
	public boolean isHasWahserSpace() {
		return hasWasherSpace;
	}
	public void setHasWasherSpace(boolean hasdryerSpace) {
		this.hasWasherSpace = hasdryerSpace;
	}
	public boolean isHasAircon() {
		return hasAircon;
	}
	public void setHasAircon(boolean hasAircon) {
		this.hasAircon = hasAircon;
	}
	public boolean isHasFloorHeater() {
		return hasFloorHeater;
	}
	public void setHasFloorHeater(boolean hasFloorHeater) {
		this.hasFloorHeater = hasFloorHeater;
	}
	public boolean isHasToyuHeater() {
		return hasToyuHeater;
	}
	public void setHasToyuHeater(boolean hasToyuHeater) {
		this.hasToyuHeater = hasToyuHeater;
	}
	public boolean isHasGasHeater() {
		return hasGasHeater;
	}
	public void setHasGasHeater(boolean hasGasHeater) {
		this.hasGasHeater = hasGasHeater;
	}
	public boolean isHasCarParking() {
		return hasCarParking;
	}
	public void setHasCarParking(boolean hasCarParking) {
		this.hasCarParking = hasCarParking;
	}
	public boolean isHasBikeParking() {
		return hasBikeParking;
	}
	public void setHasBikeParking(boolean hasBikeParking) {
		this.hasBikeParking = hasBikeParking;
	}
	public boolean isHasMotorcycleParking() {
		return hasMotorcycleParking;
	}
	public void setHasMotorcycleParking(boolean hasMotorcycleParking) {
		this.hasMotorcycleParking = hasMotorcycleParking;
	}
	public boolean isHasElevator() {
		return hasElevator;
	}
	public void setHasElevator(boolean hasElevator) {
		this.hasElevator = hasElevator;
	}
	public boolean isHasDeliveryBox() {
		return hasDeliveryBox;
	}
	public void setHasDeliveryBox(boolean hasDeliveryBox) {
		this.hasDeliveryBox = hasDeliveryBox;
	}
	public boolean isHasGabageArea() {
		return hasGabageArea;
	}
	public void setHasGabageArea(boolean hasGabageArea) {
		this.hasGabageArea = hasGabageArea;
	}
	public boolean isHasAutolock() {
		return hasAutolock;
	}
	public void setHasAutolock(boolean hasAutolock) {
		this.hasAutolock = hasAutolock;
	}
	public boolean isHasFulltimeManager() {
		return hasFulltimeManager;
	}
	public void setHasFulltimeManager(boolean hasFulltimeManager) {
		this.hasFulltimeManager = hasFulltimeManager;
	}
	public boolean isHasMonitorPhone() {
		return hasMonitorPhone;
	}
	public void setHasMonitorPhone(boolean hasMonitorPhone) {
		this.hasMonitorPhone = hasMonitorPhone;
	}
	public boolean isHasToshiGas() {
		return hasToshiGas;
	}
	public void setHasToshiGas(boolean hasToshiGas) {
		this.hasToshiGas = hasToshiGas;
	}
	public boolean isHasAllElectronic() {
		return hasAllElectronic;
	}
	public void setHasAllElectronic(boolean hasAllElectronic) {
		this.hasAllElectronic = hasAllElectronic;
	}
	public boolean isHasWoodenFlooring() {
		return hasWoodenFlooring;
	}
	public void setHasWoodenFlooring(boolean hasWoodenFlooring) {
		this.hasWoodenFlooring = hasWoodenFlooring;
	}
	public String getRequirement() {
		return Requirement;
	}
	public void setRequirement(String requirement) {
		Requirement = requirement;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getImageFileName001() {
		return imageFileName001;
	}
	public void setImageFileName001(String imageFileName001) {
		this.imageFileName001 = imageFileName001;
	}
	public String getImageFileName002() {
		return imageFileName002;
	}
	public void setImageFileName002(String imageFileName002) {
		this.imageFileName002 = imageFileName002;
	}
	public String getImageFileName003() {
		return imageFileName003;
	}
	public void setImageFileName003(String imageFileName003) {
		this.imageFileName003 = imageFileName003;
	}
	public String getImageFileName004() {
		return imageFileName004;
	}
	public void setImageFileName004(String imageFileName004) {
		this.imageFileName004 = imageFileName004;
	}
	public String getImageFileName005() {
		return imageFileName005;
	}
	public void setImageFileName005(String imageFileName005) {
		this.imageFileName005 = imageFileName005;
	}
	public String getImageFileName006() {
		return imageFileName006;
	}
	public void setImageFileName006(String imageFileName006) {
		this.imageFileName006 = imageFileName006;
	}
	public String getImageFileName007() {
		return imageFileName007;
	}
	public void setImageFileName007(String imageFileName007) {
		this.imageFileName007 = imageFileName007;
	}
	public String getImageFileName008() {
		return imageFileName008;
	}
	public void setImageFileName008(String imageFileName008) {
		this.imageFileName008 = imageFileName008;
	}
	public String getImageFileName009() {
		return imageFileName009;
	}
	public void setImageFileName009(String imageFileName009) {
		this.imageFileName009 = imageFileName009;
	}
	public String getImageFileName010() {
		return imageFileName010;
	}
	public void setImageFileName010(String imageFileName010) {
		this.imageFileName010 = imageFileName010;
	}
}
