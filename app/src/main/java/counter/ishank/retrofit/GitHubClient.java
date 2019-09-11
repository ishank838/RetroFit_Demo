package counter.ishank.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {
    @GET("posts")
    Call<List<GitHubRepo>> getPosts();
}
