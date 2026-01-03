package products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Updater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Product ID: ");;
		int id = sc.nextInt();
		
		System.out.print("Enter New Price: ");
		double price = sc.nextDouble();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dprom", "root", "root");
			
			String sql = "UPDATE products SET price = ? WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, price);
			ps.setInt(2, id);
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Updated Successfully");
			}else {
				System.out.println("Product Not Found");
			}
		
			ps.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();

	}

}
