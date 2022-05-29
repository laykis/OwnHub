package Kim.OwnHub.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class ContentDTO {

    private String title;
    private String content;
    private Date wdate;
    private String cteam;
    private String cboard;
    private String cuid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public String getCteam() {
        return cteam;
    }

    public void setCteam(String cteam) {
        this.cteam = cteam;
    }

    public String getCboard() {
        return cboard;
    }

    public void setCboard(String cboard) {
        this.cboard = cboard;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }
}
