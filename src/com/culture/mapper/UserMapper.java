package com.culture.mapper;
 


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.culture.model.User;




public interface UserMapper {
	@Select("select * from users where id = #{id}")
    User findUserById(int id);

    @Select("select * from users where username = #{username}")
    User findUserByUsername(String username);
    //
//    @Select("select id,username,password,phone,email,addtime,state from user")
//    List<User> findUserList();
    //
//    @Select("select * from user where username = #{username}")
//    User findUser(String username);
//    //
//    @Options(useGeneratedKeys=true,useCache=false,
//    		statementType=StatementType.PREPARED,
//    		keyProperty="id",keyColumn="id")
//    @Insert("insert into "
//    		+ "user(username,password,phone,email,addtime,state) "
//    		+ "values(#{username},#{password},#{phone},#{email},#{addtime},#{state})")
//    int addUser(User user);
//    //
//    @Delete("delete from user where id = #{id}")
//    int deleteUser(User user);
//    //
//    @Update("update user set "
//    		+ "username = #{username},password = #{password},phone = #{phone},"
//    		+ "email = #{email},addtime = #{addtime},state = #{state} where id = #{id}")
//    int updateUser(User user);
//    
//    @Options(useGeneratedKeys=true,useCache=false,
//    		statementType=StatementType.PREPARED,
//    		keyProperty="id",keyColumn="id")
//
//    @Delete("delete from user_role where id = #{id}")
//    int deleteUserRoleById(String id);
    @Select("select * from users where username = #{username}")
	User findUserByusername(String username);
    
  /*  List<User> findUserRoleByUserId(String id);*/
}
 