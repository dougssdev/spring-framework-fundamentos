package test.projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record DtoCadastroLivro(

        @NotBlank
        String nome,

        @NotBlank
        String autor,

        @NotBlank
        String descricao
) {

}
