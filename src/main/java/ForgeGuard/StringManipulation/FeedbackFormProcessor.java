package ForgeGuard.StringManipulation;

import java.util.Arrays;

public class FeedbackFormProcessor {
    public String messageProcessor(String rawString) {
        if (rawString == null) { // Check for no input.
            System.out.println("No message to display");
        } else
            System.out.println("The input message is valid...starting to clean up");
        System.out.println("1. Stripping String...");
        rawString = rawString.strip();// Removes leading and trailing spaces
        System.out.println("String Stripped: " + rawString);
        System.out.println("2. Extracting fields..."+ "\n");

        String[] extractedFields = rawString.split(";"); // Split by ";" and aggregates into an array.
        String name = "";
        String rating = "";
        String comment = "";

        for (String fieldParts : extractedFields){ // Maps each part in the array
            String[] extractedParts = fieldParts.trim().split(":", 2); // Trim and split into 2 places by the ":"
            if (extractedParts.length == 2){
                String key = extractedParts[0].trim().toLowerCase(); // Trims and lower Cases the left side array
                String value = extractedParts[1].trim().toLowerCase(); // Trims and lower Cases the right side of the array.
                switch(key) { //  Map keys to values
                    case "user":
                        name = value;
                        break;
                    case "rating":
                        rating = value;
                        break;
                    case "comment":
                        comment = value;
                        break;
                }
            }
        }

        System.out.println("name: " + name);
        System.out.println("rating: " + rating);
        System.out.print("comment: " + comment + "\n");

        if (name.matches("[a-zA-Z ]+")){
            System.out.println("The name is valid");
        }else
            System.out.println("The name is not valid");
        if (rating.matches("\\d") && Integer.parseInt(rating) <= 5 && Integer.parseInt(rating) >= 1){
            System.out.println("The rating is valid");
        }else
            System.out.println("The rating is not valid");
        if (comment.isBlank()){
            System.out.println("The comment is blank");
        }else
            System.out.println("The message is valid");

        StringBuilder output = new StringBuilder();
        output.append(name)
                .append(" | ")
                .append(rating)
                .append(" | ")
                .append(comment);
        return "Final Output: " + output.toString();
    }

    public static void main(String[] args) {
        FeedbackFormProcessor solver = new FeedbackFormProcessor();
        String InputMessage = "  user:   JOHN DOE  ; rating:  5  ; comment:   Loved the product!!! 😍   ";
        String OutputMessage = solver.messageProcessor(InputMessage);
        System.out.println(OutputMessage);
    }
}
