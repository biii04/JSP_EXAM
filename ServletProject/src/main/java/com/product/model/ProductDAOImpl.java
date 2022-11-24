package com.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {
	private static ProductDAO instance = new ProductDAOImpl();

	public static ProductDAO getInstance() {
		return instance;
	}

	@Override
	public void productInsert(Product product) {
		 Connection con = null;
			PreparedStatement ps = null;
			 
			try {  
				con = DBConnection.getConnection();
				StringBuilder sb = new StringBuilder();
				sb.append("insert into  product");
				sb.append("(p_productId,p_pname,p_unitPrice, p_description, p_category,p_manufacturer, ");
				sb.append(" p_unitsInStock, p_condition,p_fileName)");
				sb.append(" values(product_seq.nextval, ?,?,?,?,?,?,?,?)");
			   ps = con.prepareStatement(sb.toString());
			   ps.setString(1, product.getPname());
			   ps.setInt(2, product.getUnitPrice());
			   ps.setString(3, product.getDescription());
			   ps.setString(4, product.getCategory());
			   ps.setString(5, product.getManufacturer());
			   ps.setLong(6, product.getUnitsInStock());
			   ps.setString(7, product.getCondition());
			   ps.setString(8, product.getFilename());
			   ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeConnection(con, ps, null, null);
			}

	}

	@Override
	public ArrayList<Product> productAllfind() {
		Connection con = null;
	     Statement st = null;
	     ResultSet rs = null;
	     ArrayList<Product> parr = new ArrayList<>();
	     
	     try {
			con =DBConnection.getConnection();
			String sql="select * from product";
			st = con.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()) {
				Product product = new Product();
				product.setCategory(rs.getString("p_category"));
				product.setCondition(rs.getString("p_condition"));
				product.setDescription(rs.getString("p_description"));
				product.setFilename(rs.getString("p_fileName"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setPname(rs.getString("p_pname"));
				product.setProductId(rs.getInt("p_productId"));
				product.setUnitPrice(rs.getInt("p_unitPrice"));
				product.setUnitsInStock(rs.getInt("p_unitsInStock"));
				parr.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return parr;
	}

	@Override
	public Product findById(Long productId) {
		 Connection con = null;
	     Statement st = null;
	     ResultSet rs = null;
	     Product product = null;
	     
	     try {
			con =DBConnection.getConnection();
			String sql="select * from product where p_productId="+productId;
			st = con.createStatement();
			rs= st.executeQuery(sql);
			if(rs.next()) {
				 product = new Product();
				product.setCategory(rs.getString("p_category"));
				product.setCondition(rs.getString("p_condition"));
				product.setDescription(rs.getString("p_description"));
				product.setFilename(rs.getString("p_fileName"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setPname(rs.getString("p_pname"));
				product.setProductId(rs.getInt("p_productId"));
				product.setUnitPrice(rs.getInt("p_unitPrice"));
				product.setUnitsInStock(rs.getInt("p_unitsInStock"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return product;
	}

	// ´Ý±â
	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
