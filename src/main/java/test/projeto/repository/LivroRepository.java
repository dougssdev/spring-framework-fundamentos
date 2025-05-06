package test.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.entitys.Livro;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<DtoDetalhamentoLivro> findByAutor(String autor);

    List<DtoDetalhamentoLivro> findByNome(String nome);


}
