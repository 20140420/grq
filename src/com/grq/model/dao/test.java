package com.grq.model.dao;


import java.util.Iterator;
import java.util.List; 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 
import com.grq.model.pojo.shark.SharkConfig;

public class test {
	Session session = null;
	Transaction tx = null;
	public static void main(String[] args) {
		System.out.println("hibernate链接数据库MySQL的java代码");
		try {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session session=sf.openSession();
			List<?> catlist = null;
			catlist = session.createQuery("from SharkConfig").list();
			Transaction tx=session.beginTransaction();
			if (catlist != null) {
				Iterator<?> it = catlist.iterator();
				while (it.hasNext()) {
					SharkConfig sharkConfig = (SharkConfig) it.next();
					System.out.println("ID:" + sharkConfig.getId() 
							+ "  获取配置函数初始彩金池："+ sharkConfig.getInitialDividend()+"\n");
				}
			}
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("链接数据库错误。database connection error！");
			e.printStackTrace();
		}
 
	}
}
