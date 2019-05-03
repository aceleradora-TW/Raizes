import { getDevs } from '../services/dev.service';
import Notification from '../components/notification';
import constants from '../utils/constants';

export default class DevForm {
  constructor() {
    this.Notification = new Notification();
    this.selectedMembers = [];
    this.listMembers = [];

    const data = getDevs()
    .then(response => response.data)
    .then(devs => {
      this.listMembers = devs
      this.makeMembersOptions(this.listMembers);
    })
  }

  getMemberSelector() {
    return document.getElementById('dev-name');
  }
  getNewMemberItem(name, id) {
    const icon = document.createElement('i');
    icon.classList.add('fas', 'fa-book');
    icon.setAttribute('aria-hidden', true);

    const span = document.createElement('span');
    span.classList.add('panel-icon');

    const member = document.createElement('a');
    member.classList.add('panel-block', 'animated', 'fadeIn');
    member.setAttribute('id', 'member');
    member.setAttribute('data-id', id);

    span.appendChild(icon);
    member.appendChild(span);
    member.appendChild(document.createTextNode(name));
    member.addEventListener('click', e => this.removeMember(e));
    return member;
  }

  submit(Form) {
    const selector = this.getMemberSelector();
    const member = selector ? selector.value || null : null;
    
    if (member)
      this.setMemberToLsit(member);
    return false;
  }
  setMemberToLsit(memberId) {
    const dev = this.listMembers.find(k => k.id === +memberId) || null;
    const alreadySelected = this.selectedMembers.find(k => k.id === +memberId);
    if(alreadySelected) {
      this.Notification.show(constants.NOTIFICATIONS_TYPE.DAGER, constants.MESSAGES.USER_ALREADY_SELECTED);
    }
    if (!alreadySelected && !!dev) {
      this.selectedMembers.push(dev);
      this.showList(this.selectedMembers);

    }
  }
  showList(items) {
    if (!items) return;
    const list = document.getElementById('members');
    this.removeAllMembers(list)
    items.forEach(element => {
      const item = this.getNewMemberItem(`${element.nome} ${element.sobrenome}`, element.id);
      list.appendChild(item);
    });
  }
  removeAllMembers(list) {
    list.innerHTML = ""
  }
  makeMembersOptions(list) {
    const select = this.getMemberSelector()
    if(!select) return;
    
    list.forEach((element) => {
      const option = document.createElement('option')
      option.setAttribute("value", element.id);
      option.appendChild(document.createTextNode(`${element.nome} ${element.sobrenome}`))
      select.appendChild(option)
    });
  }
  removeMember(e) {
    const element = e.target;
    const id = element.getAttribute('data-id');
    this.selectedMembers = this.selectedMembers.filter(k => k.id != +id);
    element.parentNode.removeChild(element);
    this.Notification.show(constants.NOTIFICATIONS_TYPE.INFO, constants.MESSAGES.USER__REMOVED);
  }
}