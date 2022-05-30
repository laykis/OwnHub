package Kim.OwnHub.repository;

import Kim.OwnHub.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    //Id 매개변수를 String 으로 받는 조회 문
    Optional<Content> findById(Long id);

    //부서 Id로 조회
    List<Content> findByCboard(String boardId);

    //유저 Id로 조회
    List<Content> findByCuid(String cuid);

    //게시글 제목 조회
    List<Content> findByTitle(String title);
}
