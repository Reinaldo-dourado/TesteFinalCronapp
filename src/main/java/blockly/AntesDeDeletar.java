package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AntesDeDeletar {

public static final int TIMEOUT = 300;

/**
 *
 * @param Consulta a Entidades<app.entity.Saida>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 15:44:36
 *
 */
public static Var AntesDeDeletarAtualizar(@ParamMetaData(description = "Consulta_a_Entidades", id = "84577a39") @RequestBody(required = false) Var Consulta_a_Entidades) throws Exception {
 return new Callable<Var>() {

   private Var ProdutoAtual = Var.VAR_NULL;
   private Var NovaEstoqueProduto = Var.VAR_NULL;

   public Var call() throws Exception {
    ProdutoAtual =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Produto"),Var.valueOf("select \n	p \nfrom \n	Produto p  \nwhere \n	p = :p"),Var.valueOf("p",
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("fk_produto"))));
    NovaEstoqueProduto =
    cronapi.math.Operations.subtract(
    cronapi.database.Operations.getField(ProdutoAtual,
    Var.valueOf("this[0].estoque")),
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("qtdSaida")));
    cronapi.database.Operations.updateField(ProdutoAtual,
    Var.valueOf("estoque"), NovaEstoqueProduto);
    return Var.VAR_NULL;
   }
 }.call();
}

}

