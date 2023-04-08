public class Game {
    public static void main(final String[] args) {
        // This code is checking if the length of the `args` array is greater than 0
        if(!(args.length > 0)){
            System.out.println("ERROR : missing argument (Input .txt file)");
            System.exit(-1);
        }
    }
}