package test.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.entitys.Livro;
import test.projeto.excecoes.AutorNotFoundException;
import test.projeto.excecoes.LivroNotFoundException;
import test.projeto.repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    LivroRepository repository;

    @Autowired
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro salvaLivro(DtoCadastroLivro dados){
        Livro livro = new Livro(dados);
        return repository.save(livro);
    }

    public List<DtoDetalhamentoLivro> retornaLivroPorNome(String nome){
        List<DtoDetalhamentoLivro> livros = repository.findByNome(nome);

        if(livros.isEmpty()){
            throw new LivroNotFoundException();
        }
        return livros;
    }

    public List<DtoDetalhamentoLivro> retornaLivroPorAutor(String autor){
        List<DtoDetalhamentoLivro> livros = repository.findByAutor(autor);

        if(livros.isEmpty()){throw new AutorNotFoundException();}

        return livros;
    }
}
