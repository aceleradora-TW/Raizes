
const setCloseListener =  (element, fn) => {
  if(!element) return;
    
  const $notification = element.parentNode;
  element.addEventListener('click', () => fn.bind(fn()))
};

const getNotificationElement = () => document.querySelector('.notification .delete');

export default class Notification {
  constructor() {
    this.$notification = getNotificationElement().parentNode;

    document.addEventListener('DOMContentLoaded', () => {
      const closeButton = getNotificationElement();
      const notification = closeButton || null;
      setCloseListener(notification, () => { this.hide() });
    });
  }

  show(type, message,  timeout = 6000) {
    this.resetClass();
    this.addClass(`is-${type || 'info'}`);
    this.setContent(message);
    this.addClass('active');
    setTimeout(() => {
      this.hide();
    }, timeout);
  }

  hide() {
    this.$notification.classList.remove('active');
  }
  resetClass() {
    this.$notification.classList.remove(...this.$notification.classList);
    this.addClass('notification');
  }
  addClass(elementClass, element = this.$notification) {
    element.classList.add(elementClass);
  }
  setContent(message) {
    const body = this.$notification.querySelector('.body');
    body.innerText = message;
  }
}