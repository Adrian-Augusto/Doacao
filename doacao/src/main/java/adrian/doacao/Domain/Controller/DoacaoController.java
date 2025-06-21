package adrian.doacao.Domain.Controller;

import adrian.doacao.Domain.Services.DoacaoService;
import adrian.doacao.Domain.entity.Doacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DoacaoController {

    private final DoacaoService doacaoService;
    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }


    @GetMapping
    public ResponseEntity<Page<Doacao>> getAllDoacao(Pageable pageable) {
        return ResponseEntity.ok(doacaoService.getAllDoacao(pageable));
    }
    @GetMapping("/doacoes/{id}")
    public ResponseEntity<Doacao> getDoacaoById(@PathVariable Long id) {
        Doacao doacao = doacaoService.getDoacaoById(id);
        if (doacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doacao);
    }

    @PutMapping("/doacoes")
    public ResponseEntity<Doacao> atualizarDoacao(@RequestBody Doacao doacao) {
        try {
            Doacao atualizada = doacaoService.updateDoacao(doacao);
            return ResponseEntity.ok(atualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
