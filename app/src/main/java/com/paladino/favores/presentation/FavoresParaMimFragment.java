package com.paladino.favores.presentation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paladino.favores.R;
import com.paladino.favores.pesistence.entidades.Favor;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FavoresParaMimFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoresParaMimFragment extends Fragment {
    private FavoresParaMimFragmentInterface fragmentInterface;
    private List<Favor> favoresParaMim;
    private FavoresParaMimAdapter mAdapter;

    public FavoresParaMimFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavoresParaMimFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoresParaMimFragment newInstance() {
        return new FavoresParaMimFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        favoresParaMim = fragmentInterface.getFavoresParaMim();
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favores_para_mim, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.lista_favores);
        ((SearchView)view.findViewById(R.id.search_bar)).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                favoresParaMim = fragmentInterface.getFavoresParaMim(newText);
                mAdapter.notifyDataSetChanged();
                return false;
            }
        });
        mAdapter = new FavoresParaMimAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FavoresParaMimFragmentInterface) getParentFragment();
    }

    public interface FavoresParaMimFragmentInterface {
        List<Favor> getFavoresParaMim();
        List<Favor> getFavoresParaMim(String request);
    }

    public class FavoresParaMimAdapter extends RecyclerView.Adapter<FavoresParaMimAdapter.FavorHolder> {
        @Override
        public FavorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_favor_row, parent, false);
            return new FavorHolder(view);
        }

        @Override
        public void onBindViewHolder(FavorHolder holder, int position) {
            holder.favor = favoresParaMim.get(position);
            holder.tituloFavor.setText(holder.favor.getTitulo());
            holder.descricaoFavor.setText(holder.favor.getDescricao());
        }

        @Override
        public int getItemCount() {
            return favoresParaMim.size();
        }

        class FavorHolder extends RecyclerView.ViewHolder {
            Favor favor;
            TextView tituloFavor;
            TextView descricaoFavor;

            FavorHolder(View itemView) {
                super(itemView);
                itemView.findViewById(R.id.card_favor).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), ConsultaFavorActivity.class);
                        startActivity(intent);
                    }
                });
                tituloFavor = (TextView) itemView.findViewById(R.id.lbl_titulo_favor);
                descricaoFavor = (TextView) itemView.findViewById(R.id.lbl_descricao_favor);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
