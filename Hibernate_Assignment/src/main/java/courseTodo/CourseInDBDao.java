package courseTodo;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.ArrayList;

public class CourseInDBDao implements DaoInterface<Course,Integer>{

	@Override
	public void createNew(Course newCourse) {
		// TODO Auto-generated method stub
		try(
                Connection conn = JdbcUtils.buildConnection();
        ){
            String sqlQuery =
                    "insert into course_master(course_id,course_title,course_duration,course_provider,course_cost) values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            int id = newCourse.getCourseId();
            String name = newCourse.getTitle();
            int durat = newCourse.getDuration();
            double costt = newCourse.getCost();
            String provider=newCourse.getProvider();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, durat);
            pstmt.setDouble(5, costt);
            pstmt.setString(4,provider);
            int count = pstmt.executeUpdate();
            System.out.println(count + " record added.");
        }

        catch(Exception ex) {
            ex.printStackTrace();
        }
	}

	@Override
	public Course getOneById(Integer id) {
		// TODO Auto-generated method stub
		 Course foundCourse = null;
         try(
                 Connection conn = JdbcUtils.buildConnection();
         ){
             String sqlQuery =
                     "select * from course_master where course_id = ?";
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
             pstmt.setInt(1, id);
             ResultSet rs = 	pstmt.executeQuery();
             if(rs.next()) {//If record is found
                 int cId = rs.getInt(1);
                 String cName = rs.getString(2);
                 String provider = rs.getString(4);
                 int duration = rs.getInt(3);
                 double costt=rs.getDouble(5);
                 foundCourse =
                         new Course(cId,cName,duration,provider,costt);
             }
         }
         catch(Exception ex) {
             ex.printStackTrace();
         }
         return foundCourse;
     
	}

	@Override
	public void update(Integer id) {
		// TODO Auto-generated method stub
		try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSassion = hibernateFctory.openSession();
				){
			Class<Course> courseClass = Course.class;
			Serializable ID = id;
			Course foundCourse = hibernateSassion.load(courseClass,ID);
			System.out.println("Enter updated cost = ");
			Scanner sc = new Scanner(System.in);
			double cost = sc.nextInt();
			Transaction hibernateTransaction = hibernateSassion.beginTransaction();
			foundCourse.setCost(cost);
			hibernateTransaction.commit();
			System.out.println("Record updated.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		try(
                Connection conn = JdbcUtils.buildConnection();
        ){
            String sqlQuery =
                    "delete from course_master where course_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, id);
            int deleteCount = pstmt.executeUpdate();
            System.out.println(deleteCount + " record deleted");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
	}

	
	
	

	}
	


