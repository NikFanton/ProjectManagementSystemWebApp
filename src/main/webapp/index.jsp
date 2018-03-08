<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <base href="/ProjectManagementSystemWebApp/">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>PMG</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Roboto');

        .navbar{
            display: flex;
            justify-content: space-around;
        }
        .list_ref{
            display: inline-block;
            width: 500px;
        }

        header{
            height: 200px;
            background: #007bff6b;
            color: #fff;
            /*text-transform: uppercase;*/
            text-align: center;
            padding: 65px;
            margin-bottom: 50px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Project Management System</h1>
        <h6>web-application</h6>
    </header>

    <div class="navbar">
        <div class="list_ref">
            <div class="list-group">
                <button type="button" class="list-group-item list-group-item-action active text-center">
                    <b>VIEW ALL</b>
                </button>
                <button type="button" class="list-group-item list-group-item-action" href="allProjects">
                    <a href="all-projects">View all projects</a>
                </button>
                <button type="button" class="list-group-item list-group-item-action">
                    <a href="all-developers">View all developers</a>
                </button>
                <button type="button" class="list-group-item list-group-item-action">
                    <a href="all-skills">View all skills</a>
                </button>
            </div>
        </div>

        <div class="list_ref">
            <div class="list-group">
                <button type="button" class="list-group-item list-group-item-action active text-center">
                    <b>ADD</b>
                </button>
                <button type="button" class="list-group-item list-group-item-action">
                    <a href="add-project">Add project</a>
                </button>
                <button type="button" class="list-group-item list-group-item-action">
                    <a href="add-dev">Add developer</a>
                </button>
                <button type="button" class="list-group-item list-group-item-action">
                    <a href="add-skill">Add skill</a>
                </button>
            </div>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
