This application is thought to follow a layered architectured to separate concerns.
io -> service -> repo -> domain

- io handles all input/output with help of menus and consoleIO.
- Service handles use cases, applies validation and business rules.
- Repo manages data persistence(In-memory and later database when I've how they work.)
- Domain define the program entities