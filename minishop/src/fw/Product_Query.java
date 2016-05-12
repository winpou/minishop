package fw;

//SQL만 정의하는 클래스 - 프레임워크 기반으로 작업을 하면 설정파일 (XML)로 변경됨
public class Product_Query {
	public static String PRODUCT_LIST = "select * from tb_product";
	public static String PRODUCT_LIST_CATE = "select * from tb_product where category_no=?";
	
	/*
	create view topproduct
	as
	select rownum, mytop.prd_no, rank() over(order by mytop.gty desc) myrank 
 	from (select prd_no,sum(qty) gty 
	from TB_ORDER_PRODUCT 
	group by prd_no 
	order by gty desc) mytop 
 	where rownum<=8;
	 */
	
	public static String PRODUCT_TOP = 
			"select PRD_NO, PRD_NM, IMG_GEN_FILE_NM "
			+ "from tb_product "
			+ "where PRD_NO in(select PRD_NO from topproduct)";
}
