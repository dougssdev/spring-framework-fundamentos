package test.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.projeto.dto.DTOAutorRegister;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.entitys.Autor;
import test.projeto.entitys.Livro;
import test.projeto.excecoes.AutorNotFoundException;
import test.projeto.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;


    public Autor autorRegister(DTOAutorRegister data) {
        Autor autor = new Autor(data);
        return autorRepository.save(autor);

    }

    public void associaAutorAoLivro(Long id, DtoCadastroLivro data){

        Optional<Autor> autor = autorRepository.findById(id);

        if (autor.isEmpty()){
            throw new AutorNotFoundException();
        }

        Livro livro = new Livro(data, autor.get());
        autor.get().getLivros().add(livro);

    }

}
