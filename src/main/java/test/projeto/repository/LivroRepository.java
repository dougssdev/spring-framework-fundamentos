package test.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.entitys.Autor;
import test.projeto.entitys.Livro;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<DtoDetalhamentoLivro> findAutorById (Long id);

    List<DtoDetalhamentoLivro> findByNome(String nome);


}
