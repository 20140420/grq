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
	public static void main(String[] args) {
		System.out.println("hibernate链接数据库MySQL的java代码");
		SharkConfig config = connSharkConfig();
		System.out.println(" 配置初始彩金池: "+config.getInitialDividend());
	}
	public static SharkConfig connSharkConfig(){
		SharkConfig sharkConfig = null;
		System.out.println("connSharkConfig()的java代码");
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
					System.out.println("ID:" + sharkConfig.getId() + "  获取配置函数初始彩金池："+ sharkConfig.getInitialDividend()+"\n");
				}
			}
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("链接数据库错误。database connection error！");
			e.printStackTrace();
		}
		
		System.out.println("返回最后一条配置记录初始彩金池："+ sharkConfig.getInitialDividend()+"\n");
		return sharkConfig;
	}
}
