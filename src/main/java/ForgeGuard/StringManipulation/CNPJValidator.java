package ForgeGuard.StringManipulation;
public class CNPJValidator {
    public static boolean checkCNPJ (String cnpj){
        cnpj = cnpj.replaceAll("\\D","");
        return cnpj.matches("\\D{11}$") && !cnpj.matches("(\\D)\\1{10}");
    }
    public static void main (String[] args){
        System.out.println("CNPJ is valid?" + checkCNPJ("123.456.789-09"));
    }
}