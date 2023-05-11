package br.com.adsfood.pagamentos.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Positive(message = "valor tem que ser positivo")
    private BigDecimal valor;
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Maximo de caracteres é de 100")
    private String nome;
    @NotBlank(message = "Numero do cartão é obrigatóri")
    @Size(max = 19, message = "Maximo de caracteres é de 19")
    private String numero;

    @NotBlank
    @Size(max = 7, message = "Maximo de caracteres é de 7")
    private String expiracao;

    @NotBlank
    @Size(min = 3, max = 3 ,message = "caracteres é de 3")
    private String codigo;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NonNull
    private Long pedidoId;
    @NonNull
    private Long formaDePagamentoId;
}





