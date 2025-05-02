package test.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.entitys.Livro;
import test.projeto.repository.LivroRepository;

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
}
