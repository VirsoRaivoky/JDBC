package pkg;

public class Cidade {
	int id;
	String nome;
	String cep;
	String uf;
	
	public Cidade(int id, String nome, String cep, String uf) {
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.uf = uf;	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
