import javax.swing.*;

class Main {
public static void main(String[] args) {

  menuPrincipal();

}
public static void menuPrincipal() {
  System.out.println("Menu Principal");
  System.out.print("\t1 - Parâmetros do Sistema\n\t2 -Reserva de Passagens\n\t3 - Sair");

  parametroSistema();
  reservaPassagem();
}
public static void parametroSistema() {
  System.out.println("Parâmetros do Sistema");
}
public static void reservaPassagem() {
  System.out.println("Reserva de passagens");
}

}