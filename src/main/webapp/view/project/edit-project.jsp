<%@ page import="com.company.model.entities.Developer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Edit project</title>
    <style>
        .content {
            width: 40%;
            margin: 0 auto;
        }
        .content h2{
            /*text-align: center;*/
            margin: 30px 0 15px 0;
        }
    </style>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/edit-project?projectId=${project.id}">
        <div class="container">
            <div class="content">
                <h2>Edit project</h2>
                <form>
                    <div class="form-group">
                        <label>Project name</label>
                        <input type="text" class="form-control" placeholder="Enter project name" name="projectName"
                        <c:out value="${project.projectName}"/>
                    </div>
                    <div class="form-group">
                        <label>Cost</label>
                        <input type="text" class="form-control" placeholder="Enter cost" name="cost"
                        <c:out value="${project.cost}"/>
                    </div>
                    <div class="form-group">
                        <label>Cost</label>
                        <input type="text" class="form-control" placeholder="Enter customer name" name="customerName"
                        <c:out value="${project.customer.customerName}"/>
                    </div>
                    <div class="form-group">
                        <label>Cost</label>
                        <input type="text" class="form-control" placeholder="Enter company name" name="=companyName"
                        <c:out value="${project.company.companyName}"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </form>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>