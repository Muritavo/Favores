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
    private static List<Favor> favoresParaMim;
    private static List<Favor> meusFavores;
    private static List<Pessoa> pessoas;
    private List<Favor> favorByTurno;

    public InitDataBase(){
        favoresParaMim = new ArrayList<Favor>();
        pessoas = new ArrayList<Pessoa>();
        meusFavores = new ArrayList<Favor>();
        loadFavores();
    }

    private static void loadFavores(){

        loadPessoas();
        Favor f1 = new Favor(1, "Pintar minha casa", "Preciso de ajuda para pintar dois cômodos da casa", pessoas.get(0), CategoriaHorario.Manha);
        boolean add = favoresParaMim.add(f1);

        Favor f2 = new Favor(2, "Geladeira estragada", "Não sei o que aconteceu, preciso de alguem que saiba arrumar geladeiras", pessoas.get(1), CategoriaHorario.Tarde);
        boolean add2 = favoresParaMim.add(f2);

        Favor f3 = new Favor(3, "Cachorrinho doente", "Meu bicho de estimação esta um pouco mal e não sei o que fazer", pessoas.get(2), CategoriaHorario.Tarde);
        boolean add3 = favoresParaMim.add(f3);

        Favor f4 = new Favor(4, "Grama alta", "Preciso cortar a grama, alguém tem um cortador de grama para emprestar?", pessoas.get(0), CategoriaHorario.Tarde);
        boolean add4 = favoresParaMim.add(f4);

        Favor f5 = new Favor(5, "Carro com pneu furado", "Estou preso no meio da estrada", pessoas.get(2), CategoriaHorario.Tarde);
        boolean add5 = favoresParaMim.add(f5);

        Favor f6 = new Favor(6, "Computador com defeito", "Meu pc pegou vírus e não liga mais", pessoas.get(0), CategoriaHorario.Tarde);
        boolean add6 = favoresParaMim.add(f6);
    }

    private static void loadPessoas(){
        Pessoa p1 = new Pessoa("Joãozinho", "joaozinho@gmail.com", CategoriaHorario.Tarde);
        pessoas.add(p1);

        Pessoa p2 = new Pessoa( "Mariazinha", "mariazinha@gmail.com", CategoriaHorario.Manha);
        pessoas.add(p2);

        Pessoa p3 = new Pessoa("Pedrinho", "pedrinho@gmail.com", CategoriaHorario.Noite);
        pessoas.add(p3);
    }

    public List<Favor> getFavorByName(String nome) {
        List<Favor> achados = new ArrayList<Favor>();
        for (Favor f: favoresParaMim) {
            if(f.getTitulo().contains(nome)){
                achados.add(f);
            }
        }
        return achados;

    }

    public Favor getFavorById(int idFavor) {
        List<Favor> achados = new ArrayList<Favor>();
        for (Favor f: favoresParaMim) {
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
        favoresParaMim.add(favor);

    }

    public List<Favor> getFavorByHorario(CategoriaHorario turno) {
        List<Favor> achados = new ArrayList<Favor>();
        for (Favor f: favoresParaMim) {
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

    public List<Favor> getMeusFavoresByName(String query) {
        List<Favor> achados = new ArrayList<Favor>();
        for (Favor f: meusFavores) {
            if(f.getTitulo().contains(query)){
                achados.add(f);
            }
        }
        return achados;
    }
}
