import java.io.*;
import minipython.lexer.Lexer;
import minipython.parser.Parser;
import minipython.node.*;
import java.util.*;

public class ParserTest
{
  public static void main(String[] args)
  {
    try
    {
      Parser parser =
        new Parser(
        new Lexer(
        new PushbackReader(
        new FileReader(args[0].toString()), 1024)));

       Hashtable symtable =  new Hashtable();
       Start ast = parser.parse();


           firstVisitor v1 = new firstVisitor(symtable);
           ast.apply(v1);
           if(v1.errorFound()){
              System.exit(0);
           }
           secondVisitor v2 = new secondVisitor(symtable);
           ast.apply(v2);
           if(v2.errorFound()){
            System.exit(0);
           }
           thirdVisitor v3 = new thirdVisitor(symtable);
           ast.apply(v3);
           if(v3.errorFound()){
            System.exit(0);
           }
           

     
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }
}
