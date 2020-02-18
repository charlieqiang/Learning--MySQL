/**
 * @Description test mysql
 * @author Charlie
 * @date 2020-02-18 10:44
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String sql = "jdbc:mysql://localhost:3306/mydb1?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String passwd = "123456";
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(sql,user,passwd);
			ps = ct.prepareStatement("select * from stu");
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ct!=null)
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
