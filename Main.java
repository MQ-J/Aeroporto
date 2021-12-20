import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

class Main {
	
	//cria lista de aviões
	static ArrayList<Aviao> listaAviao = new ArrayList<Aviao>();
	//cria lista de 10 voos
	static ArrayList<Voo> listaVoo = new ArrayList<Voo>(10);
	//cria Arraylist de passageiros
	static ArrayList<Passageiro> listaPassageiro = new ArrayList<Passageiro>();
	
	//inicializa numeros de aviões
	static int numAviao = -1;
	//inicializa numero de voos
	static int numVoo = -1;

	public static void main(String[] args) {
		/*listaAviao.add(new Aviao("Boeing", 10, 10));
		listaVoo.add(0,new Voo(listaAviao.get(0), 1010, "15/10/2021", "15:30"));
		Iterator<Voo> itr = listaVoo.iterator();
		Voo voo = (Voo)itr.next();
		voo.getAeronave().setPassageiro((10 - 1), (10 - 1), new Passageiro("Mauricio", "123.123.123.12"));
		
		listaAviao.add(new Aviao("Carro", 10, 10));
		//cadastrarAeronave();
		
		listaVoo.add(1,new Voo(listaAviao.get(1), 2020, "15/10/2021", "15:30"));
		//cadastrarVoo();
		voo.getAeronave().setPassageiro((9 - 1), (9 - 1), new Passageiro("Maria", "123.153.113.12"));
		fazerReserva();
		consultaLugar();
		consultaReserva();
		consultaLugar();
		consultaLugar();*/
		JOptionPane.showMessageDialog(null, "Seja bem-vindo(a) ao sistema de reserva de passagéns aéreas!");
		while (true) {
			int resp = menuPrincipal();
			switch(resp) {
			case 1:{
				parametroSistema();
				break;
			}
			case 2:{
				reservaPassagem();
				break;
			}
			case 3:{
				System.exit(1);
			}
			
			}
		}	
	}
	
	public static int validacao(String respV, int qV) {
		int respC;
		int [] menu = {1, 2, 3};
		int [] menu2 = {1, 2, 3, 4};
		
		while (true) {
			
			if(respV == null){
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					System.exit(1);
					}
			try {
				 respC = Integer.parseInt(respV);
				if (qV == 1) {
					int w = (menu[(respC-1)]);
					
				}
				else {
					int w = (menu2[(respC-1)]);
				}
					break;
				}
			catch (IndexOutOfBoundsException | NumberFormatException e) {
				if (e.getClass().toString().equals("class java.lang.ArrayIndexOutOfBoundsException")) {
					JOptionPane.showMessageDialog(null, "A opção selecionada não existe!");
				}
				else if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
					JOptionPane.showMessageDialog(null, "A opção selecionada não é um número!");
				}
			}
			return (-1);
		}
		return (respC);
	}
	
	public static int menuPrincipal() {
		int valid, q = 1;
		while (true) {
			String resp = JOptionPane.showInputDialog("                Menu princpial\n\n1- Parâmetros do Sistema\n2- Reserva de Passagens\n3- Sair");
			valid = validacao(resp, q);
			if (valid == 1 || valid == 2 || valid == 3) {
				break;
			}
		}
		return(valid);
	}
	
	public static void parametroSistema() {
		int valid, loop = 0, q = 1;
		while (loop == 0) {
			String resp = JOptionPane.showInputDialog("           Parâmetros do sistema\n\n1- Cadastrar Aeronave\n2- Cadastrar Voo\n3- Voltar");
			valid = validacao(resp, q);
			switch(valid) {
				case 1:{
					cadastrarAeronave();
					break;
				}
				case 2:{
					cadastrarVoo();
					break;
				}
				case 3:{
					loop = -1;
				}
			}
		}
	}
	
	public static void reservaPassagem() {
		int valid, loop = 0, q = 2;
		while (loop == 0) {
			String resp = JOptionPane.showInputDialog("           Reserva de Passagens\n\n1- Fazer reserva\n2- Consultar lugares vazios\n3- Consultar reservas realizadas\n4- Voltar");
			valid = validacao(resp, q);
			switch(valid) {
				case 1:{
					fazerReserva();
					break;
				}
				case 2:{
					consultaLugar();
					break;
				}
				case 3:{
					consultaReserva();
					break;
				}
				case 4:{
					loop = -1;
				}
			}
		}
	}
	
	public static String cadastrarAeronave() {
		String modelo;
		int fileiras, assentos;
		while (true) {
			try {
				modelo = JOptionPane.showInputDialog(null, "             Cadastro de aeronave\n\n\nInsira o modelo da aeronave:");
					if (modelo.length() < 1) {
						JOptionPane.showMessageDialog(null, "O nome não pode ser vazio!");
						continue;
					}
						String sFileiras = JOptionPane.showInputDialog(null, "             Cadastro de aeronave\n\n\nInsira o número de fileiras da aeronave:");
						if (sFileiras == null) {
							JOptionPane.showMessageDialog(null, "Operação cancelada!");
							return("Cancel");
						}
						fileiras = Integer.parseInt(sFileiras);
						String sAssentos = JOptionPane.showInputDialog(null, "             Cadastro de aeronave\n\n\nInsira o número de assentos por fileira:");
						if (sAssentos == null) {
							JOptionPane.showMessageDialog(null, "Operação cancelada!");
							return("Cancel");
						}
						assentos = Integer.parseInt(sAssentos);
						listaAviao.add(new Aviao(modelo, fileiras, assentos));
						break;
					}
			catch (NumberFormatException |  NullPointerException e){
				 if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
					JOptionPane.showMessageDialog(null, "A opção selecionada não é um número!");
				}
				 else if (e.getClass().toString().equals("class java.lang.NullPointerException")){
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					return("Cancel");
				 }
			}
		}
		numAviao++;
		JOptionPane.showMessageDialog(null, "Avião " + listaAviao.get(numAviao).modelo + " criado com sucesso.");
		return("Success");
	}
	public static String cadastrarVoo() {
		while (true) {
			try {
			/*aviao é usado para escolher qual dos aviões cadastrados será usado para o Voo. Segue a ordem de cadastramento. Então, o primeiro avião 
			cadastrado pelo cadastrarAeronave() é o 1, o segundo cadastrado pelo cadastrarAeronave() é o 2... 
			 */
			String sAviao = JOptionPane.showInputDialog(null, "                  Cadastro de voo\n\n\nInsira o número da Aeronave:");
			if (sAviao == null) {
				JOptionPane.showMessageDialog(null, "Operação cancelada!");
				return("Cancel");
			}
			int aviao = Integer.parseInt(sAviao);
			int total = listaAviao.size();
			if (aviao > total) {
				JOptionPane.showMessageDialog(null, "O avião selecionado não existe.\nLembrando que existem " + listaAviao.size() + " aeronaves cadastradas");
			}
			else {
				String sNum = (JOptionPane.showInputDialog(null, "                  Cadastro de voo\n\n\nInsira o número do voo:"));
				if (sNum == null) {
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					return("Cancel");
				}
				int num = Integer.parseInt(sNum);
				String data = JOptionPane.showInputDialog(null, "                   Cadastro de voo\n\n\nInsira a data do voo:");
				if (data.length() > 0) {
					String hora = JOptionPane.showInputDialog(null, "                   Cadastro de voo\n\n\nInsira a hora do voo:");
					if (hora.length() > 0) {
						numVoo++;
						listaVoo.add(numVoo,new Voo(listaAviao.get(aviao-1), num, data, hora));
						break;
					}
					else 
						JOptionPane.showMessageDialog(null, "A hora não pode ser vazia!");
				}	
				else
					JOptionPane.showMessageDialog(null, "A data não pode ser vazia!");
						
				}
			}
			catch (NumberFormatException |  NullPointerException | IndexOutOfBoundsException  e){
				 if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
					JOptionPane.showMessageDialog(null, "A opção selecionada não é um número!");
				}
				 else if (e.getClass().toString().equals("class java.lang.NullPointerException")){
					JOptionPane.showMessageDialog(null, "Operação cancelada!");	
					return("Cancel");
				 }
				 else if (e.getClass().toString().equals("class java.lang.IndexOutOfBoundsException")) {
					 JOptionPane.showMessageDialog(null, "O avião escolhido não existe.");
				 }
			//novo voo é criado
		
			}
		}
		JOptionPane.showMessageDialog(null, "Voo " + listaVoo.get(numVoo).getNro() + " criado com sucesso.");
		return("Success");
	}

	public static String fazerReserva() throws ArrayIndexOutOfBoundsException {
		
		
		//passageiro escolhe voo
		boolean lugar;
		int num = 0, fileira = 0, assento = 0;
		String nome = "", cpf = "";
		Iterator<Voo> itr = listaVoo.iterator();
		
		if (itr.hasNext() == false) {
			JOptionPane.showMessageDialog(null,"Nenhum voo cadastrado!");
			return("Noo flights");
		}
		
		while (true) {
			try {
				nome = JOptionPane.showInputDialog(null, "             Reserva de passagem\n\n\nInsira o nome do passageiro:");
				if (nome == null) {
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					return("Cancel");
				}
				if (nome.length() < 1) {
					JOptionPane.showMessageDialog(null, "O nome do passageiro não pode ser vazio!");
					continue;
				}
				cpf = JOptionPane.showInputDialog(null, "             Reserva de passagem\n\n\nInsira o CPF do passageiro:");
				if (cpf == null) {
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					return("Cancel");
				}
				if (cpf.length() < 1) {
					JOptionPane.showMessageDialog(null, "O CPF do passageiro não pode ser vazio!");
					continue;
				}
				String sNum = JOptionPane.showInputDialog(null, "             Reserva de passagem\n\n\nInsira o número do voo desejado:");
				if (sNum == null) {
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					return("Cancel");
				}
				if (sNum.length() == 0) {
					JOptionPane.showMessageDialog(null, "O número do voo não pode ser vazio!");
					continue;
				}
				num = Integer.parseInt(sNum);
				String sFileira = JOptionPane.showInputDialog(null, "                  Cadastro de voo\n\n\nInsira o número da fileira:");
				if (sFileira == null) {
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					return("Cancel");
				}
				if (sFileira.length() < 1) {
					JOptionPane.showMessageDialog(null, "O número da fileira não pode ser vazio!");
					continue;
				}
				fileira = Integer.parseInt(sFileira);
				String sAssento = JOptionPane.showInputDialog(null, "                  Cadastro de voo\n\n\nInsira o número do assento:");
				if (sAssento == null) {
					JOptionPane.showMessageDialog(null, "Operação cancelada!");
					return("Cancel");
				}
				if (sAssento.length() < 1) {
					JOptionPane.showMessageDialog(null, "O número do assento não pode ser vazio!");
					continue;
				}
				assento = Integer.parseInt(sAssento);
			}
			catch (NumberFormatException |  NullPointerException | IndexOutOfBoundsException e){
				 if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
					JOptionPane.showMessageDialog(null, "A opção selecionada não é um número!");
				}
				 else if (e.getClass().toString().equals("class java.lang.NullPointerException")){
					JOptionPane.showMessageDialog(null, "Operação cancelada!");	
					return("Cancel");
				 }
				 else if (e.getClass().toString().equals("class java.lang.IndexOutOfBoundsException")) {
					 JOptionPane.showMessageDialog(null, "O avião escolhido não existe.");
					 continue;
				 }
				 else if ((e.getClass().toString().equals("class java.lang.ArrayIndexOutOfBoundsException"))) {
					 JOptionPane.showMessageDialog(null, "Operação cancelada!");	
						return("Cancel");
				 }
			}
			int len = listaVoo.size();
			for (int k = 0; k < len; k++) {
				 Voo voo = listaVoo.get(k);
				if (voo.getNro() == num) {
					lugar = voo.getAeronave().verificaLugarOcupado((fileira - 1), (assento - 1));
					if (lugar == false) {
						voo.getAeronave().setPassageiro((fileira - 1), (assento - 1), new Passageiro(nome, cpf));
						listaPassageiro.add(new Passageiro(nome, cpf));
						JOptionPane.showMessageDialog(null, String.format("Reserva realizada com sucesso!\n\nFileira:      [%d]\nAssento:  [%d]", fileira, assento));
						return("Success");
					}
					else if(lugar == true) {
						JOptionPane.showMessageDialog(null,"O lugar está ocupado.\nPor favor, escolha outro!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"O número do voo informado não existe.\nPor favor, escolha outro!");
				}
				
			}
		
		}
	}
	/*FUNÇÃO DE CONSULTAR LUGAR*/
	public static String consultaLugar() {
		Iterator<Voo> itr = listaVoo.iterator();
		
		if (itr.hasNext() == false) {
			JOptionPane.showMessageDialog(null,"Nenhum voo cadastrado!");
			return("Noo flights");
		}
		while (true) {
			int num = 0;
			try {
				String sNum = (JOptionPane.showInputDialog("Digite o número do Voo:"));
				if (sNum.length() < 1) {
					JOptionPane.showMessageDialog(null, "O número do voo não pode ser vazio!");
					continue;
				}
				num = Integer.parseInt(sNum);
			}
			catch (NumberFormatException |  NullPointerException | IndexOutOfBoundsException  e){
				 if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
					JOptionPane.showMessageDialog(null, "A opção selecionada não é um número!");
					continue;
				}
				 else if (e.getClass().toString().equals("class java.lang.NullPointerException")){
					JOptionPane.showMessageDialog(null, "Operação cancelada!");	
					return("Cancel");
				 }
				 else if (e.getClass().toString().equals("class java.lang.IndexOutOfBoundsException")) {
					 JOptionPane.showMessageDialog(null, "O avião escolhido não existe.");
					 continue;
				 }
			}
			int len = listaVoo.size();
			for (int k = 0; k < len; k++) {
				 Voo voo = listaVoo.get(k);
				if (voo.getNro() == num) {
					int lugar = 0;
					for (int i = 0; i < voo.getAeronave().lugares.length; i++) {
						for (int j = 0; j < voo.getAeronave().lugares[0].length; j++) {
							if (voo.getAeronave().lugares[i][j] == null) {
								lugar++;
							}
						}
					}
				JOptionPane.showMessageDialog(null, "O Voo de número " + voo.getNro() + " tem " + lugar + " lugares disponível(s)");
				return("Success");
				} 
				else {
					System.out.println("Não achou!");
					JOptionPane.showMessageDialog(null,"O número do voo não existe.\nPor favor, escolha outro!");
				}
			}
		}
	}
	
	/*FUNÇÃO DE CONSULTAR RESERVA*/
	public static String consultaReserva() {
		 Iterator<Voo> itr = listaVoo.iterator();
		 int len = listaVoo.size();
		 int num = 0;
		if (itr.hasNext() == false) {
			JOptionPane.showMessageDialog(null,"Nenhum voo cadastrado!");
			return("Noo flights");
		}
		while (true) {
			try {
				String sNum = (JOptionPane.showInputDialog("Digite o número do Voo:"));
				if (sNum.length() < 1) {
					JOptionPane.showMessageDialog(null, "O número do voo não pode ser vazio!");
					continue;
				}
				num = Integer.parseInt(sNum);
				
			}
			catch (NumberFormatException |  NullPointerException | IndexOutOfBoundsException  e){
				 if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
					JOptionPane.showMessageDialog(null, "A opção selecionada não é um número!");
					continue;
				}
				 else if (e.getClass().toString().equals("class java.lang.NullPointerException")){
					JOptionPane.showMessageDialog(null, "Operação cancelada!");	
					return("Cancel");
				 }
				 else if (e.getClass().toString().equals("class java.lang.IndexOutOfBoundsException")) {
					 JOptionPane.showMessageDialog(null, "O avião escolhido não existe.");
					 continue;
				 }
			}
			 
			  for (int k = 0; k < len; k++) {
				  Voo voo = listaVoo.get(k);
				  //Voo voo =(Voo)itr.next();
				  if (voo.getNro() == num) {
	
			      //cria vetor de lugares ocupados
			      int i, j;
			    
			    //pesquisa quantos lugares estão reservados
			      String numb = " ";
			      for (i = 0; i < voo.getAeronave().lugares.length; i++) {
			        for (j = 0; j < voo.getAeronave().lugares.length; j++) {
			          if (voo.getAeronave().lugares[i][j] != null) {
			            numb = numb + "[" + (i+1) + "][" + (j+1) + "]\n";
			          }
			        }
			      }
			      JOptionPane.showMessageDialog(null,"O voo de número " + num + " tem os seguintes lugares reservados: \n\n" + numb);
			      return("Success");
			    } 
				 else {
						JOptionPane.showMessageDialog(null,"O número do voo não existe.\nPor favor, escolha outro!");
					}
			  }  	
		}
	}
}