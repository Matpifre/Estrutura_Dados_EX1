package Ex_1;

import javax.swing.JOptionPane;

public class Processo {
	static Lista<Conta> lista = new Lista<Conta>();
	
	public static void abrirConta() {
		String nome = JOptionPane.showInputDialog("Nome: ");
		String cpf = JOptionPane.showInputDialog("CPF: ");
		Conta conta =  new Conta(nome, cpf);
		if(lista.pesquisar(conta) == null) {
			lista.inserirFinal(conta);
		} else {
			JOptionPane.showMessageDialog(null, "CPF dupicado no sistema");
		}
			
	}
	
	public static void sacar() {
		double valor;
		No<Conta> n = pesquisar();
		
		if(n == null) 
        {
			JOptionPane.showMessageDialog(null, "CPF não encontrado");
		} else 
        {
			valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque: R$"));
			if(valor > n.dado.saldo) 
            {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar o saque");
			} else 
            {
				n.dado.saldo -= valor;
			}
		}
		
		
		
	}
	
	public static void depositar() {
		double valor;
		No<Conta> n = pesquisar();
		
		if(n == null) 
        {
			JOptionPane.showMessageDialog(null, "CPF não encontrado");
		} else 
        {
			valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito: R$"));
			if(valor < 0) 
            {
				JOptionPane.showMessageDialog(null, "Valor inválido");
			} else 
            {
				n.dado.saldo += valor;
			}
		}
		
	}
	
	public static No<Conta> pesquisar() {
		String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
		Conta aux = new Conta("", cpf);
		No<Conta> n = lista.pesquisar(aux);
		return n;
	}
	
	public static void imprimirConta() {
		lista.imprimir();
	}
	
	public static void removerConta() {
	
		String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
		if(cpf.equals(""))
        {
			JOptionPane.showMessageDialog(null, "Insira um CPF válido");	
		} else
        {
			Conta aux = new Conta("", cpf);
			lista.remover(aux);
		}	
	}
}