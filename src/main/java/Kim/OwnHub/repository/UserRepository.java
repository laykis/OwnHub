package Kim.OwnHub.repository;

import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUserId(String userId);

    List<UserInfo> findAllByName(String username);

    List<UserInfo> findAllByTeam(String team);
}
