window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Bloco = window.blockly.js.blockly.Bloco || {};

/**
 * @function ExecutarSoma
 *
 *
 *
 * @param numero1
 * @param numero2
 *
 * @author Reinaldo Dourado Santos
 * @since 16/05/2025, 16:41:57
 *
 */
window.blockly.js.blockly.Bloco.ExecutarSomaArgs = [{ description: 'numero1', id: 'e499e9f5' }, { description: 'numero2', id: '4af2e53e' }];
window.blockly.js.blockly.Bloco.ExecutarSoma = async function(numero1, numero2) {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.BlocoHighCodeTeste:ExecutarSoma', async function(sender_item) {
      item = sender_item;
  }.bind(this), numero1, numero2);
  //
  this.cronapi.notification.customNotify('success', item, 'fade', 'top', 'left', 'true');
}
