package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BlocoHighCodeTeste {

public static final int TIMEOUT = 300;

/**
 *
 * @param numero1
 * @param numero2
 *
 * @author Reinaldo Dourado Santos
 * @since 21/05/2025, 15:57:32
 *
 */
public static Var ExecutarSoma(@ParamMetaData(description = "numero1", id = "e4e624a8") @RequestBody(required = false) Var numero1, @ParamMetaData(description = "numero2", id = "1fa6c38f") Var numero2) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    Var.valueOf(blockly.SomaDeDoisNumeros.somarDoisNumeros(numero1.getTypedObject(int.class), numero2.getTypedObject(int.class)));
    return item;
   }
 }.call();
}

}

