package fahad.Jobhunter.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection="jobs")
public class Post
{
    String desc;
    int exp;
    String profile;
    String[] techs;


    public String getDesc() {
        return desc;
    }

    public int getExp() {
        return exp;
    }

    public String getProfile() {
        return profile;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "desc='" + desc + '\'' +
                ", exp=" + exp +
                ", profile='" + profile + '\'' +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
