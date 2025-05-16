package test.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.projeto.dto.AutorData;
import test.projeto.dto.DTOAutorRegister;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.entitys.Livro;
import test.projeto.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/a")
public class AutorController {

    private AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {this.autorService = autorService;}

    @PostMapping("/registrar")
    public ResponseEntity<AutorData> registraAutor (@RequestBody DTOAutorRegister data){
        autorService.autorRegister(data);
        AutorData autorData = new AutorData(data.nome());
        return ResponseEntity.ok(autorData);
    }

    /**
    @PostMapping("/livros_do_autor/{id}")
    public ResponseEntity<List<Livro>> registraLivrosAoAutor (@PathVariable Long id, DtoCadastroLivro cadastroLivro){
        List<Livro> livros = autorService.associaAutorAoLivro(id, cadastroLivro);
        return ResponseEntity.ok().body(livros);
    }
    **/
}
