package com.grq.model.pojo.shark;
// default package

import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.user.Customer;
import java.util.Date;


/**
 * PanelInfo1 entity. @author MyEclipse Persistence Tools
 */

public class PanelInfo  implements java.io.Serializable {


    // Fields    
	

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String panelBetId;// 键盘下注编号(手动分配)
	private Customer customer;// 所属用户
    private Date createTime = new Date();// 提交时间即截止时间
 	private Integer swallow;// 燕子
 	private Integer pigeon;// 鸽子
 	private Integer peafowl;// 孔雀
 	private Integer eagle;// 老鹰
 	private Integer lion;// 狮子
 	private Integer panda;// 熊猫
 	private Integer monkey;// 猴子
 	private Integer rabbit;// 兔子
 	private Integer bird;// 飞禽
 	private Integer silver_shark;// 银鲨
 	private Integer bomb;// 炸弹
 	private Integer gold_shark;// 金鲨
 	private Integer beast;// 走兽
 	private Integer totalBet;// 下注总数
 	private Prize prizeItem; //奖项
 	private Boolean betCount = false;// 用于判断是否是统计过（默认值为false）
 	private Integer timesSwallow;
    private Integer timesPigeon;
    private Integer timesPeafowl;
    private Integer timesEagle;
    private Integer timesLion;
    private Integer timesPanda;
    private Integer timesMonkey;
    private Integer timesRabbit;

    // Constructors

    /** default constructor */
    public PanelInfo() {
    }

    
    /** full constructor */
    public PanelInfo(String panelBetId, Customer customer, Date createTime, 
    		Integer swallow, Integer pigeon, Integer peafowl, Integer eagle, 
    		Integer lion, Integer panda, Integer monkey, Integer rabbit, 
    		Integer bird, Integer silverShark, Integer bomb, Integer goldShark, 
    		Integer beast, Integer totalBet, Prize prizeItem, Boolean betCount,
    		Integer timesSwallow, Integer timesPigeon, Integer timesPeafowl, 
    		Integer timesEagle, Integer timesLion, Integer timesPanda,
    		Integer timesMonkey, Integer timesRabbit) {
        this.panelBetId = panelBetId;
        this.customer = customer;
        this.setCreateTime(createTime);
        this.swallow = swallow;
        this.pigeon = pigeon;
        this.peafowl = peafowl;
        this.eagle = eagle;
        this.lion = lion;
        this.panda = panda;
        this.monkey = monkey;
        this.rabbit = rabbit;
        this.bird = bird;
        this.silver_shark = silverShark;
        this.bomb = bomb;
        this.gold_shark = goldShark;
        this.beast = beast;
        this.totalBet = totalBet;
        this.prizeItem = prizeItem;
        this.betCount = betCount;
        this.timesSwallow = timesSwallow;
        this.timesPigeon = timesPigeon;
        this.timesPeafowl = timesPeafowl;
        this.timesEagle = timesEagle;
        this.timesLion = timesLion;
        this.timesPanda = timesPanda;
        this.timesMonkey = timesMonkey;
        this.timesRabbit = timesRabbit;        
    }

   
    // Property accessors

    public String getPanelBetId() {
        return this.panelBetId;
    }
    
    public void setPanelBetId(String panelBetId) {
        this.panelBetId = panelBetId;
    }

    public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Integer getSwallow() {
        return this.swallow;
    }
    
    public void setSwallow(Integer swallow) {
        this.swallow = swallow;
    }

    public Integer getPigeon() {
        return this.pigeon;
    }
    
    public void setPigeon(Integer pigeon) {
        this.pigeon = pigeon;
    }

    public Integer getPeafowl() {
        return this.peafowl;
    }
    
    public void setPeafowl(Integer peafowl) {
        this.peafowl = peafowl;
    }

    public Integer getEagle() {
        return this.eagle;
    }
    
    public void setEagle(Integer eagle) {
        this.eagle = eagle;
    }

    public Integer getLion() {
        return this.lion;
    }
    
    public void setLion(Integer lion) {
        this.lion = lion;
    }

    public Integer getPanda() {
        return this.panda;
    }
    
    public void setPanda(Integer panda) {
        this.panda = panda;
    }

    public Integer getMonkey() {
        return this.monkey;
    }
    
    public void setMonkey(Integer monkey) {
        this.monkey = monkey;
    }

    public Integer getRabbit() {
        return this.rabbit;
    }
    
    public void setRabbit(Integer rabbit) {
        this.rabbit = rabbit;
    }

    public Integer getBird() {
        return this.bird;
    }
    
    public void setBird(Integer bird) {
        this.bird = bird;
    }

    public Integer getSilver_shark() {
		return silver_shark;
	}


	public void setSilver_shark(Integer silver_shark) {
		this.silver_shark = silver_shark;
	}

    public Integer getBomb() {
        return this.bomb;
    }
    
    public void setBomb(Integer bomb) {
        this.bomb = bomb;
    }

    public Integer getGold_shark() {
		return gold_shark;
	}

	public void setGold_shark(Integer gold_shark) {
		this.gold_shark = gold_shark;
	}

    public Integer getBeast() {
        return this.beast;
    }
    
    public void setBeast(Integer beast) {
        this.beast = beast;
    }

    public Integer getTotalBet() {
        return this.totalBet;
    }
    
    public void setTotalBet(Integer totalBet) {
        this.totalBet = totalBet;
    }
    
	public Prize getPrizeItem() {
		return prizeItem;
	}


	public void setPrizeItem(Prize prizeItem) {
		this.prizeItem = prizeItem;
	}


	public Boolean getBetCount() {
		return betCount;
	}


	public void setBetCount(Boolean betCount) {
		this.betCount = betCount;
	}


	public Integer getTimesSwallow() {
		return timesSwallow;
	}


	public void setTimesSwallow(Integer timesSwallow) {
		this.timesSwallow = timesSwallow;
	}


	public Integer getTimesPigeon() {
		return timesPigeon;
	}


	public void setTimesPigeon(Integer timesPigeon) {
		this.timesPigeon = timesPigeon;
	}


	public Integer getTimesPeafowl() {
		return timesPeafowl;
	}


	public void setTimesPeafowl(Integer timesPeafowl) {
		this.timesPeafowl = timesPeafowl;
	}


	public Integer getTimesEagle() {
		return timesEagle;
	}


	public void setTimesEagle(Integer timesEagle) {
		this.timesEagle = timesEagle;
	}


	public Integer getTimesLion() {
		return timesLion;
	}


	public void setTimesLion(Integer timesLion) {
		this.timesLion = timesLion;
	}


	public Integer getTimesPanda() {
		return timesPanda;
	}


	public void setTimesPanda(Integer timesPanda) {
		this.timesPanda = timesPanda;
	}


	public Integer getTimesMonkey() {
		return timesMonkey;
	}


	public void setTimesMonkey(Integer timesMonkey) {
		this.timesMonkey = timesMonkey;
	}


	public Integer getTimesRabbit() {
		return timesRabbit;
	}


	public void setTimesRabbit(Integer timesRabbit) {
		this.timesRabbit = timesRabbit;
	}
}