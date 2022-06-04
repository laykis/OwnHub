package Kim.OwnHub.repository;


import Kim.OwnHub.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    //유저 계정Id로 유저 정보 반환
    UserInfo findByUserId(String userId);

    @Query("select u from UserInfo AS u where u.username = :username")
    List<UserInfo> findIdByUsername(@Param("username") String username);


    //유저 이름으로 유저 정보 반환
    List<UserInfo> findByUsername(String username);

    //팀 이름으로 유저 정보 반환
    List<UserInfo> findByTeam(String team);
}
