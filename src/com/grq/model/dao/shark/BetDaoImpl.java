package com.grq.model.dao.shark;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grq.model.dao.DaoSupport;
import com.grq.model.pojo.shark.PanelInfo;
@Repository("betDao")
@Transactional
public class BetDaoImpl extends DaoSupport<PanelInfo> implements BetDao {

	/** -------------------------------------------------------------------------------- */
	/**
	 * 直接链接数据表并返回一个存着所有下注单的实体
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public static List<PanelInfo> betEntity() {
		List<PanelInfo> panelInfoList = null;
		try {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session session=sf.openSession();
			panelInfoList = session.createQuery("from PanelInfo where betCount = false").list();//查询未出奖的下单记录结果并转化为List对象
			Transaction tx=session.beginTransaction();
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			System.out.println("链接数据库错误。database connection error！");
			e.printStackTrace();
		}
		return panelInfoList;
	}
	/**
	 * 直接链接数据表更新下注单
	 * @param arg
	 */
	public static void updateBet(Object arg){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(arg);
		tx.commit();
		session.clear();
	}
}
