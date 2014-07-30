package com.grq.model.dao.shark;

import java.util.Iterator;
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
import com.grq.model.pojo.shark.SharkConfig;
@Repository("sharkConfigDao")
@Transactional
public class SharkConfigDaoImpl extends DaoSupport<SharkConfig> implements SharkConfigDao {
	
	/** -------------------------------------------------------------------------------- */
	/**
	 * 直接链接数据库配置表并返回最后一条配置对象
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public static SharkConfig lastSharkConfig(){
		SharkConfig sharkConfig = null;
		try {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session session=sf.openSession();
			List<?> list = null;
			list = session.createQuery("from SharkConfig").list();//将查询结果转化为List对象
			Transaction tx=session.beginTransaction();
			if (list != null) {
				Iterator<?> it = list.iterator();
				while (it.hasNext()) {
					sharkConfig = (SharkConfig) it.next();
					//System.out.println("ID:" + sharkConfig.getId() + 
					//		"  获取配置函数初始彩金池："+ sharkConfig.getInitialDividend()+"\n");
				}
			}
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			System.out.println("链接数据库错误。database connection error！");
			e.printStackTrace();
		}
		//System.out.println("返回最后一条配置记录初始彩金池："+ sharkConfig.getInitialDividend()+"\n");
		return sharkConfig;
	}
	
}
