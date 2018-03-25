function add_book() {
    var x = document.getElementById("add_book");
    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
}