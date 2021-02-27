import java.util.Arrays;

public class Usuario {
	private String nome;
	private String sobrenome;
	private int idade;
	private String email;
	private Boolean ativo;
	private String[] inventario;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome, String sobrenome, int idade, String email, Boolean ativo, String[] inventario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.email = email;
		this.ativo = ativo;
		this.inventario = inventario;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + ", email=" + email
				+ ", ativo=" + ativo + ", inventario=" + Arrays.toString(inventario) + "]";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String[] getInventario() {
		return inventario;
	}
	public void setInventario(String[] inventario) {
		this.inventario = inventario;
	}
	
	
}
