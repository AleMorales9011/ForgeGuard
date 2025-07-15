package ForgeGuard.StringManipulation;

public class Validator {
    public static String InputValidator(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            System.out.println("Invalid Input");
        }
        userInput = userInput.trim().strip();

        String[] fields = userInput.split(";");
        String name = "";
        String email = "";
        String message = "";

        for (String fieldParts : fields) {
            String[] parts = fieldParts.trim().split(":", 2);
            String key = parts[0].trim().strip().toLowerCase();
            String value = parts[1].trim().strip().toLowerCase();

            switch (key) {
                case "name":
                    name = value;
                    break;
                case "email":
                    email = value;
                    break;
                case "message":
                    message = value;
                    break;
            }
        }

        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid Name");
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            System.out.println("Invalid Email");
        }
        if (message == null || message.isBlank()) {
            System.out.println("Invalid message");
        }

        StringBuilder output = new StringBuilder();
        output.append(name)
                .append(" | ")
                .append(email)
                .append(" | ")
                .append(message);
        return output.toString();

    }
    public static void main(String[] args) {
        String message = "  name:   Amanda Estevez  ; email: AMANDA.Estevez@GMAIL.com   ; message:    My App Crashed";
        String output = Validator.InputValidator(message);
        System.out.println("Output: " + output);
    }
}
