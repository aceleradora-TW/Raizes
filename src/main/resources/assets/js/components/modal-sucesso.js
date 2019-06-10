export default class ModalSucesso {
    constructor(selector = '#ModalSucesso') {
        this.elem = document.querySelector(selector)
        this.elemTituloModal = $(this.elem).find('.modal-card-title');
        this.init()
    } 
  
    show(textoDoCorpo) {
      const corpoModal = $(this.elem).find('.modal-card-body span');
      corpoModal.text(textoDoCorpo);
      this.elem.classList.toggle('is-active')
      this.on_show()
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
      this.elem.classList.toggle('is-active')
      this.on_close()
    }
  
    init() {
      var modalClose = $(this.elem).find('.is-modal-close')
      var that = this;
      modalClose.each(function (i,e) {
  
         $(e).on("click", function () {
          that.close();
          var event = new Event('modal:close')
          that.elem.dispatchEvent(event);
        })
      })
    }
  
     on_show() {
      var event = new Event('modal:show')
      this.elem.dispatchEvent(event);
    }
  
     on_close() {
      var event = new Event('modal:close')
      this.elem.dispatchEvent(event);
    }
  
     addEventListener(event, callback) {
      this.elem.addEventListener(event, callback)
    }
  }