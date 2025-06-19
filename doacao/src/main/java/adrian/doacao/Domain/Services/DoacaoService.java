package adrian.doacao.Domain.Services;

import adrian.doacao.Domain.Repository.DoacaoRepository;
import adrian.doacao.Domain.entity.Doacao;
import org.springframework.stereotype.Service;

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
    pu

}
