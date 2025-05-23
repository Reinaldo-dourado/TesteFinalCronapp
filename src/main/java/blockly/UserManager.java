package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UserManager {

public static final int TIMEOUT = 300;

/**
 *
 * UserManager
 *
 * @param Entidade<app.entity.User>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 14:16:34
 *
 */
public static Var BeforeDelete(@ParamMetaData(description = "Entidade", id = "6d0d416f") @RequestBody(required = false) Var Entidade) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.beforeDelete(Entidade);
   }
 }.call();
}

/**
 *
 * UserManager
 *
 * @param Entidade<app.entity.User>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 14:16:34
 *
 */
public static Var BeforeInsert(@ParamMetaData(description = "Entidade", id = "5df10557") @RequestBody(required = false) Var Entidade) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.beforeInsert(Entidade);
   }
 }.call();
}

/**
 *
 * UserManager
 *
 * @param Entidade<app.entity.User>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 14:16:34
 *
 */
public static Var BeforeUpdate(@ParamMetaData(description = "Entidade", id = "8537bddc") @RequestBody(required = false) Var Entidade) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.beforeUpdate(Entidade);
   }
 }.call();
}

/**
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 14:16:34
 *
 */
public static Var BuscaUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var UsuarioLogado = Var.VAR_NULL;
   private Var UserId = Var.VAR_NULL;

   public Var call() throws Exception {
    UsuarioLogado =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));
    UserId =
    cronapi.list.Operations.getFirst(UsuarioLogado);
    return UserId;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param Entidade<app.entity.User>
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 14:16:34
 *
 */
public static Var Normalize(@ParamMetaData(description = "Entidade", id = "83c51450") @RequestBody(required = false) Var Entidade) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.normalize(Entidade);
   }
 }.call();
}

}

