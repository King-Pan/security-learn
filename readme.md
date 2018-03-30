# Spring Security5中SecutiryConfig中必须指定一个PasswordEncoder不然将会报一下错误。


```java
java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
```

##解决方法

```java
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(arg0.toString());
    }

}
```

##初始化脚本

```sql
insert  into `sys_role`(`id`,`name`)
values (1,'ROLE_USER'),(2,'ROLE_VIP'),(3,'ROLE_ADMIN'),(4,'ROLE_SUPER_ADMIN');
insert  into `sys_user`(`id`,`password`,`username`)
values (1,'user','user'),(2,'vip','vip'),(3,'admin','admin'),(4,'sadmin','sadmin');
insert  into `sys_user_roles`(`sys_user_id`,`roles_id`) values (1,1),(2,2),(3,3),(4,4);
```