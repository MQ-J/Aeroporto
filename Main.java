import javax.swing.*;

class Main {
public static void main(String[] args) {

  menuPrincipal();

}
public static void menuPrincipal() {
  int menu = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n\t1 - Parâmetros do Sistema\n\t2 -Reserva de Passagens\n\t3 - Sair"));
  
  switch(menu){
    case 1: parametroSistema(); break;
    case 2: reservaPassagem(); break;
    case 3: System.exit(0); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); menuPrincipal();
  }
}
public static void parametroSistema() {
  System.out.println("Parâmetros do Sistema");
}
public static void reservaPassagem() {
  System.out.println("Reserva de passagens");
}

}