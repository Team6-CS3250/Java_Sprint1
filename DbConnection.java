import java.sql.*;
import java.util.ArrayList;
public class DbConnection {
	
	// Connect to database
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:inventory.db");
			System.out.println("Connected");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.toString());
			}
		}
		return con;
	}
	
	// Create new entry in database
	public static void Create(String product_id, int quantity, double wholesale_cost, double sale_price, String supplier_id)
	{
		Connection con = connect();
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO Inventory(product_id, quantity, wholesale_cost, sale_price, supplier_id) VALUES(?, ?, ?, ?, ?)";
			ps = con.prepareStatement(query);
			ps.setString(1,  product_id);
			ps.setInt(2, quantity);
			ps.setDouble(3, wholesale_cost);
			ps.setDouble(4, sale_price);
			ps.setString(5, supplier_id);
			ps.execute();
			System.out.println("Inserted");
		} catch(SQLException e)
		{
			System.out.println(e.toString());
		}
	}
	
	// Get list of all entries in database
	public static ArrayList<InventoryData> ReadAll()
	{
		ArrayList<InventoryData> inventoryDataList = new ArrayList<InventoryData>();
		Connection con = connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM inventory";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String product_id = rs.getString(1);
				int quantity = rs.getInt(2);
				double wholesale_cost = rs.getDouble(3);
				double sale_price = rs.getDouble(4);
				String supplier_id = rs.getString(5);
				inventoryDataList.add(new InventoryData(product_id, quantity, wholesale_cost, sale_price, supplier_id));
			}
		} catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch(SQLException e)
			{
				System.out.println(e.toString());
			}
		}
		return inventoryDataList;
	}

	// Update the full document
	public static void update(String product_id, int quantity, double wholesale_cost, double sale_price, String supplier_id) {

		String queryUp = "Update Inventory(product_id, quantity, wholesale_cost, sale_price, supplier_id) VALUES(?, ?, ?, ?, ?)";
		
		Connection con = connect();
		PreparedStatement psUp = null;

		try {
			psUp = con.prepareStatement(queryUp);

			psUp.setString(1,  product_id);
			psUp.setInt(2, quantity);
			psUp.setDouble(3, wholesale_cost);
			psUp.setDouble(4, sale_price);
			psUp.setString(5, supplier_id);

			psUp.executeUpdate();
			System.out.println("Updated!");

		} catch(SQLException e) {
			System.out.println(e.toString());
		}
	}

	// Delete full document
	public static void delete(String product_id, int quantity, double wholesale_cost, double sale_price, String supplier_id) {
		String queryDel = "Delete all database entries!";

		Connection con = connect();
		PreparedStatement psDel = null;

		try {
			psDel = con.prepareStatement(queryDel);

			psDel.setString(1,  product_id);
			psDel.setInt(2, quantity);
			psDel.setDouble(3, wholesale_cost);
			psDel.setDouble(4, sale_price);
			psDel.setString(5, supplier_id);

			psDel.executeUpdate();
			System.out.println("Deleted!");

		} catch(SQLException e) {
			System.out.println(e.toString());
		}
	}
}
