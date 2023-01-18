package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 * 회원가입 기능 , 로그인 , 회원 탈퇴 , 회원 수정 (현재 password만 수정)
 */
@Mapper
public interface UserRepository { // crud부터 만들기
    public int insert(@Param("username") String username, @Param("password") String password,
            @Param("email") String email);

    public List<User> findAll();

    public User findById(int id);

    public int updateById(int id, String password);

    public int deleteById(int id);

    // public User login(String username, String password);

    // public int delete(int id);

    // public int updatePassword(int id, String password);
}
