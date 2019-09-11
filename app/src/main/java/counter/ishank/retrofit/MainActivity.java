package counter.ishank.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String repo_url="https://jsonplaceholder.typicode.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(repo_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubClient client=retrofit.create(GitHubClient.class);
        Call<List<GitHubRepo>> call = client.getPosts();
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                if(response.isSuccessful()) {
                    List<GitHubRepo> repo = response.body();
                    RecyclerView listView = (RecyclerView) findViewById(R.id.recyclelist);
                    listView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    listView.setAdapter(new ListAdapter(repo));
                    Toast.makeText(MainActivity.this,"Data fetched",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Failed to fetch",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();
            }
        });

    }
}
