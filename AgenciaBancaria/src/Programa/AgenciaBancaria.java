package Programa;

import java.util.ArrayList;


import javax.swing.JOptionPane;

public class AgenciaBancaria {

	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane
				.showInputDialog("--- Selecione uma operação --- \n" + "Opção 1 - Criar conta \n" + "Opção 2 - Depositar\n"
						+ "Opção 3 - Sacar \n" + "Opção 4 - Transferir \n" + "Opção 5 - Listar \n" + "Opção 6 - Sair\n"));

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:

			JOptionPane.showMessageDialog(null, "Obrigado por usar a nossa agência");
			System.exit(0);
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida");
			operacoes();
			break;
		}
	}

	public static void criarConta() {
		Cliente cliente = new Cliente();

		cliente.setNome(JOptionPane.showInputDialog("Nome:"));

		cliente.setCPF(JOptionPane.showInputDialog("CPF:"));

		cliente.setEmail(JOptionPane.showInputDialog("Email:"));

		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				conta = c;
			}
		}
		return conta;
	}

	public static void depositar() {

		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito:"));

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja depositar?");
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar?:"));
			conta.depositar(valorDeposito);
			JOptionPane.showMessageDialog(null, "O valor foi depositado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "A conta não foi encontrada!");
		}
		operacoes();
	}

	public static void sacar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para saque:"));

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {

			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Número da conta para depósito:"));
			conta.sacar(valorSaque);
		} else {
			JOptionPane.showMessageDialog(null, "Qual valor deseja sacar?");
		}
		operacoes();
	}

	public static void transferir() {
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente:"));

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			
			int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário:"));
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

			if (contaDestinatario != null) {
				Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência:"));
				contaRemetente.transferir(contaDestinatario, valor);
			} else {
				JOptionPane.showMessageDialog(null, "A transferência não foi efetuada!");
			}
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				JOptionPane.showMessageDialog(null,conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
		}
		operacoes();
	}

}
