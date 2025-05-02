package test.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import test.projeto.dto.DtoCadastroLivro;
import test.projeto.dto.DtoDetalhamentoLivro;
import test.projeto.service.LivroService;

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

}
