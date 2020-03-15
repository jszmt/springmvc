作业一：

wugz-mvc 工程中
url ： http://localhost:8080/demo/get  不验证权限 所有用户都可以访问

url ： http://localhost:8080/demo/query?name=wugz&username=lisi
@MySecurity({"zhangsan","lisi"}) username 是 zhangsan 或 lisi 的可以访问

注意：自己造几个用户以及url，上交作业时，文档提供哪个用户有哪个url的访问权限



作业二：

sss 工程中
访问地址为 ：http://localhost:8080/
用户名密码 admin/admin

【提交时统一数据库名test，用户名和密码root】