package test.projeto.dto;

import test.projeto.entitys.Livro;

public record DtoDetalhamentoLivro(
        String nome,

        String autor,

        String descricao
) {
    public DtoDetalhamentoLivro(Livro livro){
        this(livro.getNome(), livro.getAutor().getNome(), livro.getDescricao());
    }
}
