package conta.model;

public class ContaPoupanca extends Conta {

    private int aniversario;

    public ContaPoupanca(int numero, int agencia, String titular, float saldo, int aniversario) {
        super(numero, agencia, 2, titular, saldo);
        this.aniversario = aniversario;
    }

    public int getAniversario() { return aniversario; }
    public void setAniversario(int aniversario) { this.aniversario = aniversario; }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Dia do Aniversário: " + this.aniversario);
    }
}
