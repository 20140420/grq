// default package
package com.grq.model.pojo.shark;

import java.util.Timer;

import com.grq.model.customizeenum.Prize;

/**
 * PrizeRecord entity. @author MyEclipse Persistence Tools
 */

public class PrizeRecord  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String prizeId;//奖项期号(手动分配)
    private Timer createTime =new Timer() ;//生成时间
    private Double totalPriceSum;//单场下注总额
    private Double commissionRate;//佣金费率
    private Prize prizeName;//中奖的奖项
    private Double dividend;//剩余彩金池
    private Integer timesSwallow;//燕子倍数
    private Integer timesPigeon;//鸽子倍数
    private Integer timesPeafowl;//孔雀倍数
    private Integer timesEagle;//老鹰倍数
    private Integer timesLion;//狮子倍数
    private Integer timesPanda;//熊猫倍数
    private Integer timesMonkey;//猴子倍数
    private Integer timesRabbit;//兔子倍数
    private Integer goldSharkTimes;//金鲨倍数


    // Constructors

    /** default constructor */
    public PrizeRecord() {
    }

    
    /** full constructor */
    public PrizeRecord(String prizeId, Timer createTime, Double totalPriceSum, Double commissionRate, Prize prizeName, Double dividend, Integer timesSwallow, Integer timesPigeon, Integer timesPeafowl, Integer timesEagle, Integer timesLion, Integer timesPanda, Integer timesMonkey, Integer timesRabbit, Integer goldSharkTimes) {
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

    public Timer getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timer createTime) {
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

    public Prize getPrizeName() {
        return this.prizeName;
    }
    
    public void setPrizeName(Prize prizeName) {
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