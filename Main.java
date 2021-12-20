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

  /*método principal*/
	public static void main(String[] args) {
		
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
	
  //função auxiliar de validação de campos
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
	
  /*MENU PRINCIPAL*/
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
	
   /*PARÂMETROS DO SISTEMA*/
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
	
   /*RESERVA DE PASSAGEM*/
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
	
   /*cadastro de aeronaves*/
	public static String cadastrarAeronave() {
		String modelo;
		int fileiras, assentos;

    //sequência de cadastro do avião
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

            //cadastra novo avião com os dados escolhios pelo usuário
						listaAviao.add(new Aviao(modelo, fileiras, assentos));
						break;
					}

      //tratando excessões
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

    //aviso da criação do avião para o usuário
		numAviao++;
		JOptionPane.showMessageDialog(null, "Avião " + listaAviao.get(numAviao).modelo + " criado com sucesso.");
		return("Success");
	}

  /*cadastro de voos*/
	public static String cadastrarVoo() {
		while (true) {
			try {
			/*variável aviao é usada para escolher qual dos aviões cadastrados será usado para o Voo. Segue a ordem de cadastramento. Então, o primeiro avião 
			cadastrado pelo cadastrarAeronave() é o 0 (que o usuário vê como 1), o segundo cadastrado pelo cadastrarAeronave() é o 1, e assim por diante.
			 */
			String sAviao = JOptionPane.showInputDialog(null, "                  Cadastro de voo\n\n\nInsira o número da Aeronave:");
			if (sAviao == null) {
				JOptionPane.showMessageDialog(null, "Operação cancelada!");
				return("Cancel");
			}
			int aviao = Integer.parseInt(sAviao);
			int total = listaAviao.size();

      //caso o avião escolhido não exista
			if (aviao > total) {
				JOptionPane.showMessageDialog(null, "O avião selecionado não existe.\nLembrando que existem " + listaAviao.size() + " aeronaves cadastradas");
			}

      //caso o avião escolhido exista, demais dados do voo são escolhidos
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

            //cadastra novo voo com os dados escolhidos pelo usuário
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

      //tratando excessões
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
			}
		}

    //aviso da criação do voo para o usuário
		JOptionPane.showMessageDialog(null, "Voo " + listaVoo.get(numVoo).getNro() + " criado com sucesso.");
		return("Success");
	}

  /*fazer reserva*/
	public static String fazerReserva() throws ArrayIndexOutOfBoundsException {
		
		
		//inicializa valores e o iterator
		boolean lugar;
		int num = 0, fileira = 0, assento = 0;
		String nome = "", cpf = "";
		Iterator<Voo> itr = listaVoo.iterator();
		
    //caso não hajam voos cadastrados
		if (itr.hasNext() == false) {
			JOptionPane.showMessageDialog(null,"Nenhum voo cadastrado!");
			return("Noo flights");
		}
		
    //sequência de reserva de passagem
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

      //tratando excessões
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

      //sequência de verificação da disponibilidade do lugar
			int len = listaVoo.size();
			for (int k = 0; k < len; k++) {
				 Voo voo = listaVoo.get(k);
				if (voo.getNro() == num) {
					lugar = voo.getAeronave().verificaLugarOcupado((fileira - 1), (assento - 1));

          //caso o lugar esteja disponível
					if (lugar == false) {
						voo.getAeronave().setPassageiro((fileira - 1), (assento - 1), new Passageiro(nome, cpf));

            //lugar é reservado, e aviso é mostrado ao usuário
						listaPassageiro.add(new Passageiro(nome, cpf));
						JOptionPane.showMessageDialog(null, String.format("Reserva realizada com sucesso!\n\nFileira:      [%d]\nAssento:  [%d]", fileira, assento));
						return("Success");
					}

          //caso o lugar esteja ocupado
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

	/*consulta lugares disponíveis*/
	public static String consultaLugar() {
		Iterator<Voo> itr = listaVoo.iterator();
		
    //caso não hajam voos cadastrados
		if (itr.hasNext() == false) {
			JOptionPane.showMessageDialog(null,"Nenhum voo cadastrado!");
			return("Noo flights");
		}

    //sequência de consulta de lugar
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

      //tratando excessões
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

      //lê na lista de voos quantos lugares disponíveis existem no voo escolhido
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
        
        //mostra ao usuário
				JOptionPane.showMessageDialog(null, "O Voo de número " + voo.getNro() + " tem " + lugar + " lugares disponível(s)");
				return("Success");
				} 
				else {

          //caso o voo escolhido não exista
					System.out.println("Não achou!");
					JOptionPane.showMessageDialog(null,"O número do voo não existe.\nPor favor, escolha outro!");
				}
			}
		}
	}
	
	/*consulta reservas concluídas*/
	public static String consultaReserva() {

    //inicializa variiaveis e o iterator
		 Iterator<Voo> itr = listaVoo.iterator();
		 int len = listaVoo.size();
		 int num = 0;

    //caso não existam voos cadastrados
		if (itr.hasNext() == false) {
			JOptionPane.showMessageDialog(null,"Nenhum voo cadastrado!");
			return("Noo flights");
		}

    //sequência de consulta de reserva
		while (true) {
			try {
				String sNum = (JOptionPane.showInputDialog("Digite o número do Voo:"));
				if (sNum.length() < 1) {
					JOptionPane.showMessageDialog(null, "O número do voo não pode ser vazio!");
					continue;
				}
				num = Integer.parseInt(sNum);
				
			}

      //tratando excessões
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
			  //contabiliza reservas de lugar
			  for (int k = 0; k < len; k++) {
				  Voo voo = listaVoo.get(k);
				  if (voo.getNro() == num) {
	
			      //inicializa índices
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

            //mostra matriz de lugares reservados ao usuário
			      JOptionPane.showMessageDialog(null,"O voo de número " + num + " tem os seguintes lugares reservados: \n\n" + numb);
			      return("Success");
			    }

         //caso o voo escolhido não exista
				 else {
						JOptionPane.showMessageDialog(null,"O número do voo não existe.\nPor favor, escolha outro!");
					}
			  }  	
		}
	}
}