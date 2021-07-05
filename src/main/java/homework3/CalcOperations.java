package homework3;

public class CalcOperations {

    public String Calc (String operation, int value1, int value2) throws Exception {
        String operations;

        switch (operation) {
            case "add":
                operations = (value1 + " + " + value2 + " = " + (value1 + value2));
                break;
            case "substract":
                operations = (value1 + " - " + value2 + " = " + (value1 - value2));
                break;
            case "multiply":
                operations = (value1 + " * " + value2 + " = " + (value1 * value2));
                break;
            case "divide":
                operations = (value1 + " / " + value2 + " = " + (value1 / value2));
                break;
            default:
                throw new Exception();

        }
        return operations;
    }
}
