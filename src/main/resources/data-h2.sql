insert into product(name,producttype,size,price) values ('tomato','pizza','S',269.99);
insert into product(name,producttype,size,price) values ('tomato','pizza','M',322.99);
insert into product(name,producttype,size,price) values ('tomato','pizza','L',394.99);
insert into product(name,producttype,size,price) values ('cheese','pizza','S',269.99);
insert into product(name,producttype,size,price) values ('cheese','pizza','M',322.99);
insert into product(name,producttype,size,price) values ('cheese','pizza','L',394.99);


insert into employee_details(emp_Id,employee_Name,company_Id,company_Name) values ('INFI1','Yakub','INFI','INFOSYS');
insert into employee_details(emp_Id,employee_Name,company_Id,company_Name) values ('INFI1','Sumit','AMZ','AMAZON');
insert into employee_details(emp_Id,employee_Name,company_Id,company_Name) values ('INFI1','Akhil','FB','FACEBOOK');
insert into employee_details(emp_Id,employee_Name,company_Id,company_Name) values ('DEF','DEFAULT','DEF','DEFAULT');

insert into coupon(emp_Id,company_Id,product_Id,Coupon_Code,activated) values('INFI1','INFI','1','BUYTWOFREEONE',true);

insert into coupon_details(applicable_product_id,offer_product_id,coupon_code,description,discount_percentage,free_quantity,min_quantity,discount_type,coupon_id) 
values(1,1,'BUYTWOFREEONE','buy two med pizza get one free',0,1,2,'FREEOFFER',1);