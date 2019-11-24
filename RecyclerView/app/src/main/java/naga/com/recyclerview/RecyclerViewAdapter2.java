package naga.com.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
    private ArrayList imageNames = new ArrayList<>();
    private ArrayList imageUrls = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter2(Context context, ArrayList imageNames, ArrayList imageUrls) {
        this.imageNames = imageNames;
        this.imageUrls = imageUrls;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter2.ViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(imageUrls.get(position))
                .into(holder.image);

        holder.imageName.setText((String) imageNames.get(position));

    }

    // Very important, without this no item will be shown
    @Override
    public int getItemCount() {
        return imageNames.size();
    }

    // This class contains the elements of one item in the list
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView imageName;
        CircleImageView image;

        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}