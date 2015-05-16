package csb.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cbs_motivoalteracaosalarial")
public class MotivoAlteracaoSalarial implements Serializable {
    
    public static final String sTitle = "Motivo de Alteração Salarial";
    public static final String pTitle = "Motivos para Alterações Salariais";
    
    @Id
    @SequenceGenerator(name="cbs_motivoalteracaosalarial_pk_sequence", sequenceName="cbs_motivoalteracaosalarial_mas_codigo_seq")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="cbs_motivoalteracaosalarial_pk_sequence")
    private int mas_codigo;
    private String mas_descricao;
    private boolean mas_situacao;

    public MotivoAlteracaoSalarial() {
    }

    public int getMas_codigo() {
        return mas_codigo;
    }

    public void setMas_codigo(int mas_codigo) {
        this.mas_codigo = mas_codigo;
    }

    public String getMas_descricao() {
        return mas_descricao;
    }

    public void setMas_descricao(String mas_descricao) {
        this.mas_descricao = mas_descricao;
    }

    public boolean isMas_situacao() {
        return mas_situacao;
    }

    public void setMas_situacao(boolean mas_situacao) {
        this.mas_situacao = mas_situacao;
    }
}
