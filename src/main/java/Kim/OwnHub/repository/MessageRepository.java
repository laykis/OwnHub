package Kim.OwnHub.repository;

import Kim.OwnHub.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<Message> findById(Long id);

    @Query("select m from Message AS m where m.status = '0' OR m.status = '2'")
    List<Message> findByReceiver(String uid);

    @Query("select m from Message AS m where m.status = '0' OR m.status = '1'")
    List<Message> findBySender(String uid);
}
