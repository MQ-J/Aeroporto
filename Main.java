import javax.swing.*;

class Main {
public static void main(String[] args) {

  menuPrincipal();

}

public static void menuPrincipal() {
  int menu = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n\t1 - Parâmetros do Sistema\n\t2 - Reserva de Passagens\n\t3 - Sair"));
  
  switch(menu){
    case 1: parametroSistema(); break;
    case 2: reservaPassagem(); break;
    case 3: System.exit(0); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); menuPrincipal();
  }
}
public static void parametroSistema() {
  int menu = Integer.parseInt(JOptionPane.showInputDialog("Parâmetros do Sistema\n\t1 - Cadastrar Aeronave\n\t2 - Cadastrar Voo\n\t3 - Voltar"));

  switch(menu){
    case 1: cadastraAviao(); break;
    case 2: System.out.println("cadastra voo"); break;
    case 3: menuPrincipal(); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); parametroSistema();
  }
}
public static void reservaPassagem() {
  int menu = Integer.parseInt(JOptionPane.showInputDialog("Reserva de Passagens\n\t1 - Fazer reserva\n\t2 - Consultar lugares vazios\n\t3 - Consultar reservas realizadas\n\t4 - Voltar"));

  switch(menu){
    case 1: System.out.println("fazer reserva"); break;
    case 2: System.out.println("consultar lugares vazios"); break;
    case 3: System.out.println("consultar reservas realizadas"); break;
    case 4: menuPrincipal(); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); reservaPassagem();
  }
}
//CADASTRO DE AVIÃO
public static void cadastraAviao() {

  //usuário digita dados do avião
  String modelo = JOptionPane.showInputDialog("Digite o modelo do avião");
  int fileiras = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de fileiras:"));
  int assentos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de assentos por fileira:"));

  //novo avião é criado
  new Aviao(modelo, fileiras, assentos);

  //aviso de conclusão para o usuário
  JOptionPane.showMessageDialog(null, "Avião" + modelo + " criado com sucesso.");
}

}