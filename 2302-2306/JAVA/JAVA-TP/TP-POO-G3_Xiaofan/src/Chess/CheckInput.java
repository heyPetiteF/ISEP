package Chess;

public class CheckInput {

    //Requires the input
    public boolean checkCoordinateValidity(String input) {
        return input.length() == 2 && input.charAt(0) >= '1' && input.charAt(0) <= '8' && input.charAt(1) >= 'a' && input.charAt(1) <= 'h';
    }

    public String handleUserInput(String input) {
        //Checking validity
        if (!checkCoordinateValidity(input)) {
            //trying to guess the correct user input
            input = input.trim().replace(" ", "").toLowerCase();

            if (input.length() == 2 && input.charAt(0) >= 'a' && input.charAt(0) <= 'h') {
                //reverse
                input = "" + input.charAt(1) + input.charAt(0);
            }

            //recheck
            if (checkCoordinateValidity(input)) {
                System.out.println("【ERROR】Non-compliant input. YOU WANT \"" + input + "\"? (y/n)");
                return null;
            /*    if (!System.console().readLine().toLowerCase().startsWith("y")) {
                    System.out.println("【ERROR】Please try again.");
                    return null;
                }
            }
            else {
                System.out.println("【ERROR】Invalid input. Please try again.");
                return null;
            }*/
            }

            return input;
        }
        return input;
    }
}