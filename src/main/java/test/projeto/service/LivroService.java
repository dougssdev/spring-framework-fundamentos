package test.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.projeto.dto.DTOAutorRegister;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.entitys.Autor;
import test.projeto.entitys.Livro;
import test.projeto.excecoes.AutorNotFoundException;
import test.projeto.excecoes.LivroNotFoundException;
import test.projeto.repository.AutorRepository;
import test.projeto.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    LivroRepository livroRepository;

    AutorRepository autorRepository;
    AutorService autorService;

    @Autowired
    public LivroService(LivroRepository repository, AutorRepository autorRepository, AutorService autorService) {
        this.livroRepository = repository;
        this.autorRepository = autorRepository;
        this.autorService = autorService;
    }

    //AUTOR ID CHEGANDO COMO NULO NA TABELA LIVRO

    public Livro salvaLivro(DtoCadastroLivro dados){

        Autor autor = autorRepository.findByNome(dados.autor().nome()).orElseGet(() -> autorService.autorRegister(dados.autor()));
        Livro livro = new Livro(dados, autor);

        return livroRepository.save(livro);
    }

    public List<DtoDetalhamentoLivro> retornaLivroPorNome(String nome){
        List<DtoDetalhamentoLivro> livros = livroRepository.findByNome(nome);

        if(livros.isEmpty()){
            throw new LivroNotFoundException();
        }
        return livros;
    }

    public List<DtoDetalhamentoLivro> retornaLivroPorAutor(String nome){
        List<DtoDetalhamentoLivro> livros = livroRepository.findByNome(nome);

        Optional<Autor> autor = autorRepository.findByNome(nome);

        if (autor.isEmpty()){throw new AutorNotFoundException();}
        if(livros.isEmpty()){throw new LivroNotFoundException();}

        return livros;
    }

}
