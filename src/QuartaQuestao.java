public class QuartaQuestao {
    public static void main(String[] args) {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outrosEstados = 19849.53;
        double totalFaturamentoEstados = sp + rj + mg + es + outrosEstados;

        double porcentualSp = (sp / totalFaturamentoEstados) * 100;
        double porcentualRj = (rj / totalFaturamentoEstados) * 100;
        double porcentualMg = (mg / totalFaturamentoEstados) * 100;
        double porcentualEs = (es / totalFaturamentoEstados) * 100;
        double porcentualOutrosEstados = (outrosEstados / totalFaturamentoEstados) * 100;

        System.out.printf("Porcentual de SP: %.2f%%\n", porcentualSp);
        System.out.printf("Porcentual de RJ: %.2f%%\n", porcentualRj);
        System.out.printf("Porcentual de MG: %.2f%%\n", porcentualMg);
        System.out.printf("Porcentual de ES: %.2f%%\n", porcentualEs);
        System.out.printf("Porcentual de outros estados: %.2f%%\n", porcentualOutrosEstados);

    }
}
