package adrian.doacao.Domain.Services;

import adrian.doacao.Domain.Repository.DoacaoRepository;
import adrian.doacao.Domain.entity.Doacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    public Doacao newDoacao() {
        Doacao doacao = new Doacao();
        return doacaoRepository.save(doacao);
    }
    public Page<Doacao> getAllDoacao(Pageable pageable) {
        return doacaoRepository.findAll(pageable);
    }

    public Doacao getDoacaoById(Long id) {
        Optional<Doacao> doacao = doacaoRepository.findById(id);
        return doacao.orElse(null);
    }

    public Doacao updateDoacao(Doacao doacao) {
        if (doacao.getId() == null) {
            throw new IllegalArgumentException("ID da doação não pode ser nulo para atualização.");
        }
        return doacaoRepository.findById(doacao.getId())
                .map(existente -> {

                    if (doacao.getDescription() != null) {
                        existente.setDescription(doacao.getDescription());
                    }

                    return doacaoRepository.save(existente); // salva as alterações
                })
                .orElseThrow(() -> new IllegalArgumentException("Doação com ID " + doacao.getId() + " não encontrada."));
    }}