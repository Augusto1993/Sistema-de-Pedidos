package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.ItemPedido;
import br.com.sistemadepedidos.domain.PagamentoComBoleto;
import br.com.sistemadepedidos.domain.Pedido;
import br.com.sistemadepedidos.domain.enums.EstadoPagamento;
import br.com.sistemadepedidos.repositories.ClienteRepository;
import br.com.sistemadepedidos.repositories.ItemPedidoRepository;
import br.com.sistemadepedidos.repositories.PagamentoRepository;
import br.com.sistemadepedidos.repositories.PedidoRepository;
import br.com.sistemadepedidos.repositories.ProdutoRepository;
import br.com.sistemadepedidos.services.exceptions.ObjectNotFoundException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EmailService emailService;

    public Pedido find(Integer id) {
        Pedido obj = repo.findOne(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado!! ID: " + id + ", Tipo: " + Pedido.class.getName());
        }

        return obj;

    }

    @Transactional
    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setCliente(clienteRepository.findOne(obj.getCliente().getId()));
        obj.setInstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoRepository.findOne(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.save(obj.getItens());
        emailService.sendOrderConfirmationEmail(obj);
        return obj;
    }
}
