import antlrarchivos.PlSqlLexer;
import antlrarchivos.PlSqlParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // Ruta al archivo de entrada
        String inputFilePath = "src/input.txt";
        String outputFilePath = "src/output.txt";

        // Crear un analizador l�xico
        PlSqlLexer lexer = new PlSqlLexer(CharStreams.fromFileName(inputFilePath));

        // Crear un flujo de tokens para el analizador l�xico
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Crear un analizador sint�ctico
        PlSqlParser parser = new PlSqlParser(tokens);

        // Iniciar el an�lisis sint�ctico desde la regla inicial
        ParseTree tree = parser.sql_statement();

        // Crear un escritor de archivos para la primera salida
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(outputFilePath));

        // Recorrer el �rbol de an�lisis sint�ctico y escribir los tokens, sus tipos y c�digos
        writer1.write("Token | Tipo | C�digo\n");
        traverseTree(tree, lexer, parser, writer1);

        // Cerrar el escritor de archivos para la primera salida
        writer1.close();

        System.out.println("An�lisis sint�ctico completado. Resultados guardados en " + outputFilePath);

        // Generar la segunda salida
        generateTokenTypeCountOutput(lexer, tokens, outputFilePath);
    }

    // M�todo para recorrer el �rbol de an�lisis sint�ctico y escribir los tokens, sus tipos y c�digos
    private static void traverseTree(ParseTree tree, PlSqlLexer lexer, PlSqlParser parser, BufferedWriter writer) throws IOException {
        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            if (child instanceof TerminalNode) {
                Token token = ((TerminalNode) child).getSymbol();
                int tokenType = token.getType();
                String tokenName = lexer.getVocabulary().getSymbolicName(tokenType);
                String tokenText = token.getText();
                String tokenCode = tokenType + "=" + lexer.getVocabulary().getLiteralName(tokenType);

                writer.write(tokenText + " | " + tokenName + " | " + tokenCode + "\n");
            } else {
                traverseTree(child, lexer, parser, writer);
            }
        }
    }

    // M�todo para generar la segunda salida que muestra el tipo de cada token y cu�ntas veces se repiti�
    private static void generateTokenTypeCountOutput(PlSqlLexer lexer, CommonTokenStream tokens, String outputFilePath) throws IOException {
        // Obtener todos los tokens del flujo de tokens
        Map<String, Integer> tokenTypeCountMap = new HashMap<>();
        for (Token token : tokens.getTokens()) {
            String tokenName = lexer.getVocabulary().getSymbolicName(token.getType());
            tokenTypeCountMap.put(tokenName, tokenTypeCountMap.getOrDefault(tokenName, 0) + 1);
        }

        // Escribir los resultados en el archivo de salida
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(outputFilePath, true));
        writer2.write("\n\nTipos de tokens y su frecuencia de aparici�n:\n");
        for (Map.Entry<String, Integer> entry : tokenTypeCountMap.entrySet()) {
            String tokenName = entry.getKey();
            int count = entry.getValue();
            writer2.write(tokenName + " | " + count + "\n");
        }
        writer2.close();

        System.out.println("Segunda salida generada con �xito en " + outputFilePath);
    }
}
