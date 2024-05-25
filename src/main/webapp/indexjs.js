// nav bar
const stickyNavbar = document.getElementById("navbar");

document.addEventListener("scroll", () => {
  if (window.scrollY > 50) {
    stickyNavbar.classList.add("scrolling");
  } else {
    stickyNavbar.classList.remove("scrolling");
  }
});

// slide
var swiper = new Swiper(".mySwiper", {
  slidesPerView: 1,
  //   spaceBetween: 30,
  speed: 3000,
  loop: true,
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  autoplay: {
    delay: 2000,
    // katkml animation mnb3d makat7rk
    disableOnInteraction: false,
  },
});
