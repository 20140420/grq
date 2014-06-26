package com.grq.model.pojo.shark;

import java.io.Serializable;
import java.util.Date;

import com.grq.model.pojo.user.Customer;

/**
 * 键盘十三个奖项下注信息
 * @author JiangQuan
 */
public class PanelInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
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
	
	// Constructors
	/** default constructor */
	public PanelInfo(){		
	}
	

	// Property accessors	

	public String getPanelBetId() {
		return panelBetId;
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
		return swallow;
	}


	public void setSwallow(Integer swallow) {
		this.swallow = swallow;
	}


	public Integer getPigeon() {
		return pigeon;
	}


	public void setPigeon(Integer pigeon) {
		this.pigeon = pigeon;
	}


	public Integer getPeafowl() {
		return peafowl;
	}


	public void setPeafowl(Integer peafowl) {
		this.peafowl = peafowl;
	}


	public Integer getEagle() {
		return eagle;
	}


	public void setEagle(Integer eagle) {
		this.eagle = eagle;
	}


	public Integer getLion() {
		return lion;
	}


	public void setLion(Integer lion) {
		this.lion = lion;
	}


	public Integer getPanda() {
		return panda;
	}


	public void setPanda(Integer panda) {
		this.panda = panda;
	}


	public Integer getMonkey() {
		return monkey;
	}


	public void setMonkey(Integer monkey) {
		this.monkey = monkey;
	}


	public Integer getRabbit() {
		return rabbit;
	}


	public void setRabbit(Integer rabbit) {
		this.rabbit = rabbit;
	}


	public Integer getBird() {
		return bird;
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
		return bomb;
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
		return beast;
	}


	public void setBeast(Integer beast) {
		this.beast = beast;
	}


	public Integer getTotalBet() {
		return totalBet;
	}


	public void setTotalBet(Integer totalBet) {
		this.totalBet = totalBet;
	}

}
