package ForgeGuard.StringManipulation;

public class CPFValidator {

    public static boolean isValidCPF(String cpf) {
        // Remove pontuação e espaços
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se tem 11 dígitos ou é uma sequência inválida
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digit1 = (sum * 10) % 11;
        if (digit1 == 10) digit1 = 0;

        // Cálculo do segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digit2 = (sum * 10) % 11;
        if (digit2 == 10) digit2 = 0;

        // Compara com os dígitos fornecidos
        return digit1 == Character.getNumericValue(cpf.charAt(9)) &&
                digit2 == Character.getNumericValue(cpf.charAt(10));
    }

    // Testando o método
    public static void main(String[] args) {
        String cpfValido = "123.456.789-09";
        String cpfInvalido = "111.111.111-11";

        System.out.println("CPF válido? " + isValidCPF(cpfValido));
        System.out.println("CPF inválido? " + isValidCPF(cpfInvalido));
    }
}
