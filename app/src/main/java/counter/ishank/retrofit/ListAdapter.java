package counter.ishank.retrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    List<GitHubRepo> repos;
    public ListAdapter(List<GitHubRepo> repo)
    {
        this.repos=repo;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inFlater=LayoutInflater.from(viewGroup.getContext());
        View view=inFlater.inflate(R.layout.list_layout,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        int id_val=repos.get(i).getId();
        listViewHolder.idT.setText(Integer.toString(id_val));
        listViewHolder.user_id.setText(Integer.toString(repos.get(i).getUser_id()));
        listViewHolder.body.setText((repos.get(i).getBody()));
        listViewHolder.title.setText(repos.get(i).getTitle());
    }



    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView idT;
        TextView user_id;
        TextView title;
        TextView body;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            idT=(TextView)itemView.findViewById(R.id.item_name);
            user_id=(TextView)itemView.findViewById(R.id.item_age);
            body=itemView.findViewById(R.id.item_body);
            title=itemView.findViewById(R.id.iten_title);
        }
    }
}
