package com.adoteumpet.adocao.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.adoteumpet.adocao.enums.PorteEnum;
import com.adoteumpet.adocao.enums.SexoEnum;
import com.adoteumpet.adocao.enums.StatusEnum;


@Entity
@Table(name = Animal.TABLE_NAME)
public class Animal implements Serializable {

 
	private static final long serialVersionUID = 1L;
	
    public static final String TABLE_NAME = "tb_animal";

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "data_inclusao", nullable = false)
	private LocalDateTime dataInclusao;
	
	@Column(name = "data_nascimento", nullable = false)
	private LocalDateTime dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "porte", nullable = false)
	private PorteEnum porte;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genero", nullable = false)
	private SexoEnum genero;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private StatusEnum status;

	@Column(name = "idade", nullable = false)
	private Integer idade;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_raca", nullable = false)
	private Raca raca;
	 
	
	@Column(name = "cor", nullable = false)
	private String cor;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy="animal", fetch = FetchType.EAGER)
	private List<Imagem> imagens = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "id_cidade", nullable = false)
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "id_tutor", nullable = false)
	private Usuario tutor;
	
	@ManyToOne
	@JoinColumn(name = "id_adotado_por")
	private Usuario adotadoPor;

		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public SexoEnum getGenero() {
		return genero;
	}

	public void setGenero(SexoEnum genero) {
		this.genero = genero;
	}

	public PorteEnum getPorte() {
		return porte;
	}

	public void setPorte(PorteEnum porte) {
		this.porte = porte;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Usuario getTutor() {
		return tutor;
	}

	public void setTutor(Usuario tutor) {
		this.tutor = tutor;
	}

	public Usuario getAdotadoPor() {
		return adotadoPor;
	}

	public void setAdotadoPor(Usuario adotadoPor) {
		this.adotadoPor = adotadoPor;
	}
 
	
}
