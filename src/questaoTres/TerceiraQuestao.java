package questaoTres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerceiraQuestao {
    public static void main(String[] args) {
        String caminhoArquivo = "C:\\Users\\Nicolas\\Documents\\oracle_alura\\java\\test-target-sistemas\\src\\questaoTres\\dados.json";
        BufferedReader arquivoNaMemoria = null;

        try {
            arquivoNaMemoria = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            double menor = 0;
            double maior = 0;
            double soma = 0;
            int diasContados = 0;

            String temporaria = "";
            List<Faturamento> listaFaturamento = new ArrayList<>();

            while ((linha = arquivoNaMemoria.readLine()) != null) {
                temporaria += linha.trim();
                if (temporaria.contains("dia") && temporaria.contains("valor") && temporaria.contains("}")) {
                    String diaRegex = "\"dia\":\\s*(\\d+)";
                    String valorRegex = "\"valor\":\\s*([\\d\\.]+)";

                    Matcher diaMatcher = Pattern.compile(diaRegex).matcher(temporaria);
                    Matcher valorMatcher = Pattern.compile(valorRegex).matcher(temporaria);

                    int dia = 0;
                    if (diaMatcher.find()) {
                        dia = Integer.parseInt(diaMatcher.group(1));
                    } else {
                        System.out.println("Nenhum dia encontrado.");
                        continue;
                    }

                    if (valorMatcher.find()) {
                        double valor = Double.parseDouble(valorMatcher.group(1));
                        Faturamento faturamento = new Faturamento(dia, valor);
                        listaFaturamento.add(faturamento);
                    } else {
                        return;
                    }
                    temporaria = "";
                }
            }

            for (Faturamento faturamento : listaFaturamento) {
                double valor = faturamento.getValor();
                if (valor < menor || menor == 0) menor = valor;
                if (valor > maior || maior == 0) maior = valor;
                if (valor > 0) {
                    soma += valor;
                    diasContados++;
                }
            }

            double media = diasContados > 0 ? soma / diasContados : 0;
            int diasAcimaMedia = 0;

            for (Faturamento faturamento : listaFaturamento) {
                double valor = faturamento.getValor();
                if (valor >= media) {
                    diasAcimaMedia++;
                }
            }

            arquivoNaMemoria.close();
            arquivoNaMemoria = new BufferedReader(new FileReader(caminhoArquivo));

            System.out.printf("Menor valor: R$%.2f\n", menor);
            System.out.printf("Maior valor: R$%.2f\n" , maior);
            System.out.println("Dias acima da média: " + diasAcimaMedia);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
