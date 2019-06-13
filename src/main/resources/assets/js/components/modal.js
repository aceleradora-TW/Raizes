export default class Modal {
  constructor(selector = '#Modal') {
    this.elem = $(selector);
    this.elemTitle = this.elem.find('.modal-card-title');
    this.okButton = this.elem.find('#okButton');
    this.cancelButton = this.elem.find('#cancelButton');

    this.init()
  }

  show(bodyText) {
    const body = this.elem.find('.modal-card-body span');
    body.text(bodyText);
    this.elem.addClass('is-active')
    return false;
  }

  warning(){
    this.elemTitle.text("Atenção!")
    return this;
  }
  success(){
    this.elemTitle.text("Sucesso!")
    return this;
  }


  close() {
    this.elem.removeClass('is-active')
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
      
      if(callback) callback();
      this.close();
    });
  }


  init() {
    var modalClose = this.elem.find('.is-modal-close')
    modalClose.each( (i, e) => {     
      $(e).on("click", () => {
        this.close();
      })
    })
  }
}