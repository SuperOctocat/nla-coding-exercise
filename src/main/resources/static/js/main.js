$(document).ready(function () {

    // Ajax query to database to get all books borrowed by a user
    window.functionRowClicked = function (argThis) {
        let $item = argThis.parentNode.rowIndex;
        $.ajax({
            type: "POST",
            url: "/showBooks/" + $item,
            data: {
                id: $item
            },
            success: function(response) {
                getAllBooks(response);
            },
            error: function(response) {
                alert('Error:  Sorry, did not get any response.');
            }
        });
    }

    // Display all books borrowed by a user
    function getAllBooks(response) {
        let borrowedBooksInner = "";
        if (response.length > 0) {
            borrowedBooksInner += "<table class=\"table\" id=\"book-borrowed-by-user\">\n" +
                "                    <thead>\n" +
                "                    <tr>\n" +
                "                        <th>Title:</th>\n" +
                "                        <th>Author:</th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>\n";
            response.forEach(book => borrowedBooksInner += "<tr><td class=\"text-left\">" + book.title + "</td><td class=\"text-left\">" + book.author + "</td></tr>");
            borrowedBooksInner += "</tbody></</table>";
        } else {
            borrowedBooksInner += "No books lent to this member";
        }
        document.getElementById("borrowed-books").innerHTML = borrowedBooksInner;
    }

});





