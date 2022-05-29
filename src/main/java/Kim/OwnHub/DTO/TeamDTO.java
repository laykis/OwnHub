package Kim.OwnHub.DTO;

import Kim.OwnHub.entity.Content;

import java.util.List;

public class TeamDTO {

    private String tname;
    private List<Content> contents;

    public String getTname() {

        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
