package test.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.projeto.dto.DTOAutorRegister;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.entitys.Autor;
import test.projeto.service.LivroService;

import java.util.List;

@RestController
@RequestMapping("/c")
public class LivrosController {

    private LivroService livroService;

    @Autowired
    public LivrosController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<DtoDetalhamentoLivro> salvaLivro(@RequestBody DtoCadastroLivro dados){
        livroService.salvaLivro(dados);

        DtoDetalhamentoLivro dto = new DtoDetalhamentoLivro(dados.nome(), dados.autor().nome()
                , dados.descricao());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/procurar/nome/{nome}")
    public ResponseEntity<List<DtoDetalhamentoLivro>> retornaLivroPorNome(@PathVariable("nome") String nome){
        List<DtoDetalhamentoLivro> listaDeLivrosComOMesmoNome = livroService.retornaLivroPorNome(nome);
        return ResponseEntity.ok(listaDeLivrosComOMesmoNome);
    }


    @GetMapping("/procurar/autor/{nome}")
    public ResponseEntity<List<DtoDetalhamentoLivro>> retornaLivroPorAutor(@PathVariable("nome") String nome){
        List<DtoDetalhamentoLivro> livroList = livroService.retornaLivroPorAutor(nome);
        return ResponseEntity.ok(livroList);
    }

}
