        // On page load or when changing themes
        if (localStorage.getItem('color-theme') === 'dark' || (!('color-theme' in localStorage) && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
            document.documentElement.classList.add('dark');
        } else {
            document.documentElement.classList.remove('dark');
        }

        var themeToggleDarkIcon = document.getElementById('theme-toggle-dark-icon');
        var themeToggleLightIcon = document.getElementById('theme-toggle-light-icon');

        // Change the icons inside the button based on previous settings
        if (localStorage.getItem('color-theme') === 'dark' || (!('color-theme' in localStorage) && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
            themeToggleLightIcon.classList.remove('hidden');
        } else {
            themeToggleDarkIcon.classList.remove('hidden');
        }

        var themeToggleBtn = document.getElementById('theme-toggle');

        themeToggleBtn.addEventListener('click', function () {
            // toggle icons inside button
            themeToggleDarkIcon.classList.toggle('hidden');
            themeToggleLightIcon.classList.toggle('hidden');

            // if set via local storage previously
            if (localStorage.getItem('color-theme')) {
                if (localStorage.getItem('color-theme') === 'light') {
                    document.documentElement.classList.add('dark');
                    localStorage.setItem('color-theme', 'dark');
                } else {
                    document.documentElement.classList.remove('dark');
                    localStorage.setItem('color-theme', 'light');
                }
            } else {
                // if NOT set via local storage previously
                if (document.documentElement.classList.contains('dark')) {
                    document.documentElement.classList.remove('dark');
                    localStorage.setItem('color-theme', 'light');
                } else {
                    document.documentElement.classList.add('dark');
                    localStorage.setItem('color-theme', 'dark');
                }
            }
        });

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