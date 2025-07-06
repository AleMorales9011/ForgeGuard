package ForgeGuard;

public class CNPJValidator {
    public static boolean checkCNPJ (String cnpj) {
        cnpj = cnpj.replaceAll("\\D","");
        return cnpj.matches("\\D{11}$") && !cnpj.matches("(\\D)\\1{10}");

    }
    public static void main(String[] args){
        System.out.println(checkCNPJ("123.123.123.123-12"));
    }
}
