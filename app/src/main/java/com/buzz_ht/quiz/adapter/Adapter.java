package com.buzz_ht.quiz.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzz_ht.quiz.QuestionActivity;
import com.buzz_ht.quiz.R;
import com.buzz_ht.quiz.model.Quiz;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    List<Quiz> list;

    public Adapter(Context context, List<Quiz> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.topic.setText(list.get(position).getTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (list.get(position).getID()) {

                    case 1:
                        Intent i1 = new Intent(context, QuestionActivity.class);
                        i1.putExtra("Case", 1);
                        context.startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(context, QuestionActivity.class);
                        i2.putExtra("Case", 2);
                        context.startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(context, QuestionActivity.class);
                        i3.putExtra("Case", 3);
                        context.startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(context, QuestionActivity.class);
                        i4.putExtra("Case", 4);
                        context.startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(context, QuestionActivity.class);
                        i5.putExtra("Case", 5);
                        context.startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(context, QuestionActivity.class);
                        i6.putExtra("Case", 6);
                        context.startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(context, QuestionActivity.class);
                        i7.putExtra("Case", 7);
                        context.startActivity(i7);
                        break;

                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView topic;
        MaterialCardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            topic = itemView.findViewById(R.id.topic);
            cardView = itemView.findViewById(R.id.cardContainer);


        }
    }


}
