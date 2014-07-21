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
    private Integer timesGoldShark;//金鲨倍数
    private Integer timesBomb;//炸弹倍数
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
	private Double outSwallowScore;
	private Double outPigeonScore;
	private Double outPeafowlScore;
	private Double outEagleScore;
	private Double outLionScore;
	private Double outPandaScore;
	private Double outMonkeyScore;
	private Double outRabbitScore;
	private Double outSilverScore;
	private Double outGoldScore;
	private Double outBirdScore;//飞禽总出分 ;
	private Double outBeastScore;//走兽总出分 ;
	private Double outBombScore;//炸弹出分


    // Constructors

    /** default constructor */
    public PrizeRecord() {
    }
    
    /** full constructor */
    public PrizeRecord(String prizeId, Date createTime, Double commissionRate, 
    		Prize prizeName, Double dividend, Integer timesGoldShark, 
    		Integer timesBomb, Double totalSwallowSum, Double totalPigeonSum, 
    		Double totalPeafowlSum, Double totalEagleSum, Double totalLionSum, 
    		Double totalPandaSum, Double totalMonkeySum, Double totalRabbitSum, 
    		Double totalBirdSum, Double totalSilverSum, Double totalBombSum, 
    		Double totalGoldSum, Double totalBeastSum, Double totalBetSum,
    		Double outSwallowScore, Double outPigeonScore, Double outPeafowlScore,
    		Double outEagleScore, Double outLionScore, Double outPandaScore,
    		Double outMonkeyScore, Double outRabbitScore, Double outSilverScore,
    		Double outGoldScore, Double outBirdScore, Double outBeastScore,
    		Double outBombScore)  {
        this.prizeId = prizeId;
        this.setCreateTime(createTime);
        this.commissionRate = commissionRate;
        this.prizeName = prizeName;
        this.dividend = dividend;
        this.timesGoldShark = timesGoldShark;
        this.timesBomb = timesBomb;
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
        this.outSwallowScore = outSwallowScore;
        this.outPigeonScore = outPigeonScore;
        this.outPeafowlScore = outPeafowlScore;
        this.outEagleScore = outEagleScore;
        this.outLionScore = outLionScore;
        this.outPandaScore = outPandaScore;
        this.outMonkeyScore = outMonkeyScore;
        this.outRabbitScore = outRabbitScore;
        this.outSilverScore = outSilverScore;
        this.outGoldScore = outGoldScore;
        this.outBirdScore = outBirdScore;
        this.outBeastScore = outBeastScore;
        this.outBombScore = outBombScore;
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

    public Integer getTimesGoldShark() {
        return this.timesGoldShark;
    }
    
    public void setTimesGoldShark(Integer timesGoldShark) {
        this.timesGoldShark = timesGoldShark;
    }

    public Integer getTimesBomb() {
		return timesBomb;
	}

	public void setTimesBomb(Integer timesBomb) {
		this.timesBomb = timesBomb;
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

	public Double getOutSwallowScore() {
		return outSwallowScore;
	}

	public void setOutSwallowScore(Double outSwallowScore) {
		this.outSwallowScore = outSwallowScore;
	}

	public Double getOutPigeonScore() {
		return outPigeonScore;
	}

	public void setOutPigeonScore(Double outPigeonScore) {
		this.outPigeonScore = outPigeonScore;
	}

	public Double getOutPeafowlScore() {
		return outPeafowlScore;
	}

	public void setOutPeafowlScore(Double outPeafowlScore) {
		this.outPeafowlScore = outPeafowlScore;
	}

	public Double getOutEagleScore() {
		return outEagleScore;
	}

	public void setOutEagleScore(Double outEagleScore) {
		this.outEagleScore = outEagleScore;
	}

	public Double getOutLionScore() {
		return outLionScore;
	}

	public void setOutLionScore(Double outLionScore) {
		this.outLionScore = outLionScore;
	}

	public Double getOutPandaScore() {
		return outPandaScore;
	}

	public void setOutPandaScore(Double outPandaScore) {
		this.outPandaScore = outPandaScore;
	}

	public Double getOutMonkeyScore() {
		return outMonkeyScore;
	}

	public void setOutMonkeyScore(Double outMonkeyScore) {
		this.outMonkeyScore = outMonkeyScore;
	}

	public Double getOutRabbitScore() {
		return outRabbitScore;
	}

	public void setOutRabbitScore(Double outRabbitScore) {
		this.outRabbitScore = outRabbitScore;
	}

	public Double getOutSilverScore() {
		return outSilverScore;
	}

	public void setOutSilverScore(Double outSilverScore) {
		this.outSilverScore = outSilverScore;
	}

	public Double getOutGoldScore() {
		return outGoldScore;
	}

	public void setOutGoldScore(Double outGoldScore) {
		this.outGoldScore = outGoldScore;
	}

	public Double getOutBirdScore() {
		return outBirdScore;
	}

	public void setOutBirdScore(Double outBirdScore) {
		this.outBirdScore = outBirdScore;
	}

	public Double getOutBeastScore() {
		return outBeastScore;
	}

	public void setOutBeastScore(Double outBeastScore) {
		this.outBeastScore = outBeastScore;
	}

	public Double getOutBombScore() {
		return outBombScore;
	}

	public void setOutBombScore(Double outBombScore) {
		this.outBombScore = outBombScore;
	}

}