# CVBuilder
 CV builder is a web application built using Java and Spring Boot, designed to empower users in creating and managing their professional resumes effortlessly. This RESTful API-driven platform allows users to input their personal and professional details, and generating PDF resumes on-demand. 

Technology stack: Java, Spring, Spring JPA, H2 database, Spring MVC, thymeleaf, itext pdf.

<h3>Working on:</h3>
<b><li>Right now I implement front end side of application so end user will be able to fill forms, and manage his data. </li></b>
<b><li>unit tests.</li></b>
<hr>

<h2>What is working?</h2>
<h3>REST API (localhost:8080/)</h3>
<ul> 
    <h3>CV</h3>
    <li><b>/CV/create</b> - PUT method with request body as json file. Creates CV in database.</li>
    <li><b>/CV/{id}</b> - GET method which returns json file with CV, if CV is not in DataBase method will return Http status NO_CONTENT. </li>
    <hr>
    <h3>Personal information</h3>
    <li><b>/CV/{id}/personal/</b> GET method to return personal json file from given CV id. </li>
    <li><b>/CV/{id}/personal/create</b>POST method which updated personal info from given CV id. </li>
    <li><b>/CV/{id}/personal/update</b> POST method used to update personal information with personalInfo json file in request body.</li>
    <hr>
    <h3>Contact Me</h3>
    <li><b>/CV/{id}/contacme/</b> GET method to return contactMe json file from given CV id. </li>
    <li><b>/CV/{id}/contacme/create</b>POST method which updated contactMe info from given CV id. </li>
    <li><b>/CV/{id}/contacme/update</b> POST method used to update contactMe information with personalInfo json file in request body.</li>
    <hr>
    <h3>Education fields</h3>
    <li><b>/CV/{id}/education/</b> GET all education fields from given CV id. </li>
    <li><b>/CV/{id}/education/{educationId}</b> GET education field from given CV id with education id. </li>
    <li><b>/CV/{id}/education/add</b> POST add education field to CV database. </li>
    <li><b>/CV/{id}/education/{educationId}/update</b> POST update education field to CV database with education as request body. </li>
    <li><b>/CV/{id}/education/{educationId}/delete</b> POST delete education field. </li>
    <hr>
    <h3>experience fields</h3>
    <li>Experience fields endpoints are the same as education fields. </li>
</ul>
