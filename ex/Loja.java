import java.util.Scanner;
public class Loja{
    public static final int QTD = 1;
    public static final int QTDVETOR = 10;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Produto [] produtos = new Produto[QTDVETOR];
        popularVetor(produtos, QTD);
        preencherVetorProdutos(produtos, QTD);
        imprimirVetorProdutos(produtos, QTD);
        
    }
    public static void preencherProduto(Produto p){
        System.out.printf("Digite o nome do produto: ");
        p.nome = input.nextLine();
        System.out.printf("\nDigite a descrição do produto: ");
        p.descricao = input.nextLine();
        System.out.printf("\nDigite o preço do produto: ");
        p.preco = input.nextDouble();
        System.out.printf("\nDigite o estoque do produto: ");
        p.qntEstoque = input.nextInt();
        input.nextLine();
    }

    public static void preencherVetorProdutos(Produto[] p ,int qnt){
        for(int i = 0;i < qnt; i+=1){
            preencherProduto(p[i]);
        }
    }

    public static void imprimirVetorProdutos(Produto[] p,int qnt){
        for(int i = 0;i < qnt; i+=1){
            System.out.printf("Produto %d:",i);
            imprimirProdutos(p[i]);
        }
    }

    public static void imprimirProdutos(Produto p){
        System.out.printf("nome: %s\n",p.nome);
        System.out.printf("descrição: %s\n",p.descricao);
        System.out.printf("Preço: %.2f\n ",p.preco);
        System.out.printf("Estoque: %d\n",p.qntEstoque);
        System.out.println("-------------------------------------");
    }

    public static void popularVetor(Produto[] p, int qnt){
        for(int i =0; i <= qnt;i+=1){
            p[i] = new Produto();
        }
    }
    public static void imprimirMenu(){
        System.out.println("Controle de estoque");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2- remover produto");
        System.out.println("0- Sair");
    }


}