package test.projeto.dto;

import jakarta.validation.constraints.NotBlank;
import test.projeto.entitys.Autor;

public record DtoCadastroLivro(

        @NotBlank
        String nome,

        @NotBlank
        DTOAutorRegister autor,

        @NotBlank
        String descricao
) {

}
