package ForgeGuard.StringManipulation;

public class TicketValidator {
    public static void main(String[] args) {
        String rawTicket = "  name:   Amanda Estevez  ; email: AMANDA.Estevez@GMAIL.com   ; message:    My App Crashed 💥💥   ";
        String cleanedTicket = processTicket(rawTicket);
        System.out.println(cleanedTicket);
    }

    public static String processTicket(String raw) {
        if (raw == null || raw.isBlank()) {
            return "Invalid input: blank or null";
        }
        raw = raw.strip();
        String[] fields = raw.split(";");
        String name = "";
        String email = "";
        String message = "";

        for (String field : fields) {
            String[] parts = field.trim().split(":", 2);
            if (parts.length == 2) {
                String key = parts[0].trim().toLowerCase();
                String value = parts[1].trim();

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
        }
        if (!name.matches("[a-zA-Z ]+")) {
            return "Invalid name: must contain only letters and spaces";
        }
        if (!email.toLowerCase().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")){
            return "Invalid email: does not match email pattern";
        }
        if (message == null || message.isBlank()) {
            return "Invalid message: cannot be empty or blank";
        }
        name = name.trim().replaceAll("\\s+", " ").toLowerCase();
        email = email.trim().toLowerCase();
        message = message.trim();

        StringBuilder output = new StringBuilder();
        output.append(name)
                .append(" | ")
                .append(email)
                .append(" | ")
                .append(message);
        return output.toString();

    }


}
