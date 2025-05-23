package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ViaCEP {

public static final int TIMEOUT = 300;

/**
 *
 * @param CEP
 *
 * @author Reinaldo Dourado Santos
 * @since 21/05/2025, 16:13:43
 *
 */
public static Var BuscarCep(@ParamMetaData(description = "CEP", id = "5285e5b6") @RequestBody(required = false) Var CEP) throws Exception {
 return new Callable<Var>() {

   private Var JSONCEP = Var.VAR_NULL;
   private Var Endereco = Var.VAR_NULL;

   public Var call() throws Exception {
    JSONCEP =
    cronapi.json.Operations.toJson(
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/x-www-form-urlencoded"),
    Var.valueOf(
    Var.valueOf("https://viacep.com.br/ws/").getObjectAsString() +
    CEP.getObjectAsString() +
    Var.valueOf("/json/").getObjectAsString()), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("BODY")));
    Endereco =
    Var.valueOf(
    cronapi.json.Operations.getJsonOrMapField(JSONCEP,
    Var.valueOf("logradouro")).getObjectAsString() +
    Var.valueOf(", Bairro: ").getObjectAsString() +
    cronapi.json.Operations.getJsonOrMapField(JSONCEP,
    Var.valueOf("bairro")).getObjectAsString());
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.Endereco"), Endereco);
    return Endereco;
   }
 }.call();
}

}

