package test.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.projeto.entitys.Livro;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByAutor(String autor);

    List<Livro> findByNome(String nome);


}
