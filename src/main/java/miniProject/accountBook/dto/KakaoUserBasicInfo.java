package miniProject.accountBook.dto;

public class KakaoUserBasicInfo {

    private Long id;
    private String email;
    private String nickname;

    public KakaoUserBasicInfo(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    public KakaoUserBasicInfo() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "KakaoUserBasicInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
