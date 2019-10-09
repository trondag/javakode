package trondg.task1;

class Counter {

    static String count(int number) throws TooNegativeException {
        if (number <= 0) {
            throw new TooNegativeException("Numbers below one is not accepted");
        }
        else if (number > 100){ return "100";}
        else if ((number % 3 == 0) && (number % 5 == 0)){return "HiOf";}
        else if (number % 3 == 0){ return "Hi";}
        else if (number % 5 == 0){ return "Of";}
        return Integer.toString(number);
    }

}
