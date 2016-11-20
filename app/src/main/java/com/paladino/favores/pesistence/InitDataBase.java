package com.paladino.favores.pesistence;

import com.paladino.favores.pesistence.entidades.CategoriaHorario;
import com.paladino.favores.pesistence.entidades.Favor;
import com.paladino.favores.pesistence.entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by murit on 20/11/2016.
 */
public class InitDataBase {
    private static List<Favor> favores;
    private static List<Pessoa> pessoas;
    private List<Favor> favorByTurno;

    public InitDataBase(){
        favores = new ArrayList<Favor>();
        pessoas = new ArrayList<Pessoa>();
        loadFavores();
    }

    private static void loadFavores(){

        loadPessoas();
        Favor f1 = new Favor(1, "Pintar minha casa", "Preciso de ajuda para pintar dois cômodos da casa", pessoas.get(1), CategoriaHorario.Manha);
        boolean add = favores.add(f1);

        Favor f2 = new Favor(2, "Geladeira estragada", "Não sei o que aconteceu, preciso de alguem que saiba arrumar geladeiras", pessoas.get(2), CategoriaHorario.Tarde);
        boolean add2 = favores.add(f2);

    }

    private static void loadPessoas(){
        Pessoa p1 = new Pessoa("joaozinho@gmail.com", "1234", CategoriaHorario.Tarde);

        Pessoa p2 = new Pessoa("mariazinha@gmail.com", "1234", CategoriaHorario.Manha);
    }

    public List<Favor> getFavorByName(String nome) {
        List<Favor> achados = new ArrayList<Favor>();
        for (Favor f: favores) {
            if(f.getTitulo().contains(nome)){
                achados.add(f);
            }
        }
        return achados;

    }

    public Favor getFavorById(int idFavor) {
        List<Favor> achados = new ArrayList<Favor>();
        for (Favor f: favores) {
            if(f.getID() == idFavor){
                return f;
            }
        }
        return null;
    }

    public List<Pessoa> getPessoas(){
        return pessoas;
    }

    public void addFavor(Favor favor){
        favores.add(favor);

    }

    public List<Favor> getFavorByHorario(CategoriaHorario turno) {
        List<Favor> achados = new ArrayList<Favor>();
        for (Favor f: favores) {
            if(f.getTurno() == turno){
                achados.add(f);
            }
        }
        return achados;
    }

    public List<Favor> getFavorByTurno() {
        return favorByTurno;
    }

    public void addPessoa(Pessoa criadora) {
        pessoas.add(criadora);
    }
}
