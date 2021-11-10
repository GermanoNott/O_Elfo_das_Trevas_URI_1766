import java.util.*;

public class Main {
    public static class Renas {
        private String nome;
        private int peso;
        private int idade;
        private double altura;

        public Renas(String nome, int peso, int idade, double altura) {
            this.nome = nome;
            this.peso = peso;
            this.idade = idade;
            this.altura = altura;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        @Override
        public String toString() {
            return "Renas{" +
                    "nome='" + nome + '\'' +
                    ", peso=" + peso +
                    ", idade=" + idade +
                    ", altura=" + altura +
                    '}';
        }
    }

    public static class Ordernar implements Comparator<Renas>{

        @Override
        public int compare(Renas rena1, Renas rena2) {
            if(rena1.getPeso() > (rena2.getPeso())){
                return -1;
            } else if (rena1.getPeso() < rena2.getPeso()){
                return 1;
            } else {
                if (rena1.getIdade() > (rena2.getIdade())){
                    return 1;
                } else if (rena1.getIdade() < (rena2.getIdade())){
                    return -1;
                } else {
                    if (rena1.getAltura() > rena2.getAltura()){
                        return 1;
                    } else if (rena1.getAltura() < rena2.getAltura()){
                        return -1;
                    } else {
                        if (rena1.getNome().compareTo(rena2.getNome()) > 0){
                            return 1;
                        }else if (rena1.getNome().compareTo(rena2.getNome()) < 0){
                            return -1;
                        } else {
                            return 0;
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Renas> listaRenas = new ArrayList<>();
        Scanner dados = new Scanner(System.in);
        int nCasos = dados.nextInt();
        for (int i = 0; i < nCasos; i++) {
            listaRenas.clear();
            int nRenas = dados.nextInt();
            int renasPuxando = dados.nextInt();
            for (int j = 0; j < nRenas; j++) {
                listaRenas.add(new Renas(dados.next(), dados.nextInt(), dados.nextInt(), dados.nextDouble()));
            }
            Collections.sort(listaRenas, new Ordernar());
            System.out.println("CENARIO {"+(i+1)+"}");
            for (int j = 0; j < renasPuxando ; j++) {
                System.out.println((j+1)+" - "+ listaRenas.get(j).getNome());
            }
        }
    }
}
