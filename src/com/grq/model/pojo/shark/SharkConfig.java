package com.grq.model.pojo.shark;


import java.util.Date;


/**
 * SharkConfig entity. @author MyEclipse Persistence Tools
 */

public class SharkConfig  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;//配置序列号(手动分配)
    private Date createTime = new Date();// 提交时间即截止时间
    private Boolean isBegin;//游戏是否开启
    private Double initialDividend;//彩金池初值
    private Double commissionRate;//佣金费率
    private Integer betLimit;//下注上限
    private Integer timesMax;//最高赔率
    private Integer circleNum;//转盘圈数
    private Integer timeCircle;//转圈时间
    private Integer timeObserve;//观察时间
    private Integer timeBet;//下注时间
    private Integer timeDisplay;//展示时间
    private Integer timeWait;//等待时间
    private Integer timeCycle;//周期时间
    private Integer prizeRecordNum;//统计查看奖项记录场数


    // Constructors

    /** default constructor */
    public SharkConfig() {
    }

    
    /** full constructor */
    public SharkConfig(Date createTime, Boolean isBegin, Double initialDividend, Double commissionRate, Integer singlBet, Integer betLimit, Integer timesMax, Integer circleNum, Integer timeCircle, Integer timeObserve, Integer timeBet, Integer timeDisplay, Integer timeWait, Integer timeCycle, Integer prizeRecordNum) {
        this.createTime = createTime;
        this.isBegin = isBegin;
        this.initialDividend = initialDividend;
        this.commissionRate = commissionRate;
        this.betLimit = betLimit;
        this.timesMax = timesMax;
        this.circleNum = circleNum;
        this.timeCircle = timeCircle;
        this.timeObserve = timeObserve;
        this.timeBet = timeBet;
        this.timeDisplay = timeDisplay;
        this.timeWait = timeWait;
        this.timeCycle = timeCycle;
        this.prizeRecordNum = prizeRecordNum;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsBegin() {
		return isBegin;
	}

	public void setIsBegin(Boolean isBegin) {
		this.isBegin = isBegin;
	}

	public Double getInitialDividend() {
        return this.initialDividend;
    }
    
    public void setInitialDividend(Double initialDividend) {
        this.initialDividend = initialDividend;
    }

    public Double getCommissionRate() {
        return this.commissionRate;
    }
    
    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

	public Integer getBetLimit() {
        return this.betLimit;
    }
    
    public void setBetLimit(Integer betLimit) {
        this.betLimit = betLimit;
    }

    public Integer getTimesMax() {
        return this.timesMax;
    }
    
    public void setTimesMax(Integer timesMax) {
        this.timesMax = timesMax;
    }

    public Integer getCircleNum() {
        return this.circleNum;
    }
    
    public void setCircleNum(Integer circleNum) {
        this.circleNum = circleNum;
    }

    public Integer getTimeCircle() {
        return this.timeCircle;
    }
    
    public void setTimeCircle(Integer timeCircle) {
        this.timeCircle = timeCircle;
    }

    public Integer getTimeObserve() {
        return this.timeObserve;
    }
    
    public void setTimeObserve(Integer timeObserve) {
        this.timeObserve = timeObserve;
    }

    public Integer getTimeBet() {
        return this.timeBet;
    }
    
    public void setTimeBet(Integer timeBet) {
        this.timeBet = timeBet;
    }

    public Integer getTimeDisplay() {
        return this.timeDisplay;
    }
    
    public void setTimeDisplay(Integer timeDisplay) {
        this.timeDisplay = timeDisplay;
    }

    public Integer getTimeWait() {
        return this.timeWait;
    }
    
    public void setTimeWait(Integer timeWait) {
        this.timeWait = timeWait;
    }


	public Integer getTimeCycle() {
		return timeCycle;
	}


	public void setTimeCycle(Integer timeCycle) {
		this.timeCycle = timeCycle;
	}


	public Integer getPrizeRecordNum() {
		return prizeRecordNum;
	}


	public void setPrizeRecordNum(Integer prizeRecordNum) {
		this.prizeRecordNum = prizeRecordNum;
	}
   








}