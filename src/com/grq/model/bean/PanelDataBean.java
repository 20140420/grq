package com.grq.model.bean;

import java.io.Serializable;
import java.util.Random;

public class PanelDataBean implements Serializable{

	/**
	 * 键盘数据
	 */
	private static final long serialVersionUID = 1L;
    private int prize;                //奖项 以后改成pojo对象，假设是6熊猫
    private int times;                //默认无倍数
    private int chip;                   //筹码
    private boolean success  = false;   //默认未中奖
    private Random random = new Random();
    
    public PanelDataBean() {
        reset();
    }
    /**
     * 重置倍数、下注筹码
     */
    public void reset() {
    	
        //setSuccess(false);
    	success = false;
        times = 0;
        chip = 0;
    }
    /**
     * 从6组倍数中随机一组
     */
    public void createPrizeTimes(){
    	times = Math.abs(random.nextInt() % 6) + 1;
    }
    /**
     * 生成奖项（待详细）
     */
    public void createPrize(){
    	prize = Math.abs(random.nextInt() % 8) + 1;
    }
    
    // Property accessors（getter和settter方法）
	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getChip() {
		return chip;
	}

	public void setChip(int chip) {
		this.chip = chip;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
