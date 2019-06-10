export default class Modal {
  constructor(selector = '#Modal') {
    this.elem = document.querySelector(selector)
    this.elemTituloModal = $(this.elem).find('.modal-card-title');
    this.okButton = $(this.elem).find('#okButton');
    this.cancelButton = $(this.elem).find('#cancelButton');

    this.init()
  }

  show(textoDoCorpo) {
    const corpoModal = $(this.elem).find('.modal-card-body span');
    corpoModal.text(textoDoCorpo);
    this.elem.classList.add('is-active')
    return false;
  }

  warning(){
    this.elemTituloModal.text("Atenção!")
    return this;
  }
  success(){
    this.elemTituloModal.text("Sucesso!")
    return this;
  }


  close() {
    this.elem.classList.remove('is-active')
  }

  okAction(text, callback) {
    this.okButton.show();
    this.doAction(this.okButton, text, callback)
    return this;
  }
  
  cancelAction(text, callback) {
    this.cancelButton.show();
    this.doAction(this.cancelButton, text, callback)
    return this;
  }

  doAction(el, text, callback) {
    el.text(text);
    el.on('click', () => {
      
      if(callback){callback()};
      this.close();
    });
  }


  init() {
    var modalClose = $(this.elem).find('.is-modal-close')
    var that = this;
    modalClose.each(function (i, e) {
            
      $(e).on("click", function () {
        that.close();
      })
    })
  }

  addEventListener(event, callback) {
    this.elem.addEventListener(event, callback)
  }
}