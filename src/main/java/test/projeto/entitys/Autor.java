package test.projeto.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.projeto.dto.DTOAutorRegister;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    public Autor(DTOAutorRegister data) {
        this.nome = data.nome();
    }

    public Autor(String nomeAutor) {
        this.nome = nomeAutor;
    }
}
