package com.my.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.internal.NotNull;

@Table
@Entity

public class Client implements Serializable {

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String nome;

	@Column(unique = true, nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String rg;
	@Column(nullable = false)
	private String sexo;
	@Column(nullable = false)
	private String[] visitas;
	@Column(nullable = false)
	private Date aniversario;
	@Column(nullable = false)
	private Date dataDeCadastro;
	private Seguro seguro;


	@ManyToMany
	@JoinTable(name = "segurados_seguros", joinColumns = {
			@JoinColumn(name = "id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_seguro", referencedColumnName = "id_seguro") })
	private List<Seguro> seguros = new ArrayList<Seguro>();

	public Client() {
	}

	public Client(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;

	}

	public Client(String nome, String cpf, String rg, String sexo, String[] visitas, Date aniversario,
			Date dataDeCadastro, Date dataDeAlteracao) {
		super();

		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.visitas = visitas;
		this.aniversario = aniversario;
		this.dataDeCadastro = dataDeCadastro;

	}
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String[] getVisitas() {
		return visitas;
	}

	public void setVisitas(String[] visitas) {
		this.visitas = visitas;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	
	

	
	
	
}
