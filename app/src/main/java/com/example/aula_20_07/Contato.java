package com.example.aula_20_07;

public class Contato {

    public String nome;
    private String horario;
    public int servidor;

    public Contato(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario() {
        this.horario = horario;
    }

    public int getServidor() {
        return servidor;
    }

    public void setServidor(int servidor) {
        servidor = servidor;
    }

    public boolean validaServidor(int servidor){
        if(servidor == 123456)
            return true;
        else
            return false;
    }
}
