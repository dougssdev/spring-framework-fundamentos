package test.projeto.dto;

import test.projeto.entitys.Autor;
import test.projeto.entitys.Livro;

import java.util.List;

public record AutorData(
        String nome

) {
    public AutorData(Autor autor){
        this(autor.getNome());
    }
}
