package courseTodo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf = conf.configure();
		
		SessionFactory hibernateFactory = conf.buildSessionFactory();
		return hibernateFactory;
	}
}
