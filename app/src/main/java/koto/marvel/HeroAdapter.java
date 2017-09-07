package koto.marvel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import koto.marvel.Models.SuperHero;

/**
 * Created by KOTO on 02/09/2017.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    ArrayList<SuperHero> superHeroArrayList;
    Context context;

    public HeroAdapter(ArrayList<SuperHero> superHeroArrayList, Context context) {
        this.superHeroArrayList = superHeroArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hero_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SuperHero superHero = superHeroArrayList.get(position);

        holder.heroDetailNameTextView.setText(superHero.getName());
        Picasso.with(context).load(superHero.getThumbnail().getFullPath()).into(holder.heroPictureImageView);

    }

    @Override
    public int getItemCount() {
        return superHeroArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heroDetailNameTextView;
        ImageView heroPictureImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            heroDetailNameTextView = (TextView) itemView.findViewById(R.id.heroDetailNameTextView);
            heroPictureImageView = (ImageView) itemView.findViewById(R.id.heroPictureImageView);

        }
    }

}
