package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ValidarEntrada {

public static final int TIMEOUT = 300;

/**
 *
 * @param Consulta a Entidades<app.entity.Entrada>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 13:59:20
 *
 */
public static Var Executar(@ParamMetaData(description = "Consulta_a_Entidades", id = "fd9e6e55") @RequestBody(required = false) Var Consulta_a_Entidades) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    if (
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("qtdEntrada")).compareTo(
    Var.valueOf(1)) <= 0).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("A quantidade da entrada deverá ser um número maior que zero."));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

