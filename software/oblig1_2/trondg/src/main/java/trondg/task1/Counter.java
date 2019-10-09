package trondg.task1;

class Counter {

    static String count(int number){
        if (number < 1){ return "1";}
        else if (number > 100){ return "100";}
        return Integer.toString(number);
    }

}
