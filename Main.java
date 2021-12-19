import javax.swing.*; //para mensagens pop-up
import java.util.*; //para arraylist

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

/*MÉTODO MAIN*/
public static void main(String[] args) {

  menuPrincipal();

}

/*MENU PRINCIPAL*/
public static void menuPrincipal() {

  //usuário escolhe menu
  String op = JOptionPane.showInputDialog("Menu Principal\n\t1 - Parâmetros do Sistema\n\t2 - Reserva de Passagens\n\t3 - Sair");
  char menu = '0';
  if (op.length() == 1) {
    menu = op.charAt(0);
  }
  
  //opções do menu
  switch(menu){
    case '1': parametroSistema(); break;
    case '2': reservaPassagem(); break;
    case '3': System.exit(0); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); menuPrincipal();
  }
}

/*PARÂMETROS DO SISTEMA*/
public static void parametroSistema() {

  //usuário escolhe menu
  String op = JOptionPane.showInputDialog("Parâmetros do Sistema\n\t1 - Cadastrar Aeronave\n\t2 - Cadastrar Voo\n\t3 - Voltar");
  char menu = '0';
  if (op.length() == 1) {
    menu = op.charAt(0);
  }

  //opções do menu
  switch(menu){
    case '1': cadastraAviao(); parametroSistema(); break;
    case '2': cadastraVoo(); parametroSistema(); break;
    case '3': menuPrincipal(); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); parametroSistema();
  }
}

/*RESERVA DE PASSAGENS*/
public static void reservaPassagem() {

  //usuário escolhe menu
  String op = JOptionPane.showInputDialog("Reserva de Passagens\n\t1 - Fazer reserva\n\t2 - Consultar lugares vazios\n\t3 - Consultar reservas realizadas\n\t4 - Voltar");
  char menu = '0';
  if (op.length() == 1) {
    menu = op.charAt(0);
  }

  //opções do menu
  switch(menu){
    case '1': fazerReserva(); reservaPassagem(); break;
    case '2': consultaLugar(); reservaPassagem(); break;
    case '3': consultaReserva(); reservaPassagem(); break;
    case '4': menuPrincipal(); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); reservaPassagem();
  }
}

/*CADASTRO DE AVIÃO*/
public static void cadastraAviao() {

  //usuário digita dados do avião
  String modelo = JOptionPane.showInputDialog("Digite o modelo do avião");
  int fileiras = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de fileiras:"));
  int assentos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de assentos por fileira:"));

  //novo avião é criado
  numAviao++;
  listaAviao.add(numAviao, new Aviao(modelo, fileiras, assentos));
  JOptionPane.showMessageDialog(null, "Avião " + listaAviao.get(numAviao).modelo + " criado com sucesso.");
}

/*FUNÇÃO DE CADASTRAR VOOS*/
public static void cadastraVoo() {

  //usuário digita dados do voo
  int aviao = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do avião:"));
  int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Voo:"));
  String data = JOptionPane.showInputDialog("Digite a data do voo:");
  String hora = JOptionPane.showInputDialog("Digite a hora do voo:");

  //novo voo é criado
  numVoo++;
  listaVoo.add(numVoo,new Voo(listaAviao.get(aviao-1), num, data, hora));
  JOptionPane.showMessageDialog(null, "Voo " + listaVoo.get(numVoo).getNro() + " criado com sucesso.");
}

/*FUNÇÃO DE FAZER RESERVA*/
public static void fazerReserva() {

  //passageiro escolhe voo
  int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Voo:"));

  //iterador para percorrer lista de voo
  Iterator<Voo> itr = listaVoo.iterator();

  //pesquisa se há voo com este número
  int lugar = 0;
	while(itr.hasNext()){
	  Voo voo =(Voo)itr.next();
    if (voo.getNro() == num) {

      //pesquisa se há lugares disponíveis no avião deste voo
      for (int i = 0; i < voo.getAeronave().lugares.length; i++) {
        for (int j = 0; j < voo.getAeronave().lugares[0].length; j++) {
          if (voo.getAeronave().lugares[i][j] == null) {
            lugar++;
          }
        }
      }

      //avisa caso não haja vagas no voo
      if (lugar == 0) {
        JOptionPane.showMessageDialog(null, "Este avião está lotado!");
      } else {

        //passageiro confirma reserva?
        String op = JOptionPane.showInputDialog("Confirmar reserva?\n\tS - sim\n\tN - não");
        char menu = '0';
        if (op.length() == 1) {
          menu = op.charAt(0);
        }

        //caso sim, programa cria passageiro e reserva lugar
        switch(menu) {
          case 'n': case 'N': break;
          case 's': case 'S':
          //parte onde vai ter o new passageiro reservando lugar
          break;
          default: JOptionPane.showMessageDialog(null, "Opção inválida"); fazerReserva();
        }
      }
    }
  }
}

/*FUNÇÃO DE CONSULTAR LUGAR*/
public static void consultaLugar() {

  //passageiro escolhe voo
  int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Voo:"));

  //iterador para percorrer lista de voo
  Iterator<Voo> itr = listaVoo.iterator();

  //pesquisa se há voo com este número
	while(itr.hasNext()){
	  Voo voo =(Voo)itr.next();
    if (voo.getNro() == num) {

    //pesquisa quantos lugares estão disponíveis
    int lugar = 0;
    for (int i = 0; i < voo.getAeronave().lugares.length; i++) {
      for (int j = 0; j < voo.getAeronave().lugares[0].length; j++) {
        if (voo.getAeronave().lugares[i][j] == null) {
          lugar++;
        }
      }
    }

    //apresenta resultado ao usuário
    JOptionPane.showMessageDialog(null, "O Voo de número " + voo.getNro() + " tem " + lugar + " lugares disponível(s)");
    } break;
  }
}

/*FUNÇÃO DE CONSULTAR RESERVA*/
public static void consultaReserva() {
  
  //passageiro escolhe voo
  int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Voo:"));

  //iterador para percorrer lista de voo
  Iterator<Voo> itr = listaVoo.iterator();

  //pesquisa se há voo com este número
	while(itr.hasNext()){
	  Voo voo =(Voo)itr.next();
    if (voo.getNro() == num) {

      //cria vetor de lugares ocupados
      String[][] lugar = new String [voo.getAeronave().lugares.length][voo.getAeronave().lugares.length];
      int i, j;
    
      //pesquisa quantos lugares estão reservados
      for (i = 0; i < voo.getAeronave().lugares.length; i++) {
        for (j = 0; j < voo.getAeronave().lugares.length; j++) {
          if (voo.getAeronave().lugares[i][j] == null) {
            lugar[i][j] = "L";
          }
        }
      }
      JOptionPane.showMessageDialog(null,"O voo de número " + num + " tem os seguintes lugares reservados: " + lugar);
    } break;
  }
}
}