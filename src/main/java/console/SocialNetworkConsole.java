package console;

import java.util.Scanner;

public class SocialNetworkConsole {
    public void writeLine(String string) {
        System.out.println(string);
    }

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
