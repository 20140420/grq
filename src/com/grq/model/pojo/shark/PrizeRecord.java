package com.grq.model.pojo.shark;
// default package

import java.sql.Time;


/**
 * PrizeRecord entity. @author MyEclipse Persistence Tools
 */

public class PrizeRecord  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String prizeId;
    private Time createTime;
    private Double totalPriceSum;
    private Double commissionRate;
    private String prizeName;
    private Double dividend;
    private Integer timesSwallow;
    private Integer timesPigeon;
    private Integer timesPeafowl;
    private Integer timesEagle;
    private Integer timesLion;
    private Integer timesPanda;
    private Integer timesMonkey;
    private Integer timesRabbit;
    private Integer goldSharkTimes;


    // Constructors

    /** default constructor */
    public PrizeRecord() {
    }

    
    /** full constructor */
    public PrizeRecord(String prizeId, Time createTime, Double totalPriceSum, Double commissionRate, String prizeName, Double dividend, Integer timesSwallow, Integer timesPigeon, Integer timesPeafowl, Integer timesEagle, Integer timesLion, Integer timesPanda, Integer timesMonkey, Integer timesRabbit, Integer goldSharkTimes) {
        this.prizeId = prizeId;
        this.createTime = createTime;
        this.totalPriceSum = totalPriceSum;
        this.commissionRate = commissionRate;
        this.prizeName = prizeName;
        this.dividend = dividend;
        this.timesSwallow = timesSwallow;
        this.timesPigeon = timesPigeon;
        this.timesPeafowl = timesPeafowl;
        this.timesEagle = timesEagle;
        this.timesLion = timesLion;
        this.timesPanda = timesPanda;
        this.timesMonkey = timesMonkey;
        this.timesRabbit = timesRabbit;
        this.goldSharkTimes = goldSharkTimes;
    }

   
    // Property accessors

    public String getPrizeId() {
        return this.prizeId;
    }
    
    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public Time getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

    public Double getTotalPriceSum() {
        return this.totalPriceSum;
    }
    
    public void setTotalPriceSum(Double totalPriceSum) {
        this.totalPriceSum = totalPriceSum;
    }

    public Double getCommissionRate() {
        return this.commissionRate;
    }
    
    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getPrizeName() {
        return this.prizeName;
    }
    
    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Double getDividend() {
        return this.dividend;
    }
    
    public void setDividend(Double dividend) {
        this.dividend = dividend;
    }

    public Integer getTimesSwallow() {
        return this.timesSwallow;
    }
    
    public void setTimesSwallow(Integer timesSwallow) {
        this.timesSwallow = timesSwallow;
    }

    public Integer getTimesPigeon() {
        return this.timesPigeon;
    }
    
    public void setTimesPigeon(Integer timesPigeon) {
        this.timesPigeon = timesPigeon;
    }

    public Integer getTimesPeafowl() {
        return this.timesPeafowl;
    }
    
    public void setTimesPeafowl(Integer timesPeafowl) {
        this.timesPeafowl = timesPeafowl;
    }

    public Integer getTimesEagle() {
        return this.timesEagle;
    }
    
    public void setTimesEagle(Integer timesEagle) {
        this.timesEagle = timesEagle;
    }

    public Integer getTimesLion() {
        return this.timesLion;
    }
    
    public void setTimesLion(Integer timesLion) {
        this.timesLion = timesLion;
    }

    public Integer getTimesPanda() {
        return this.timesPanda;
    }
    
    public void setTimesPanda(Integer timesPanda) {
        this.timesPanda = timesPanda;
    }

    public Integer getTimesMonkey() {
        return this.timesMonkey;
    }
    
    public void setTimesMonkey(Integer timesMonkey) {
        this.timesMonkey = timesMonkey;
    }

    public Integer getTimesRabbit() {
        return this.timesRabbit;
    }
    
    public void setTimesRabbit(Integer timesRabbit) {
        this.timesRabbit = timesRabbit;
    }

    public Integer getGoldSharkTimes() {
        return this.goldSharkTimes;
    }
    
    public void setGoldSharkTimes(Integer goldSharkTimes) {
        this.goldSharkTimes = goldSharkTimes;
    }
   








}