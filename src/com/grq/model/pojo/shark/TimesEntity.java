package com.grq.model.pojo.shark;

public class TimesEntity  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Fields 
	
	private Integer timesSwallow;//燕子倍数
	private Integer timesPigeon;//鸽子
	private Integer timesPeafowl;//孔雀
	private Integer timesEagle;//老鹰
	private Integer timesLion;//狮子
	private Integer timesPanda;//熊猫
	private Integer timesMonkey;//猴子
	private Integer timesRabbit;//兔子
	
    // Constructors
    /** default constructor */
    public TimesEntity() {
    }

    /* 六组倍数
     * 0: 6  8   8   12  12  8    8  6
     * 1: 6  6   12  12  12  12   6  6 
     * 2: 6  6   8   24  24  8    6  6
     * 3: 4  8   12  24  24  12   8  4
     * 4: 4  6   24  24  24  24   6  4
     * 5: 3  12  24  24  24  24   12 3
     */
    // Property accessors
	public Integer getTimesSwallow() {
		return timesSwallow;
	}

	public void setTimesSwallow(Integer timesSwallow) {
		if(timesSwallow == 0){
			this.timesSwallow = 6;
		}
		if(timesSwallow == 1){
			this.timesSwallow = 6;
		}
		if(timesSwallow == 2){
			this.timesSwallow = 6;
		}
		if(timesSwallow == 3){
			this.timesSwallow = 4;
		}
		if(timesSwallow == 4){
			this.timesSwallow = 4;
		}
		if(timesSwallow == 5){
			this.timesSwallow = 3;
		}
	}

	public Integer getTimesPigeon() {
		return timesPigeon;
	}

	public void setTimesPigeon(Integer timesPigeon) {
		if(timesPigeon == 0){
			this.timesPigeon = 8;
		}
		if(timesPigeon == 1){
			this.timesPigeon = 6;
		}
		if(timesPigeon == 2){
			this.timesPigeon = 6;
		}
		if(timesPigeon == 3){
			this.timesPigeon = 8;
		}
		if(timesPigeon == 4){
			this.timesPigeon = 6;
		}
		if(timesPigeon == 5){
			this.timesPigeon = 12;
		}
	}

	public Integer getTimesPeafowl() {
		return timesPeafowl;
	}

	public void setTimesPeafowl(Integer timesPeafowl) {
		if(timesPeafowl == 0){
			this.timesPeafowl = 8;
		}
		if(timesPeafowl == 1){
			this.timesPeafowl = 12;
		}
		if(timesPeafowl == 2){
			this.timesPeafowl = 8;
		}
		if(timesPeafowl == 3){
			this.timesPeafowl = 12;
		}
		if(timesPeafowl == 4){
			this.timesPeafowl = 24;
		}
		if(timesPeafowl == 5){
			this.timesPeafowl = 24;
		}
	}

	public Integer getTimesEagle() {
		return timesEagle;
	}

	public void setTimesEagle(Integer timesEagle) {
		if(timesEagle == 0){
			this.timesEagle = 12;
		}
		if(timesEagle == 1){
			this.timesEagle = 12;
		}
		if(timesEagle == 2){
			this.timesEagle = 24;
		}
		if(timesEagle == 3){
			this.timesEagle = 24;
		}
		if(timesEagle == 4){
			this.timesEagle = 24;
		}
		if(timesEagle == 5){
			this.timesEagle = 24;
		}
	}

	public Integer getTimesLion() {
		return timesLion;
	}

	public void setTimesLion(Integer timesLion) {
		if(timesLion == 0){
			this.timesLion = 12;
		}
		if(timesLion == 1){
			this.timesLion = 12;
		}
		if(timesLion == 2){
			this.timesLion = 24;
		}
		if(timesLion == 3){
			this.timesLion = 24;
		}
		if(timesLion == 4){
			this.timesLion = 24;
		}
		if(timesLion == 5){
			this.timesLion = 24;
		}
	}

	public Integer getTimesPanda() {
		return timesPanda;
	}

	public void setTimesPanda(Integer timesPanda) {
		if(timesPanda == 0){
			this.timesPanda = 8;
		}
		if(timesPanda == 1){
			this.timesPanda = 12;
		}
		if(timesPanda == 2){
			this.timesPanda = 8;
		}
		if(timesPanda == 3){
			this.timesPanda = 12;
		}
		if(timesPanda == 4){
			this.timesPanda = 24;
		}
		if(timesPanda == 5){
			this.timesPanda = 24;
		}
	}

	public Integer getTimesMonkey() {
		return timesMonkey;
	}

	public void setTimesMonkey(Integer timesMonkey) {
		if(timesMonkey == 0){
			this.timesMonkey = 8;
		}
		if(timesMonkey == 1){
			this.timesMonkey = 6;
		}
		if(timesMonkey == 2){
			this.timesMonkey = 6;
		}
		if(timesMonkey == 3){
			this.timesMonkey = 8;
		}
		if(timesMonkey == 4){
			this.timesMonkey = 6;
		}
		if(timesMonkey == 5){
			this.timesMonkey = 12;
		}
	}

	public Integer getTimesRabbit() {
		return timesRabbit;
	}

	public void setTimesRabbit(Integer timesRabbit) {
		if(timesRabbit == 0){
			this.timesRabbit = 6;
		}
		if(timesRabbit == 1){
			this.timesRabbit = 6;
		}
		if(timesRabbit == 2){
			this.timesRabbit = 6;
		}
		if(timesRabbit == 3){
			this.timesRabbit = 4;
		}
		if(timesRabbit == 4){
			this.timesRabbit = 4;
		}
		if(timesRabbit == 5){
			this.timesRabbit = 3;
		}
	}

}
