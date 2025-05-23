window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Blocosomanumeros = window.blockly.js.blockly.Blocosomanumeros || {};

/**
 * @function somanumeros
 *
 *
 *
 *
 * @author Reinaldo Dourado Santos
 * @since 21/05/2025, 15:55:36
 *
 */
window.blockly.js.blockly.Blocosomanumeros.somanumerosArgs = [];
window.blockly.js.blockly.Blocosomanumeros.somanumeros = async function() {
 var item, Resultado;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.BlocoHighCodeTeste:ExecutarSoma', async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.notify('success',String('A soma dos dois números é: ') + String(item));
    //
    this.cronapi.screen.changeValueOfField("vars.Resultado", item);
    //
    Resultado = item;
    //
    this.cronapi.notification.customNotify('info', String('A soma dos dois números é: ') + String(Resultado), 'fade', 'top', 'left', 'true');
  }.bind(this), this.cronapi.screen.getValueOfField("vars.numero1"), this.cronapi.screen.getValueOfField("vars.numero2"));
}
