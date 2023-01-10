package vn.edu.usth.onlinemusicplayer.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.onlinemusicplayer.SongPlaylist;
import vn.edu.usth.onlinemusicplayer.model.Popular;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    Context context;
    ArrayList<Popular> arrayPopularList;
    View view;

    public PopularAdapter(Context context, ArrayList<Popular> arrayPopularList ) {
        this.context = context;
        this.arrayPopularList = ArrayPopularlist;
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.genre_Popular,parent, false);
        return new PopularAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, final int position) {
        Popular popular = arrayPopularlist.get(position);
        holder.txtPopularName.setText(Popular.getPopularName());
        Picasso.get(/*context*/).load(Popular.getPopularImage()).into(holder.imgPopular);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SongPlaylistActivity.class);
                intent.putExtra("printPopularName", arrayPopularList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayPopularList != null ? arrayPopularList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPopular;
        TextView txtPopularName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPopular = itemView.findViewById(R.id.imageviewPopular);
            txtPopularName = itemView.findViewById(R.id.textviewPopular);
        }
    }}

