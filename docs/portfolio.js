        // Toggle navbar for mobile view
        var navbarToggleBtn = document.getElementById('navbar-toggle');
        var navbarDefault = document.getElementById('navbar-default');
        var navbarMenu = document.getElementById('navbar-menu');

        navbarToggleBtn.addEventListener('click', function () {
            navbarDefault.classList.toggle('hidden');
        });

        // Hide navbar after clicking a menu link on mobile view
        navbarMenu.querySelectorAll('a').forEach(link => {
            link.addEventListener('click', function () {
                navbarDefault.classList.add('hidden');
            });
        });



        document.addEventListener('DOMContentLoaded', () => {
            const sections = document.querySelectorAll('.fade-in-zoom-in');
        
            const observerOptions = {
                root: null,
                rootMargin: '0px',
                threshold: 0.1 // Trigger animation when 10% of the section is visible
            };
        
            const observer = new IntersectionObserver((entries, observer) => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.classList.add('visible');
                        observer.unobserve(entry.target); // Stop observing once animated
                    }
                });
            }, observerOptions);
        
            sections.forEach(section => {
                observer.observe(section);
            });
        });



        document.addEventListener('DOMContentLoaded', function () {
            const slider = document.getElementById('slider');
            const prevButton = document.getElementById('prev');
            const nextButton = document.getElementById('next');
            
            let currentIndex = 0;
        
            function showSlide(index) {
                const slideWidth = slider.clientWidth;
                slider.style.transform = `translateX(${-slideWidth * index}px)`;
            }
        
            nextButton.addEventListener('click', () => {
                if (currentIndex < slider.children.length - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }
                showSlide(currentIndex);
            });
        
            prevButton.addEventListener('click', () => {
                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = slider.children.length - 1;
                }
                showSlide(currentIndex);
            });
        });


        // Smooth Scroll Offset for Navbar
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();

                const targetId = this.getAttribute('href').substring(1);
                const targetElement = document.getElementById(targetId);

                window.scrollTo({
                    top: targetElement.offsetTop - 80, // Adjust based on your navbar height
                    behavior: 'smooth'
                });
            });
        });


