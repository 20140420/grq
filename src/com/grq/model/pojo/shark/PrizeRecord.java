// default package
package com.grq.model.pojo.shark;

import java.util.Date;

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
    private Date createTime =new Date() ;//生成时间
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
    private Integer timesGoldShark;//金鲨倍数
	private Double totalSwallowSum; //燕子下注总额之和
	private Double totalPigeonSum;//鸽子下注总额之和
	private Double totalPeafowlSum;//孔雀下注总额之和
	private Double totalEagleSum;//老鹰下注总额之和
	private Double totalLionSum;//狮子下注总额之和
	private Double totalPandaSum;//熊猫下注总额之和
	private Double totalMonkeySum;//猴子
	private Double totalRabbitSum;//兔子
	private Double totalBirdSum;//统计飞禽下注总额之和
	private Double totalSilverSum;//银鲨
	private Double totalBombSum;//炸弹
	private Double totalGoldSum;//金鲨
	private Double totalBeastSum;//统计走兽下注总额之和
	private Double totalBetSum;//一场下注总金额


    // Constructors

    /** default constructor */
    public PrizeRecord() {
    }

    
    /** full constructor */
    public PrizeRecord(String prizeId, Date createTime, Double commissionRate, Prize prizeName, Double dividend, Integer timesSwallow, Integer timesPigeon, Integer timesPeafowl, Integer timesEagle, Integer timesLion, Integer timesPanda, Integer timesMonkey, Integer timesRabbit, Double totalSwallowSum, Double totalPigeonSum, Double totalPeafowlSum, Double totalEagleSum, Double totalLionSum, Double totalPandaSum, Double totalMonkeySum, Double totalRabbitSum, Double totalBirdSum, Double totalSilverSum, Double totalBombSum, Double totalGoldSum, Double totalBeastSum, Double totalBetSum)  {
        this.prizeId = prizeId;
        this.createTime = createTime;
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
        this.totalSwallowSum = totalSwallowSum;
        this.totalPigeonSum = totalPigeonSum;
        this.totalPeafowlSum = totalPeafowlSum;
        this.totalEagleSum = totalEagleSum;
        this.totalLionSum = totalLionSum;
        this.totalPandaSum = totalPandaSum;
        this.totalMonkeySum = totalMonkeySum;
        this.totalRabbitSum = totalRabbitSum;
        this.totalBirdSum = totalBirdSum;
        this.totalSilverSum = totalSilverSum;
        this.totalBombSum = totalBombSum;
        this.totalGoldSum = totalGoldSum;
        this.totalBeastSum = totalBeastSum;
        this.totalBetSum = totalBetSum;
    }

   
    // Property accessors
    public String getPrizeId() {
        return this.prizeId;
    }
    
    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getTimesGoldShark() {
        return this.timesGoldShark;
    }
    
    public void setTimesGoldShark(Integer timesGoldShark) {
        this.timesGoldShark = timesGoldShark;
    }

    public Double getTotalSwallowSum() {
        return this.totalSwallowSum;
    }
    
    public void setTotalSwallowSum(Double totalSwallowSum) {
        this.totalSwallowSum = totalSwallowSum;
    }

    public Double getTotalPigeonSum() {
        return this.totalPigeonSum;
    }
    
    public void setTotalPigeonSum(Double totalPigeonSum) {
        this.totalPigeonSum = totalPigeonSum;
    }

    public Double getTotalPeafowlSum() {
        return this.totalPeafowlSum;
    }
    
    public void setTotalPeafowlSum(Double totalPeafowlSum) {
        this.totalPeafowlSum = totalPeafowlSum;
    }

    public Double getTotalEagleSum() {
        return this.totalEagleSum;
    }
    
    public void setTotalEagleSum(Double totalEagleSum) {
        this.totalEagleSum = totalEagleSum;
    }

    public Double getTotalLionSum() {
        return this.totalLionSum;
    }
    
    public void setTotalLionSum(Double totalLionSum) {
        this.totalLionSum = totalLionSum;
    }

    public Double getTotalPandaSum() {
        return this.totalPandaSum;
    }
    
    public void setTotalPandaSum(Double totalPandaSum) {
        this.totalPandaSum = totalPandaSum;
    }

    public Double getTotalMonkeySum() {
        return this.totalMonkeySum;
    }
    
    public void setTotalMonkeySum(Double totalMonkeySum) {
        this.totalMonkeySum = totalMonkeySum;
    }

    public Double getTotalRabbitSum() {
        return this.totalRabbitSum;
    }
    
    public void setTotalRabbitSum(Double totalRabbitSum) {
        this.totalRabbitSum = totalRabbitSum;
    }

    public Double getTotalBirdSum() {
        return this.totalBirdSum;
    }
    
    public void setTotalBirdSum(Double totalBirdSum) {
        this.totalBirdSum = totalBirdSum;
    }

    public Double getTotalSilverSum() {
        return this.totalSilverSum;
    }
    
    public void setTotalSilverSum(Double totalSilverSum) {
        this.totalSilverSum = totalSilverSum;
    }

    public Double getTotalBombSum() {
        return this.totalBombSum;
    }
    
    public void setTotalBombSum(Double totalBombSum) {
        this.totalBombSum = totalBombSum;
    }

    public Double getTotalGoldSum() {
        return this.totalGoldSum;
    }
    
    public void setTotalGoldSum(Double totalGoldSum) {
        this.totalGoldSum = totalGoldSum;
    }

    public Double getTotalBeastSum() {
        return this.totalBeastSum;
    }
    
    public void setTotalBeastSum(Double totalBeastSum) {
        this.totalBeastSum = totalBeastSum;
    }

    public Double getTotalBetSum() {
        return this.totalBetSum;
    }
    
    public void setTotalBetSum(Double totalBetSum) {
        this.totalBetSum = totalBetSum;
    }

}