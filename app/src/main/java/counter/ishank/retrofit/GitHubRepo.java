package counter.ishank.retrofit;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {
    @SerializedName("id")
    private int id;
    @SerializedName("userId")
    private int user_id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
