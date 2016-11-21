package com.paladino.favores.presentation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paladino.favores.R;
import com.paladino.favores.business.FavorBusiness;
import com.paladino.favores.business.Favores;
import com.paladino.favores.pesistence.entidades.Favor;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FavoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoresFragment extends Fragment implements
        MeusFavoresFragment.MeusFavoresFragmentInterface,
        FavoresParaMimFragment.FavoresParaMimFragmentInterface{
    private List<Favores> favores;
    private FavorBusiness favorBusiness;

    public FavoresFragment() {
        favorBusiness = new FavorBusiness();
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoresFragment newInstance() {
        return new FavoresFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favores, container, false);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.container_favores);
        viewPager.setAdapter(new SectionsPagerAdapterFavores(getChildFragmentManager()));
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs_favores);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

    public class SectionsPagerAdapterFavores extends FragmentPagerAdapter {
        public SectionsPagerAdapterFavores(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MeusFavoresFragment.newInstance();
                case 1:
                    return FavoresParaMimFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Meus favores";
                case 1:
                    return "Para mim";
                default:
                    return null;
            }
        }
    }

    @Override
    public List<Favor> getMeusFavores() {
        return favorBusiness.pesquisarMeusFavores("");
    }

    @Override
    public List<Favor> getMeusFavores(String searchQuery) {
        return favorBusiness.pesquisarMeusFavores(searchQuery);
    }

    @Override
    public List<Favor> getFavoresParaMim() {
        return favorBusiness.pesquisaFavor("");
    }

    @Override
    public List<Favor> getFavoresParaMim(String request) {
        return favorBusiness.pesquisaFavor(request);
    }
}
