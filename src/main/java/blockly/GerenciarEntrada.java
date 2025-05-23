package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class GerenciarEntrada {

public static final int TIMEOUT = 300;

/**
 *
 * @param Consulta a Entidades<app.entity.Entrada>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 15:05:44
 *
 */
public static Var depoisDeDeletar(@ParamMetaData(description = "Consulta_a_Entidades", id = "01c7ccdc") @RequestBody(required = false) Var Consulta_a_Entidades) throws Exception {
 return new Callable<Var>() {

   private Var produto = Var.VAR_NULL;
   private Var novaQtdProdutos = Var.VAR_NULL;

   public Var call() throws Exception {
    produto =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Produto"),Var.valueOf("select \n	p \nfrom \n	Produto p  \nwhere \n	p = :p"),Var.valueOf("p",
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("fk_produto"))));
    System.out.println(produto.getObjectAsString());
    System.out.println(
    Var.valueOf("--------------------------------- acima produto").getObjectAsString());
    novaQtdProdutos =
    cronapi.math.Operations.subtract(
    cronapi.database.Operations.getField(produto,
    Var.valueOf("this[0].estoque")),
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("qtdEntrada")));
    System.out.println(novaQtdProdutos.getObjectAsString());
    System.out.println(
    Var.valueOf("--------------------------------- nova qtd dos produtos").getObjectAsString());
    cronapi.database.Operations.updateField(produto,
    Var.valueOf("estoque"), novaQtdProdutos);
    return Var.VAR_NULL;
   }
 }.call();
}

}

