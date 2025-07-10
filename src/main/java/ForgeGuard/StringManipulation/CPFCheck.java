package ForgeGuard.StringManipulation;

public class CPFCheck {
    public static boolean cpfCheck (String cpf){
        cpf = cpf.replaceAll("\\D", "");
        return cpf.matches("\\d{11}$") && !cpf.matches("(\\d)\\1{10}");
    }
    public static void main(String[]args) {
        System.out.println(cpfCheck("123.456.789-09"));
    }
}
