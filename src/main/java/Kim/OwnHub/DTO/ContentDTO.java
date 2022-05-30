package Kim.OwnHub.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class ContentDTO {

    private Long id;
    private String title;
    private String content;
    private String wdate;
    private String cteam;
    private String cboard;
    private String cuid;


}
