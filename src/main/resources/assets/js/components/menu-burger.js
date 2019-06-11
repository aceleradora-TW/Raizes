export default function() {
  $('.navbar-burger').on("click", function() {
    $('#navbar-burger-body, .navbar-burger').toggleClass('is-active');
  });
}
