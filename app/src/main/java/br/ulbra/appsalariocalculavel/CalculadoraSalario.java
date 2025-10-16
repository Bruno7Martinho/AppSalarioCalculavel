package br.ulbra.appsalariocalculavel;

public class CalculadoraSalario {
    public static double calcularINSS(double salarioBruto) {
        if (salarioBruto <= 1212.00) return salarioBruto * 0.075;
        else if (salarioBruto <= 2427.35) return salarioBruto * 0.09;
        else if (salarioBruto <= 3641.03) return salarioBruto * 0.12;
        else if (salarioBruto <= 7087.22) return salarioBruto * 0.14;
        else return salarioBruto * 0.14;
    }

    public static double calcularIR(double salarioBruto) {
        if (salarioBruto <= 1903.98) return 0.0;
        else if (salarioBruto <= 2826.65) return salarioBruto * 0.075;
        else if (salarioBruto <= 3751.05) return salarioBruto * 0.15;
        else if (salarioBruto <= 4664.68) return salarioBruto * 0.225;
        else return salarioBruto * 0.225;
    }

    public static double calcularSalarioFamilia(double salarioBruto, int filhos) {
        if (salarioBruto <= 1212.00) return filhos * 56.47;
        else return 0.0;
    }

    public static double calcularSalarioLiquido(double salarioBruto, double inss, double ir, double salarioFamilia) {
        return salarioBruto - inss - ir + salarioFamilia;
    }
}
