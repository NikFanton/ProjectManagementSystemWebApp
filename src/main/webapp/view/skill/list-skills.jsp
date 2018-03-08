<%@ page import="com.company.model.entities.Skill" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>List of skills</title>
    <style>
        .container h2 {
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>List of skills</h2>
        <table class="table  table-hover table-sm">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Skill name</th>
                <th scope="col">Level</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Skill> skills = (ArrayList<Skill>) request.getAttribute("skills");
                int i = 1;
                for (Skill skill : skills) {
                    out.println("<tr>");
                    out.println("<th scope=\"row\">" + i + "</th>");
                    out.println("<td>" + skill.getSkillName() + "</td>" +
                                "<td>" + skill.getLevel() + "</td>" +
                                "<td><a href=\"/ProjectManagementSystemWebApp/delete-skill?skillId=" +
                                    skill.getSkillId() + "\">delete</a></td>" +
                                "<td><a href=\"/ProjectManagementSystemWebApp/edit-skill?skillId=" +
                                    skill.getSkillId() + "\">edit</a></td>");
                    out.println("</tr>");
                    i++;
                }
            %>
            </tbody>
        </table>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
