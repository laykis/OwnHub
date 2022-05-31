package Kim.OwnHub.DTO;

import Kim.OwnHub.entity.UserInfo;
import lombok.Data;

@Data
public class ScheduleDTO {

    private Long id;
    private String sdate;
    private String edate;
    private String stitle;
    private String scontent;
    private String s_status;
    private String suid;

}
