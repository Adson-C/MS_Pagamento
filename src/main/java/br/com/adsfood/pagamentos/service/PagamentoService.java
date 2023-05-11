package br.com.adsfood.pagamentos.service;

import br.com.adsfood.pagamentos.dto.PagamentoDTO;
import br.com.adsfood.pagamentos.model.Pagamento;
import br.com.adsfood.pagamentos.model.Status;
import br.com.adsfood.pagamentos.repository.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PagamentoDTO> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, PagamentoDTO.class));
    }

    public PagamentoDTO obterPorId(Long id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public PagamentoDTO criarPagamento(PagamentoDTO dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public PagamentoDTO AtualizarPagamento(Long id ,PagamentoDTO dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento  = repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }

}
