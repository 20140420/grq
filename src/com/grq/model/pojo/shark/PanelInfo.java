package com.grq.model.pojo.shark;
// default package

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
 	private Integer totalBet;// 下注总数（非总额）
 	private Float single_bet;// 单注额度
 	private Float totalPrice;// 下注总额度


    // Constructors

    /** default constructor */
    public PanelInfo() {
    }

    
    /** full constructor */
    public PanelInfo(String panelBetId, Customer customer, Date createTime, Integer swallow, Integer pigeon, Integer peafowl, Integer eagle, Integer lion, Integer panda, Integer monkey, Integer rabbit, Integer bird, Integer silverShark, Integer bomb, Integer goldShark, Integer beast, Integer totalBet, Float singleBet, Float totalPrice) {
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
        this.single_bet = singleBet;
        this.totalPrice = totalPrice;
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

    public Float getSingle_bet() {
		return single_bet;
	}


	public void setSingle_bet(Float single_bet) {
		this.single_bet = single_bet;
	}

    public Float getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
   








}