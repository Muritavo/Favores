package com.paladino.favores.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * Use the {@link MeusFavoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeusFavoresFragment extends Fragment {
    private MeusFavoresFragmentInterface fragmentInterface;
    private List<Favor> meusFavores;
    private RecyclerViewAdapter mAdapter;

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
        meusFavores = fragmentInterface.getMeusFavores();
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
        ((SearchView)view.findViewById(R.id.search_bar)).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                meusFavores = fragmentInterface.getMeusFavores(newText);
                mAdapter.notifyDataSetChanged();
                return false;
            }
        });
        view.findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CadastroFavorActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        mAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    public interface MeusFavoresFragmentInterface {
        List<Favor> getMeusFavores();
        List<Favor> getMeusFavores(String searchQuery);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FavorHolder> {
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

        @Override
        public FavorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_favor_row, parent, false);
            return new FavorHolder(v);
        }

        @Override
        public void onBindViewHolder(FavorHolder holder, int position) {
            holder.favor = meusFavores.get(position);
            holder.tituloFavor.setText(holder.favor.getTitulo());
            holder.descricaoFavor.setText(holder.favor.getDescricao());
        }

        @Override
        public int getItemCount() {
            return meusFavores.size();
        }
    }
}
