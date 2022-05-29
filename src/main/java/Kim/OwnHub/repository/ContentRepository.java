package Kim.OwnHub.repository;

import Kim.OwnHub.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findByCboard(String boardId);

    List<Content> findByTitle(String title);
}
