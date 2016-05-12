<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="product.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="shortcut icon" href="/minishop/common/favicon.ico">
<link rel="stylesheet" type="text/css" href="/minishop/common/css/demo.css" />
<link rel="stylesheet" type="text/css" href="/minishop/common/css/style.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700,300,300italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/minishop/common/js/modernizr.custom.79639.js"></script>
</head>
<body>
	
	<div class="container">
		<%ArrayList<ProductDTO> toplist = (ArrayList<ProductDTO>) request.getAttribute("toplist");%>		
			
			<section class="main">
			
				<div class="ia-container">
				<%
				int size = toplist.size();
				for(int i=0;i<size;i++){
					ProductDTO pro = toplist.get(i);
				%>
					<figure>
						<img src="/minishop/images/product/<%=pro.getImg_gen_file_nm() %>" alt="image01" />
						<input type="radio" name="radio-set" checked="checked"/>
						<figcaption><span><%=pro.getPrd_nm() %></span></figcaption>
						
					<%} %>	
												</figure>
												
											</figure>
								
										</figure>	
											
									</figure>	
										
								</figure>
									
							</figure>
							
						</figure>
						
					</figure>
					
				</div><!-- ia-container -->
				
			</section>
			
        </div>
</body>
</html>