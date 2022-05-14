package Kim.OwnHub.DTO;

public class BoardDTO {

    public Long id;
    public String bname;
    public String bauth;
    public String bteam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauth() {
        return bauth;
    }

    public void setBauth(String bauth) {
        this.bauth = bauth;
    }

    public String getBteam() {
        return bteam;
    }

    public void setBteam(String bteam) {
        this.bteam = bteam;
    }
}
