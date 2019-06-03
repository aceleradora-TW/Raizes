export default burger;

let nav = $(".navbar-burger");
let menu = $(".navbar-menu");
const burger = () => {
    nav.click(function() {
        nav.toggleClass("is-active");
        menu.toggleClass("is-active");
    });  
}