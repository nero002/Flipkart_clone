package com.nero.flipkart.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.nero.flipkart.Model.LanguageModel;
import com.nero.flipkart.R;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {

    private int selectedLanguagePosition = -1;
    private List<LanguageModel> languageModelList;
    private Context c;
    private AdapterView.OnItemClickListener onItemClickListener;

    public LanguageAdapter(List<LanguageModel> list, Context context) {
        this.languageModelList = list;
        this.c = context;
        Log.d("madhuri patel", "LanguageAdapter: "+ list);
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.language_item, parent, false);
        return new LanguageViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
        LanguageModel model = languageModelList.get(position);
        holder.bindData(model, position);
    }

    @Override
    public int getItemCount() {
        return languageModelList.size();
    }

//    @param onItemClickListener
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public void onItemHolderClick(LanguageViewHolder holder){
        if(onItemClickListener != null){
            onItemClickListener.onItemClick(null, holder.itemView,
                    holder.getAdapterPosition(), holder.getItemId());
        }
    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LanguageAdapter mAdapter;
        private RadioButton mRadioButton;
        private TextView languageName, languageLocal;
        private ImageView imgPlace;

        public LanguageViewHolder(@NonNull View itemView, LanguageAdapter languageAdapter) {
            super(itemView);
            this.mAdapter = languageAdapter;
            initViews(itemView);
            itemView.setOnClickListener(this);
            mRadioButton.setOnClickListener(this);
        }


        private void initViews(View itemView) {
            languageName = itemView.findViewById(R.id.tvLanguageName);
            languageLocal = itemView.findViewById(R.id.tvLanguageLocal);
            imgPlace = itemView.findViewById(R.id.ivPlace);
            mRadioButton = itemView.findViewById(R.id.radioButton);
        }

        @Override
        public void onClick(View v) {
            selectedLanguagePosition = getAdapterPosition();
            notifyItemRangeChanged(0, languageModelList.size());
            mAdapter.onItemHolderClick(LanguageViewHolder.this);
        }

        public void bindData(LanguageModel model, int position) {
            mRadioButton.setChecked(position == selectedLanguagePosition);
            languageName.setText(model.getLangName());
            languageLocal.setText(model.getLangLocalName());
            imgPlace.setImageResource(model.getImgPlace());
        }
    }
}
