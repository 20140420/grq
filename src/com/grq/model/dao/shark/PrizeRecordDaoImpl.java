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
import com.grq.model.pojo.shark.PrizeRecord;
@Repository("prizeRecordDao")
@Transactional
public class PrizeRecordDaoImpl extends DaoSupport<PrizeRecord> implements PrizeRecordDao {
	
	/** -------------------------------------------------------------------------------- */
	/**
	 * 直接链接数据表并返回一个存着所有记录的实体
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public static List<PrizeRecord> prizeRecordEntity(){
		List<PrizeRecord> prizeRecordList = null;
		try {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session session=sf.openSession();
			prizeRecordList = session.createQuery("from PrizeRecord").list();//将查询结果转化为List对象
			Transaction tx=session.beginTransaction();
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			System.out.println("链接数据库错误。database connection error！");
			e.printStackTrace();
		}
		return prizeRecordList;
	}
	/**
	 * 直接链接数据表保存记录奖项
	 * @param arg
	 */
	public static void savePrizeRecord(Object arg){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(arg);
		tx.commit();
		session.clear();
	}
}
