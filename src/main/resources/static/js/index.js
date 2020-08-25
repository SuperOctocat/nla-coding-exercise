Vue.component('users-table-component', {
    props: [ 'users' ],
    template:   `<div id="user-table-div">
                    <table class="table table-striped" id="users-table">
                        <thead>
                        <tr>
                            <th>Id:</th>
                            <th>First Name:</th>
                            <th>Last Name:</th>
                            <th>Phone Number:</th>
                            <th>Email Address</th>
                            <th>Borrowed Books:</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr v-for="user in users" :key="user.id">
                            <td class="text-left" id="user-id">{{user.id}}</td>
                            <td class="text-left">{{user.firstName}}</td>
                            <td class="text-left">{{user.lastName}}</td>
                            <td class="text-left">{{user.phoneNumber}}</td>
                            <td class="text-left">{{user.emailAddress}}</td>
                            <td class="text-left" onclick="functionRowClicked(this)"><button type="button"  class="btn btn-primary btn-md" name="btn-check-books" id="btn-check-books">Check Books</button></td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="well"><h3>Borrowed books:</h3>
                        <p id="borrowed-books"></p>
                    </div>
                </div>`
});



Vue.component('books-table-component',{
    props: [ 'books' ],
    template: `<div id="book-table-div">
                    <table class="table table-striped" id="books-table">
                        <thead>
                        <tr>
                            <th>Id:</th>
                            <th>Title:</th>
                            <th>Author:</th>
                            <th>ISBN:</th>
                            <th>Availability:</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr v-for="book in books" :key="book.id">
                            <td class="text-left" id="book-id">{{book.id}}</td>
                            <td class="text-left">{{book.title}}</td>
                            <td class="text-left">{{book.author}}</td>
                            <td class="text-left">{{book.isbn}}</td>
                            <td class="text-left">{{book.status}}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>`
});



Vue.component ('header-component', {
    template: `<div id="header">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/home">NLA</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/home">Home</a></li>
                        <li><a href="#">Collections</a></li>
                        <li><a href="#">Using the Library</a></li>
                        <li><a href="#">What's On</a></li>
                        <li><a href="#">Visit</a></li>
                        <li><a href="#">About us</a></li>
                        <li><a href="#">Support us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        </div>
    `
});



Vue.component ('footer-component', {
    template: `<div id="footer">
                    <footer class="blue p-sm-5">
                        <nav class="navbar navbar-inverse">
                            <div class="container-fluid">
                                <div class="navbar-header">
                                    <p class="navbar-brand">Feedback</p>
                                </div>
                                <div class="collapse navbar-collapse" id="footerNavbar">
                                    <ul class="nav navbar-nav">
                                        <li><a href="#">Facebook</a></li>
                                        <li><a href="#">Twitter</a></li>
                                        <li><a href="#">Instagram</a></li>
                                        <li><a href="#">Flickr</a></li>
                                        <li><a href="#">YouTube</a></li>
                                    </ul>
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Contact Us</a></li>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </footer>
                </div>`
});








// Main Vue instance
var app = new Vue ({
    el: '#app',
    data () {
        return {
            message: 'Welcome to NLA',
            instructions: 'See our library friends and search our available books by clicking the buttons below.',
            users: null,
            hasUsers: 0,
            books: null,
            hasBooks: 0,
            borrowedBooks: null,
            hasBorrowedBooks: 0
        }
    },
    methods: {
        showUsersTable: function (event) {
                this.hasBooks = 0,
                axios
                    .get('/showUsers')
                    .then(response => (this.users = response.data, this.hasUsers = response.data.length))

        },
        showBooksTable: function (event) {
                this.hasUsers = 0,
                axios
                    .get('/showBooks')
                    .then(response => (this.books = response.data, this.hasBooks = response.data.length))

        }
    }
});