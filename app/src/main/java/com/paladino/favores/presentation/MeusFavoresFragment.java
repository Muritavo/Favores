package com.paladino.favores.presentation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paladino.favores.R;
import com.paladino.favores.pesistence.entidades.Favor;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MeusFavoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeusFavoresFragment extends Fragment {
    private MeusFavoresFragmentInterface fragmentInterface;
    private List<Favor> meusFavores;

    public MeusFavoresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MeusFavoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeusFavoresFragment newInstance() {
        return new MeusFavoresFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        meusFavores = fragmentInterface.geMeusFavores();
        super.onStart();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();
        fragmentInterface = (MeusFavoresFragmentInterface) fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favores_meus_favores, container, false);
        RecyclerView recyclerView =(RecyclerView)view.findViewById(R.id.lista_favores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter());
        // Inflate the layout for this fragment
        return view;
    }

    public interface MeusFavoresFragmentInterface {
        List<Favor> geMeusFavores();
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FavorHolder> {
        class FavorHolder extends RecyclerView.ViewHolder {
            FavorHolder(View itemView) {
                super(itemView);
            }
        }

        @Override
        public FavorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_favor_row, parent, false);
            return new FavorHolder(v);
        }

        @Override
        public void onBindViewHolder(FavorHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return meusFavores.size();
        }
    }
}
