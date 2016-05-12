create view topproduct
as
 select mytop.prd_no, rank() over(order by mytop.gty desc) myrank 
 from (select prd_no,sum(qty) gty 
	from TB_ORDER_PRODUCT 
	group by prd_no 
	order by gty desc) mytop 
 where rownum<=8;
 
 select * from topproduct;
 
 select PRD_NO from topproduct;
 