package com.grq.model.dao;

import java.util.List; 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 

import com.grq.model.pojo.shark.PanelInfo;

public class test {
	public static void main(String[] args) {
		System.out.println("hibernate链接数据库MySQL的java代码");
		List<PanelInfo> betEntity = betEntity();
		if(betEntity != null && betEntity.size() >0){
			for(PanelInfo panelInfo : betEntity){//遍历所有的下注条目
				System.out.println(" 下注单的ID: "+panelInfo.getPanelBetId());
				boolean betCount = panelInfo.getBetCount();//获得条目统计状态
				if(betCount == false){//如果条目未操作过
					panelInfo.setBetCount(true);// 更改筹码统计状态
					update(panelInfo);//更新
				}				
			}
		} else {
			System.out.println("无人下注");
		}
	}
	@SuppressWarnings("unchecked")
	public static List<PanelInfo> betEntity() {
		List<PanelInfo> panelInfoList = null;
		//PanelInfo panelInfo = null;
		try {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session session=sf.openSession();
			panelInfoList = session.createQuery("from PanelInfo").list();//查询未出奖的下单记录结果并转化为List对象
			Transaction tx=session.beginTransaction();
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			System.out.println("链接数据库错误。database connection error！");
			e.printStackTrace();
		}
		return panelInfoList;
	}
	public static void update(Object arg){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(arg);
		tx.commit();
		session.clear();
	}
}
