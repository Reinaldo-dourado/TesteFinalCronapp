package blockly;

import cronapi.CronapiMetaData;
import cronapi.Utils;
import cronapi.Var;
import cronapi.CronapiMetaData.CategoryType;
import cronapi.CronapiMetaData.ObjectType;	
import cronapi.ParamMetaData;
import cronapi.rest.security.CronappSecurity;


/**
 * @author Reinaldo Dourado Santos
 * @version 1.0
 * @since 2025-05-16
 *
 */
 
@CronappSecurity
@cronapi.CronapiMetaData(type = "blockly", categoryName = "MeusBlocosDiana")
public class SomaDeDoisNumeros {

    /**
     * Retorna a soma de dois números inteiros.
     * 
     * @param numero1 o primeiro número
     * @param numero2 o segundo número
     * @return a soma dos dois números
     */
    @cronapi.CronapiMetaData(
        type = "function",
        name = "somarDoisNumeros",
        nameTags = {"soma", "numeros", "inteiros", "matematica", "calculadora"},
        description = "Retorna a soma de dois números inteiros."
    )
    public static int somarDoisNumeros(int numero1, int numero2) throws Exception {
        // Soma os dois números
        var soma = numero1 + numero2;
        // Retorna a soma
        return soma;
    }
}


