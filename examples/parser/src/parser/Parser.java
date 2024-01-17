package parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import tree_machine.Machine;
import tree_machine.exp.*;
import tree_machine.exp.Primitives.Lambda;

import static tree_machine.exp.Primitives.*;
import static tree_machine.utils.List.BEGIN;
import static tree_machine.exp.Leaf.*;
import static tree_machine.exp.Node.*;

public class Parser {
    int loc;
    ArrayList<String> lexes;
    static String[] prims = new String[] {
        "define", "if", "lambda", "displayln"
    };
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("You need provide a file name.");
            System.exit(1);
        }
        String code = readFile(args[0]);
        Lexer lexer = new Lexer(code);
        //System.out.println(lexer.parse());

        Parser parser = new Parser(lexer.parse());
        //System.out.println(parser.parseCode());
        Machine machine = new Machine(parser.parseCode());
        machine.run();
    }

    Parser(ArrayList<String> lexes) {
        loc = 0;
        this.lexes = lexes;
    }

    TreeNode parseNum(String s) {
        return NUM(Double.parseDouble(s));
    }

    TreeNode parseCode() {
        return SEQ(parseCodeToList());
    }

    TreeNode parseCodeToList() {
        if (loc < lexes.size()) {
            TreeNode cmd = parse();
            return CONS(cmd, parseCodeToList());
        }
        return NIL;
    }

    TreeNode parse() {
        String lex = lexes.get(loc);
        //System.out.println("current lex: " + lex + " " + loc);
        if (lex.equals("(")) {
            loc++;
            if (!isPrim(lexes.get(loc)))
                return parseList();
            else
                return parse();
        } else if (lex.equals(")")) {
            loc++;
            return NIL;
        } else if (lex.equals("begin")) {
            loc++;
            return BEGIN(parseList());
        } else if (Character.isDigit(lex.charAt(0))) {
            loc++;
            return parseNum(lex);
        } else if (lex.equals("define")) {
            loc++;
            String id = lexes.get(loc);
            loc++;
            TreeNode value = parse();
            return DEF(id, value);
        } else if (lex.equals("lambda")) {
            loc++;
            TreeNode vars = parse();
            //System.out.println("vars: " + vars);
            loc++;
            TreeNode body = parseList();
            //System.out.println("body: " + body);
            return new Lambda(vars, body);
        } else if (lex.equals("if")) {
            loc++;
            TreeNode condition = parse();
            TreeNode left = parse();
            TreeNode right = parse();
            loc++; // skip right parenthesis
            return IF(condition, left, right);
        } else if (lex.equals("displayln")) {
            loc++;
            return PRINT(parse());
        } else if (lex.equals("#t")) {
            return BOOL(true);
        } else if (lex.equals("#f")) {
            return BOOL(false);
        } else {
            loc++;
            return VAR(lex);
        }
    }

    TreeNode parseList() {
        if (lexes.get(loc).equals("cons")) {
            TreeNode left = parse();
            TreeNode right = parse();
            return CONS(left, right);
        }
        TreeNode first = parse();
        if (first == NIL) {
            return first;
        }
        return CONS(first, parseList());
    }

    boolean isPrim(String s) {
        for (String p : prims) {
            if (s.equals(p))
                return true;
        }
        return false;
    }

    static String readFile(String file) {
        try {
            return Files.readString(Path.of(file));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
