# Projeto_Semestral_LP1A3

Projeto semestral da matéria de Linguagem de Programação 1, do curso de TADS do IFSP.
Fiz em dupla com o Maurício, em uns 3 dias, e foi gratificante perceber que, como ambos ja tinham as demais classes, a construção do Main foi simples, sem muita interferência com códigos diferentes. A apresentação do projeto está neste link do youtube: https://youtu.be/zuT4GQETuC4
```diff
! Lidamos com criação de objetos em arrayList:
+ listaAviao.add(new Aviao(modelo, fileiras, assentos));
```
```diff
! O uso de try catch era um requisito também:
+ catch (NumberFormatException |  NullPointerException e){
+	 if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
+	 JOptionPane.showMessageDialog(null, "A opção selecionada não é um número!");
+	}}
```
```diff
! Mas a cereja do bolo foi concatenar vários int em uma string em um loop, e somar essas strings em uma string final:
+ numb = numb + "[" + (i+1) + "][" + (j+1) + "]\n";
```
![image](https://user-images.githubusercontent.com/61765516/146695710-96e8a389-62bc-4976-81c6-01ca17b5b6e5.png)

