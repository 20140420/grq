package com.grq.model.pojo.shark;

import java.io.Serializable;
import java.util.Date;

/**
 * 键盘十三个奖项信息
 * @author JiangQuan
 */
public class PanelInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	private Integer id;// 编号
	private Date createTime = new Date();// 提交时间即截止时间
	private String swallow;// 燕子
	private String pigeon;// 鸽子
	private String peafowl;// 孔雀
	private String eagle;// 老鹰
	private String lion;// 狮子
	private String panda;// 熊猫
	private String monkey;// 猴子
	private String rabbit;// 兔子
	private String bird;// 飞禽
	private String silver_shark;// 银鲨
	private String bomb;// 炸弹
	private String gold_shark;// 金鲨
	private String beast;// 走兽
	
	// Constructors
	/** default constructor */
	public PanelInfo(){		
	}
	

	// Property accessors	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getSwallow() {
		return swallow;
	}


	public void setSwallow(String swallow) {
		this.swallow = swallow;
	}


	public String getPigeon() {
		return pigeon;
	}


	public void setPigeon(String pigeon) {
		this.pigeon = pigeon;
	}


	public String getPeafowl() {
		return peafowl;
	}


	public void setPeafowl(String peafowl) {
		this.peafowl = peafowl;
	}


	public String getEagle() {
		return eagle;
	}


	public void setEagle(String eagle) {
		this.eagle = eagle;
	}


	public String getLion() {
		return lion;
	}


	public void setLion(String lion) {
		this.lion = lion;
	}


	public String getPanda() {
		return panda;
	}


	public void setPanda(String panda) {
		this.panda = panda;
	}


	public String getMonkey() {
		return monkey;
	}


	public void setMonkey(String monkey) {
		this.monkey = monkey;
	}


	public String getRabbit() {
		return rabbit;
	}


	public void setRabbit(String rabbit) {
		this.rabbit = rabbit;
	}


	public String getBird() {
		return bird;
	}


	public void setBird(String bird) {
		this.bird = bird;
	}


	public String getSilver_shark() {
		return silver_shark;
	}


	public void setSilver_shark(String silver_shark) {
		this.silver_shark = silver_shark;
	}


	public String getBomb() {
		return bomb;
	}


	public void setBomb(String bomb) {
		this.bomb = bomb;
	}


	public String getGold_shark() {
		return gold_shark;
	}


	public void setGold_shark(String gold_shark) {
		this.gold_shark = gold_shark;
	}


	public String getBeast() {
		return beast;
	}


	public void setBeast(String beast) {
		this.beast = beast;
	}
	
	
	
}
