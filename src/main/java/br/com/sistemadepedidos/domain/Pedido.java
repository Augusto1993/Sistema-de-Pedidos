package br.com.sistemadepedidos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1L;


    /*Atributos*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date instante;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;
    
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    /* Construtor vazio */
    public Pedido() {
        
    }

    /* Construtor*/
    public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
        super();
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
        
    }
    
    public double getValorTotal() {
        double soma = 0.0;
        for (ItemPedido ip : itens) {
            soma = soma + ip.getSubTotal();
        }
        return soma;
    }

    /* Métodos getters e setters  */
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getInstante() {
        return instante;
    }
    
    public void setInstante(Date instante) {
        this.instante = instante;
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }
    
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }
    
    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
    
    public Set<ItemPedido> getItens() {
        return itens;
    }
    
    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    /* Métodos equals e hashcode  */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(getId());
    }
    
    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        StringBuilder builder = new StringBuilder();
        builder.append("Pedido Número: ");
        builder.append(getId());
        builder.append(", Instante: ");
        builder.append(sdf.format(getInstante()));
        builder.append(", Cliente:");
        builder.append(getCliente().getNome());
        builder.append(", Situação do pagamento:");
        builder.append(getPagamento().getEstado().getDescricao());
        builder.append("\nDetalhes: \n");
        for (ItemPedido ip : getItens()) {
            builder.append(ip.toString());
        }
        builder.append("Valor Total: ");
        builder.append(nf.format(getValorTotal()));
        return builder.toString();
    }
}
