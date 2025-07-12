package ForgeGuard.StringManipulation;

public class CPFChecker {
    public static boolean Validator (String cpf) {
        cpf = cpf.replaceAll("\\d", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\1{10}"));
        return false;
    }
    public static void main (String[] args){
        CPFChecker solver = new CPFChecker();
        String cpf = "111.111.111-11";
        System.out.println("The CPF is Valid: " + Validator(cpf));
    }
}

