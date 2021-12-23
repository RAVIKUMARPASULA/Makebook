package com.createiq.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	private static SessionFactory factory=null;
	static {
		Configuration configuration= new Configuration();
		configuration.configure();
		factory=configuration.buildSessionFactory();
	}
	public static Session getSession() {
		return	factory.openSession();
		}
		public static void close(Session session) {
			if(session!=null) {
				session.close();
			}
		}
public static void main(String[] args) {
	System.out.println(ConnectionUtil.getSession());
}
}
