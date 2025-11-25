import java.util.Scanner;
public class Loja{
    public static final int QTD = 100;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Produto [] produtos = new Produto[QTD];
        int qtd = 0;
        int opcao = -1;
        while (opcao !=0) {
            imprimirMenu();
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    qtd= preencherProduto(produtos, qtd);
                    break;
                case 2:
                    imprimirVetorProdutos(produtos, qtd);
                    break;
                case 3:
                    System.out.printf("Digite a categoria para filtrar: ");
                    String categoria = input.nextLine();
                    imprimirPorCategoria(produtos, qtd, categoria);
                    break;  
                case 4:
                    ordenarProdutosPorNome(produtos, qtd);
                    System.out.printf("Produtos ordenados por nome com sucesso!\n");
                    break;
                case 5:
                    System.out.printf("Digite o nome do produto a ser removido: ");
                    String nomeRemover = input.nextLine();
                    qtd= removerProduto(produtos, qtd, nomeRemover);
                    break;
                case 6: 
                    atualizarPreco(produtos, qtd);
                    break;
                case 7:
                    listarPorCategoria(produtos, qtd);
                    break;
                default:
                    break;
            }
        }


        
    }
    public static int preencherProduto(Produto [] p, int qnt){
        p[qnt] = new Produto();
        System.out.printf("Digite o nome do produto: ");
        p[qnt].nome = input.nextLine();
        while (buscarProduto(p, qnt, p[qnt].nome) != -1) {
            System.out.printf("Produto já cadastrado!\n");
            System.out.printf("Digite o nome do produto: ");
            p[qnt].nome = input.nextLine();
        }
        System.out.printf("\nDigite a descrição do produto: ");
        p[qnt].descricao = input.nextLine();
        System.out.printf("\nDigite a categoria do produto: ");
        p[qnt].categoria = input.nextLine();
        System.out.printf("\nDigite o preço do produto: ");
        p[qnt].preco = input.nextDouble();
        System.out.printf("\nDigite o estoque do produto: ");
        p[qnt].qntEstoque = input.nextInt();
        System.out.printf("\nDigite a quantidade do estoque mínimo: ");
        p[qnt].qntMinima = input.nextInt();
        input.nextLine();
        System.out.println("Produto cadastrado com sucesso!\n");
        return qnt +1;
    }

    

    public static void imprimirVetorProdutos(Produto[] p,int qnt){
        if (qnt == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for(int i = 0;i < qnt; i+=1){
            System.out.printf("Produto %d:",i+1);
            imprimirProdutos(p[i]);
        }
    }

    public static void imprimirProdutos(Produto p){
        System.out.printf("nome: %s\n",p.nome);
        System.out.printf("descrição: %s\n",p.descricao);
        System.out.printf("Categoria: %s\n",p.categoria);
        System.out.printf("Preço: %.2f\n ",p.preco);
        System.out.printf("Estoque: %d\n",p.qntEstoque);
        System.out.printf("Quantidade mínima: %d\n",p.qntMinima);
        System.out.println("-------------------------------------");
    }

    public static void imprimirMenu(){
        System.out.println("*Controle de estoque*");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2- Listar");
        System.out.println("3- Filtrar por categoria");
        System.out.println("4- Ordenar");
        System.out.println("5- Remover elemento");
        System.out.println("6- Atualizar preço");
        System.out.println("7- Listar subtotal por categoria");
        System.out.println("0- Sair");
        System.out.printf("Digite a opção desejada: ");
        
    }

    public static int buscarProduto(Produto[] p, int qnt, String nome){
        for(int i =0; i < qnt;i+=1){
            if(p[i].nome.equalsIgnoreCase(nome)){
                return i;
            }
        }
        return -1;
    }

    public static double subtotalCategoria(Produto[] p, int qnt, String categoria){
        double subtotal = 0;
        for(int i =0; i < qnt;i+=1){
            if(p[i].categoria.equalsIgnoreCase(categoria)){
                subtotal += p[i].preco * p[i].qntEstoque;
            }
        }
        return subtotal;
    }

    public static void imprimirPorCategoria(Produto[] p, int qnt, String categoria){
        int encontrado = 0;
        for(int i =0; i < qnt;i+=1){
            if(p[i].categoria.equalsIgnoreCase(categoria)){
                imprimirProdutos(p[i]);
                encontrado += 1;
            }
        }
        if(encontrado == 0){
            System.out.println("Nenhum produto encontrado nessa categoria.");
        }
    }

    public static void listarPorCategoria(Produto[] p, int qnt) {
        if (qnt == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        String[] categoriasListadas = new String[qnt];
        int qtdCat = 0;

        for(int i = 0; i < qnt; i++) {

            boolean jaExiste = false;

            for(int j = 0; j < qtdCat; j++) {
                if (categoriasListadas[j].equalsIgnoreCase(p[i].categoria)) {
                    jaExiste = true;
                    break;
                }
            }

            if (!jaExiste) {
                categoriasListadas[qtdCat] = p[i].categoria;
                qtdCat++;

                System.out.printf("Categoria: %s\n", p[i].categoria);
                imprimirPorCategoria(p, qnt, p[i].categoria);
                System.out.printf("Subtotal: %.2f\n", subtotalCategoria(p, qnt, p[i].categoria));
                System.out.println("----------------------------");
            }
        }
    }

    public static void ordenarProdutosPorNome(Produto[] p, int qnt){
        for(int i =0; i < qnt -1;i+=1){
            for(int j = i +1; j < qnt;j+=1){
                if(p[i].nome.compareToIgnoreCase(p[j].nome) > 0){
                    Produto temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }

    public static int removerProduto(Produto[] p, int qnt, String nome){
        int indice = buscarProduto(p, qnt, nome);
        if (indice == -1) {
            System.out.println("Produto não encontrado. Não foi possível remover.");
            return qnt;
        }
        for(int i = indice; i < qnt -1;i+=1){
            p[i] = p[i +1];
        }
        return qnt -1;
    }
    
    public static void atualizarPreco(Produto[] p, int qnt){
        if (qnt == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.printf("Digite o nome do produto para atualizar o preço: ");
            String nome = input.nextLine();
            int indice = buscarProduto(p, qnt, nome);
            if(indice == -1){
                System.out.println("Produto não encontrado.");
                return;
            }
            System.out.printf("Digite o novo preço: ");
            p[indice].preco = input.nextDouble();;
            System.out.println("Preço atualizado com sucesso.");
    }
}