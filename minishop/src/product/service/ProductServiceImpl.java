package product.service;

import static fw.JdpcTemplate.getConnect;
import static fw.JdpcTemplate.close;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import product.dao.ProductDAO;
import product.dao.ProductDAOImpl;
import product.dto.ProductDTO;

public class ProductServiceImpl implements ProductService {

	@Override
	public ArrayList<ProductDTO> productlist(String category) {
		Connection conn = getConnect();	//目池记掘扁
		ProductDAO dao = new ProductDAOImpl();
		ArrayList<ProductDTO> productlist = null;
		try{
			productlist = dao.productlist(conn,category);			
		}catch(SQLException e){
			e.printStackTrace();
		}
		close(null, null, conn);
		return productlist;
	}

	@Override
	public ArrayList<ProductDTO> searchTopProduct() {
		Connection conn = getConnect();	//目池记掘扁
		ProductDAO dao = new ProductDAOImpl();
		ArrayList<ProductDTO> productlist = null;
		try{
			productlist = dao.searchTopProduct(conn);			
		}catch(SQLException e){
			e.printStackTrace();
		}
		close(null, null, conn);
		return productlist;
	}
	public static void main(String[] args){
		ProductServiceImpl obj = new ProductServiceImpl();
		System.out.println(obj.searchTopProduct().size());
	}
	@Override
	public ProductDTO read(String prd_no) {
		// TODO Auto-generated method stub
		return null;
	}

}
