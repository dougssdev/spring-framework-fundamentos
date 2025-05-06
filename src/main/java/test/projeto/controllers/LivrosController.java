package test.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.service.LivroService;

import java.util.List;

@Controller
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

        DtoDetalhamentoLivro dto = new DtoDetalhamentoLivro(dados.nome(), dados.autor(), dados.descricao());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/procurar/nome/{nome}")
    public ResponseEntity<List<DtoDetalhamentoLivro>> retornaLivroPorNome(@PathVariable("nome") String nome){
        List<DtoDetalhamentoLivro> listaDeLivrosComOMesmoNome = livroService.retornaLivroPorNome(nome);
        return ResponseEntity.ok(listaDeLivrosComOMesmoNome);
    }


    @GetMapping("/procurar/autor/{autor}")
    public ResponseEntity<List<DtoDetalhamentoLivro>> retornaLivroPorAutor(@PathVariable("autor") String autor){
        List<DtoDetalhamentoLivro> livroList = livroService.retornaLivroPorAutor(autor);
        return ResponseEntity.ok(livroList);
    }

}
