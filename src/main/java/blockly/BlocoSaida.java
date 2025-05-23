package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BlocoSaida {

public static final int TIMEOUT = 300;

/**
 *
 * @param Consulta a Entidades<app.entity.Saida>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 15:27:05
 *
 */
public static void AntesdeInserirValidaQtd(@ParamMetaData(description = "Consulta_a_Entidades", id = "86cdecff") @RequestBody(required = false) Var Consulta_a_Entidades) throws Exception {
  new Callable<Var>() {

   private Var BuscarEstoque = Var.VAR_NULL;
   private Var novaQtdProdutos = Var.VAR_NULL;

   public Var call() throws Exception {
    BuscarEstoque =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Produto"),Var.valueOf("select \n	p \nfrom \n	Produto p  \nwhere \n	p = :p"),Var.valueOf("p",
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("fk_produto"))));
    if (
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("qtdSaida")).compareTo(
    Var.valueOf(1)) < 0).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Total da saída não pode ser um valor menor que 1."));
    }
    if (
    Var.valueOf(
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("qtdSaida")).compareTo(
    cronapi.database.Operations.getField(BuscarEstoque,
    Var.valueOf("this[0].estoque"))) > 0).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Total da saída maior que o estoque existente."));
    }
    novaQtdProdutos =
    cronapi.math.Operations.subtract(
    cronapi.database.Operations.getField(BuscarEstoque,
    Var.valueOf("this[0].estoque")),
    cronapi.object.Operations.getObjectField(Consulta_a_Entidades,
    Var.valueOf("qtdSaida")));
    cronapi.database.Operations.updateField(BuscarEstoque,
    Var.valueOf("estoque"), novaQtdProdutos);
   return Var.VAR_NULL;
   }
 }.call();
}

}

