package com.paladino.favores.business;

import java.util.List;

import com.paladino.favores.pesistence.InitDataBase;
import com.paladino.favores.pesistence.entidades.CategoriaHorario;
import com.paladino.favores.pesistence.entidades.Favor;

/**
 * Created by Paladino on 19/11/2016.
 */

public class FavorBusiness {
    private InitDataBase bd;

    public FavorBusiness(){
        bd = new InitDataBase();
    }

    public List<Favor> pesquisaFavor(String nome){
        return bd.getFavorByName(nome);
    }

    public List<Favor> pesquisarFavor(CategoriaHorario turno){
        return bd.getFavorByHorario(turno);
    }

    public Favor acompanharFavor(int idFavor){
        return bd.getFavorById(idFavor);
    }

    public void cadastrarFavor(Favor favor){
        bd.addFavor(favor);

        if(!(bd.getPessoas().contains(favor.getCriadora()))){
            bd.addPessoa(favor.getCriadora());
        }
    }

    public List<Favor> getFavoresSugeridos(CategoriaHorario turno){
        return bd.getFavorByTurno();
    }




}
