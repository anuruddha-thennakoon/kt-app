package com.variant.ktapp.ui.doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.variant.ktapp.R;
import com.variant.ktapp.model.Patients;

import java.util.List;

public class DoctorsPatientsAdapter extends RecyclerView.Adapter<DoctorsPatientsAdapter.ViewHolder> {

    private ItemClickListener itemClickListener;
    private LayoutInflater inflater;
    private List<Patients> patientsList;
    private Context context;
    public int clickedPosition = -1;

    public DoctorsPatientsAdapter(Context context, ItemClickListener itemClickListener, List<Patients> patientsList) {
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.inflater = LayoutInflater.from(context);
        this.patientsList = patientsList;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public DoctorsPatientsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_row_patients, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, itemClickListener, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsPatientsAdapter.ViewHolder holder, int position) {

        Patients patients = getItem(position);
        holder.tvPatentsName.setText(patients.getPatientName());
        holder.tvWoundCount.setText(String.valueOf(patients.getWoundCount()));
        holder.tvLastUpdateDate.setText(""+patients.getUpdateTime());
        if (patients.isEmgeancy()) {
            holder.tvIconWarning.setVisibility(View.VISIBLE);
        }else {
            holder.tvIconWarning.setVisibility(View.GONE);
        }

        holder.patentsDetailsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return patientsList.size();
    }

    public Patients getItem(int position) {
        return patientsList.get(position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPatentsName,tvWoundCount,tvLastUpdateDate,tvIconWarning;
        public RelativeLayout patentsDetailsContainer;

        public ViewHolder(View v, ItemClickListener clickListener, DoctorsPatientsAdapter cardAdapter) {
            super(v);
            tvPatentsName = v.findViewById(R.id.tvPatentsName);
            tvWoundCount = v.findViewById(R.id.tvWoundCount);
            tvLastUpdateDate = v.findViewById(R.id.tvLastUpdateDate);
            tvIconWarning = v.findViewById(R.id.tvIconWarning);
            patentsDetailsContainer = v.findViewById(R.id.patentsDetailsContainer);

        }
    }
}
