package com.grq.model.bean;

import java.io.Serializable;
import java.util.Random;

public class PanelDataBean implements Serializable{

	/**
	 * ��������
	 */
	private static final long serialVersionUID = 1L;
    private int prize;                //���� �Ժ�ĳ�pojo���󣬼�����6��è
    private int times;                //Ĭ���ޱ���
    private int chip;                   //����
    private boolean success  = false;   //Ĭ��δ�н�
    private Random random = new Random();
    
    public PanelDataBean() {
        reset();
    }
    /**
     * ���ñ�������ע����
     */
    public void reset() {
    	
        //setSuccess(false);
    	success = false;
        times = 0;
        chip = 0;
    }
    /**
     * ��6�鱶�������һ��
     */
    public void createPrizeTimes(){
    	times = Math.abs(random.nextInt() % 6) + 1;
    }
    /**
     * ���ɽ������ϸ��
     */
    public void createPrize(){
    	prize = Math.abs(random.nextInt() % 8) + 1;
    }
    
    // Property accessors��getter��settter������
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
