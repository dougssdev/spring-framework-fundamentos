package test.projeto.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.projeto.dto.DtoCadastroLivro;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String descricao;

    public Livro(DtoCadastroLivro dados) {
        this.autor = dados.autor();
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }
}
