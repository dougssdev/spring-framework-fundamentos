package test.projeto.dto;

import test.projeto.entitys.Livro;

public record DtoDetalhamentoLivro(
        String nome,

        String autor,

        String descricao
) {

}
