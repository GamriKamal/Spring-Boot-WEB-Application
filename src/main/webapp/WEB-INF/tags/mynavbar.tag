<%@ tag %>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background: #16354d" >
    <div class="container-fluid">
        <a class="navbar-brand" href="/welcomePage">TMDBA</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Movie Lists
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/movieLists/popularMovieList">Popular Movies</a></li>
                        <li><a class="dropdown-item" href="/movieLists/nowPlaying">Now Playing</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/movieLists/upcoming">Upcoming</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        TV Lists
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/TVLists/onTheAir">On The Air</a></li>
                        <li><a class="dropdown-item" href="/TVLists/popular">Popular</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/TVLists/topRated">Top Rated</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="search-box">
            <form class="d-flex" role="search" method="get" action="/welcomePage/search">
                <input class="form-control me-2" type="search" name="search-input" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
        <div class="user-account">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fa-regular fa-user"></i>                        </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/account">My Account</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="/account/favouriteMovie">My Favourite Movies</a></li>
                    <li><a class="dropdown-item" href="/account/watchListMovie">My Movies Watchlist</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="/account/favouriteTV">My Favourite TV</a></li>
                    <li><a class="dropdown-item" href="/account/watchListTV">My TV Watchlist</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li> <a href="/logout"><button class="buttonLogout">Logout</button></a></li>
                </ul>
            </li>
        </div>
    </div>
</nav>
