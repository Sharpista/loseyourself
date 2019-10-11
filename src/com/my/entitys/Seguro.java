package com.my.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Seguro implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_seguro")
	private Integer id_seguro;
	
	@Column(nullable = false)
	private String identificacao;
	
	@Column(nullable = false)
	private Double valor;
	
	@ManyToMany(mappedBy = "seguros")
	private List<Client> clientes = new ArrayList<Client>();
	
	public Integer getId_seguro() {
		return id_seguro;
	}
	public void setId_seguro(Integer id_seguro) {
		this.id_seguro = id_seguro;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public List<Client> getClientes() {
		return clientes;
	}
	public void setClientes(List<Client> clientes) {
		this.clientes = clientes;
	}
	@Override
	public String toString() {
		return "Seguro [id_seguro=" + id_seguro + ", identificacao=" + identificacao + ", valor=" + valor
				+ ", clientes=" + clientes + "]";
	}
	
	
	
	
}
