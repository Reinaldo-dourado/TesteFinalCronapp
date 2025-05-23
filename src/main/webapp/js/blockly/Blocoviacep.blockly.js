window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Blocoviacep = window.blockly.js.blockly.Blocoviacep || {};

/**
 * @function Executar
 *
 *
 *
 * @param cep
 *
 * @author Reinaldo Dourado Santos
 * @since 21/05/2025, 16:16:23
 *
 */
window.blockly.js.blockly.Blocoviacep.ExecutarArgs = [{ description: 'cep', id: '50bebbcb' }];
window.blockly.js.blockly.Blocoviacep.Executar = async function(cep) {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.ViaCEP:BuscarCep', async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.changeValueOfField("vars.Endereco", item);
  }.bind(this), cep);
  return item;
}
