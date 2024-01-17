import java.util.Scanner;

public class BrainFuck {
    public static void main(String[] args) {
        BFInterpreter bf = new BFInterpreter();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String code = sc.nextLine();
            if (code.length() == 0)
                break;
            bf.initialize(code);
            bf.execute();
            System.out.println();
        }
        sc.close();
    }
}

class BFInterpreter {
    BFMachine bf;
    String code;
    int loc;

    void initialize(String code) {
        bf = new BFMachine();
        this.code = code;
        loc = 0;
    }

    void execute() {
        while (loc < code.length()) {
            char c = code.charAt(loc);
            switch (c) {
                case '>':
                    bf.addPtr();
                    break;
                case '<':
                    bf.subPtr();
                    break;
                case '+':
                    bf.plus();
                    break;
                case '-':
                    bf.minus();
                    break;
                case '.':
                    bf.putByte();
                    break;
                case ',':
                    bf.getByte();
                    break;
                case '[':
                    if (bf.currentByte() == 0) {
                        jumpBracket();
                    }
                    break;
                case ']':
                    jumpAhead();
                    break;
                default:
                    break;
            }
            loc++;
        }
    }

    void jumpBracket() {
        int stack = 1;
        while (stack > 0) {
            ++loc;
            char c = code.charAt(loc);
            if (c == '[') {
                stack++;
            }
            if (c == ']') {
                stack--;
            }
        }
    }

    void jumpAhead() {
        int stack = 1;
        while (stack > 0) {
            --loc;
            char c = code.charAt(loc);
            if (c == '[') {
                --stack;
            }
            if (c == ']') {
                ++stack;
            }
        }
        --loc;
    }
}

class BFMachine {
    int ptr;
    byte[] arr;

    BFMachine() {
        arr = new byte[3000];
        ptr = 0;
    }

    void addPtr() {
        ptr += 1;
    }

    void subPtr() {
        ptr -= 1;
    }

    void plus() {
        arr[ptr] += 1;
    }

    void minus() {
        arr[ptr] -= 1;
    }

    void putByte() {
        System.out.print((char)arr[ptr]);
    }

    void getByte() {
        try {
            arr[ptr] = (byte) System.in.read();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    byte currentByte() {
        return arr[ptr];
    }
}