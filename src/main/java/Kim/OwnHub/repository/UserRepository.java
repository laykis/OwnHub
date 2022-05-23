package Kim.OwnHub.repository;


import Kim.OwnHub.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    //유저 계정Id로 유저 정보 반환
    UserInfo findByUserId(String userId);

    //유저 이름으로 유저 정보 반환
    List<UserInfo> findByUsername(String username);

    //팀 이름으로 유저 정보 반환
    List<UserInfo> findByTeam(String team);
}
