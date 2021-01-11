drop user MVC cascade;
create user MVC identified by JAVA;
grant connect, resource to MVC;

conn MVC/JAVA;