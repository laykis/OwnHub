package Kim.OwnHub.repository;

import Kim.OwnHub.entity.Board;
import Kim.OwnHub.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    //게시판 식별키(Id)로 게시글 전체 반환
    List<Content> findById(String Id);





}
