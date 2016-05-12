package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dto.ProductDTO;
import product.service.ProductService;
import product.service.ProductServiceImpl;
@WebServlet(name = "prdlist", urlPatterns = { "/prdlist.do" })
public class ProductListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String category = request.getParameter("category");
		String pathurl = request.getParameter("pathurl");
		String forwardview="";//forward될 view
		ProductService service = new ProductServiceImpl();
		//상품목록
		ArrayList<ProductDTO> prdlist
						= service.productlist(category);
		request.setAttribute("prdlist", prdlist);
		
		if(category==null){
			forwardview="/layout/indexLayout.jsp";
			//아코디언 이미지에 보여질 상품을 추가
			ArrayList<ProductDTO> toplist
							= service.searchTopProduct();
			request.setAttribute("toplist", toplist);
		}else{
			request.setAttribute("pathurl",pathurl);	
			forwardview="/layout/mainLayout.jsp";
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher(forwardview);
		rd.forward(request, response);
	}
}

