<h1 align="center">Urban Glow</h1>

<p align="center">
  A Spring Boot-based web application for managing and browsing salon services.
</p>

<hr>

<h2>Project Overview</h2>

<p>
Urban Glow is a Java Spring Boot web application that serves as a salon and
beauty service platform. It provides user, salon-owner, and administrator
functionalities including registration, login, salon browsing, bookings,
service management, and administrative management.
</p>

<p>
The application uses server-rendered Thymeleaf templates, REST endpoints,
static HTML/CSS/JavaScript assets, and MySQL database connectivity.
</p>


<h2>Main Features</h2>

<ul>
  <li>User sign-up and login</li>
  <li>Salon owner sign-up and login</li>
  <li>Admin login and management</li>
  <li>City, salon, and package listing</li>
  <li>Salon service and package details</li>
  <li>User booking functionality</li>
  <li>Booking history for users</li>
  <li>Salon owner booking management</li>
  <li>Salon photo management</li>
  <li>Service and package management</li>
  <li>Online payment integration using Razorpay</li>
  <li>Static pages for home, about, services, pricing, gallery, blog,
      contact, team, and testimonials</li>
  <li>Utility for converting database ResultSet data into JSON responses</li>
  <li>Database dump files for schema and initial data</li>
</ul>


<h2>Technologies and Frameworks</h2>

<table>
  <tr>
    <th>Technology</th>
    <th>Usage</th>
  </tr>
  <tr>
    <td>Java</td>
    <td>Primary programming language</td>
  </tr>
  <tr>
    <td>Spring Boot</td>
    <td>Backend framework</td>
  </tr>
  <tr>
    <td>Thymeleaf</td>
    <td>Server-side template engine</td>
  </tr>
  <tr>
    <td>MySQL</td>
    <td>Database</td>
  </tr>
  <tr>
    <td>HTML</td>
    <td>Frontend structure</td>
  </tr>
  <tr>
    <td>CSS / SCSS</td>
    <td>Frontend styling</td>
  </tr>
  <tr>
    <td>JavaScript</td>
    <td>Frontend functionality and REST API interaction</td>
  </tr>
  <tr>
    <td>Maven</td>
    <td>Build and dependency management</td>
  </tr>
  <tr>
    <td>MySQL Connector/J</td>
    <td>Database connectivity</td>
  </tr>
  <tr>
    <td>json-simple</td>
    <td>JSON processing</td>
  </tr>
  <tr>
    <td>Razorpay</td>
    <td>Online payment integration</td>
  </tr>
</table>


<h2>User Roles</h2>

<h3>User</h3>

<ul>
  <li>Browse available salons</li>
  <li>View salon packages and services</li>
  <li>Sign up and log in</li>
  <li>Book salon services</li>
  <li>View booking history</li>
</ul>

<h3>Salon Owner</h3>

<ul>
  <li>Sign up and log in</li>
  <li>Manage salon photos</li>
  <li>Manage services and packages</li>
  <li>Manage bookings</li>
</ul>

<h3>Admin</h3>

<ul>
  <li>Log in</li>
  <li>Manage cities</li>
  <li>Manage salon owners</li>
  <li>Manage owner approvals</li>
</ul>


<h2>Main Modules and Functionality</h2>

<h3>Application Entry Point</h3>

<p>
<code>src/main/java/com/new_project/demo/UrbanGlowApplication.java</code>
</p>

<p>
This class serves as the Spring Boot application entry point.
</p>

<h3>Controllers</h3>

<ul>
  <li><code>AdminController.java</code> — Admin pages</li>
  <li><code>AdminRestController.java</code> — Admin REST endpoints</li>
  <li><code>SalonOwnerController.java</code> — Salon owner pages</li>
  <li><code>SalonOwnerRestController.java</code> — Salon owner REST endpoints</li>
  <li><code>UserController.java</code> — User pages</li>
  <li><code>UserRestController.java</code> — User REST endpoints</li>
</ul>

<h3>Database Utilities</h3>

<ul>
  <li>
    <code>DBLoader.java</code> — Executes SQL queries and handles database
    connectivity.
  </li>
  <li>
    <code>RDBMS_TO_JSON.java</code> — Converts database ResultSet data into
    JSON responses.
  </li>
</ul>


<h2>Project Structure</h2>

<pre>
Urban-Glow/
|
|-- Database/
|   |-- dump/
|
|-- src/
|   |-- main/
|       |-- java/
|       |   |-- com/new_project/demo/
|       |       |-- UrbanGlowApplication.java
|       |       |-- controllers/
|       |       |-- vmm/
|       |
|       |-- resources/
|           |-- static/
|           |   |-- css/
|           |   |-- scss/
|           |   |-- js/
|           |   |-- img/
|           |   |-- myphotos/
|           |   |-- owner_uploads/
|           |   |-- owner_new_uploads/
|           |
|           |-- templates/
|
|-- pom.xml
|-- .gitignore
|-- .gitattributes
|-- README.md
</pre>


<h2>Database Information</h2>

<p>
The application uses a MySQL-compatible database. The repository contains
database-related files inside the <code>Database/dump</code> directory.
</p>

<p>
Before running the application:
</p>

<ol>
  <li>Inspect the <code>Database/dump</code> directory.</li>
  <li>Create the required database.</li>
  <li>Import the required SQL dump.</li>
  <li>Configure the database connection.</li>
</ol>

<p>
Database passwords and other sensitive credentials should not be committed
to the repository.
</p>


<h2>Payment Integration</h2>

<p>
Urban Glow includes Razorpay integration for online payments.
The project uses a Razorpay test key for development and testing.
</p>

<p>
Sensitive payment credentials, such as the Razorpay secret key, should never
be committed to GitHub.
</p>


<h2>How the Application Works</h2>

<p>
The Spring Boot application starts through
<code>UrbanGlowApplication.java</code>.
Controllers handle incoming requests and communicate with the database
through the application's database utility classes.
</p>

<p>
REST endpoints provide data to the frontend, while Thymeleaf templates are
used for server-rendered pages. Static HTML, CSS, JavaScript, images, and
other frontend assets are served from the static resources directory.
</p>

<p>
The project uses Maven for dependency management, compilation, and packaging.
</p>


<h2>Setup and Installation</h2>

<h3>Prerequisites</h3>

<ul>
  <li>Java JDK</li>
  <li>Maven</li>
  <li>MySQL</li>
  <li>Git</li>
</ul>


<h3>Clone the Repository</h3>

<pre><code>git clone https://github.com/ishita1234735/Urban-Glow.git
cd Urban-Glow</code></pre>


<h3>Database Setup</h3>

<p>
Inspect the <code>Database/dump/</code> directory for the available SQL
schema and data files.
</p>

<p>A typical MySQL import command is:</p>

<pre><code>mysql -u &lt;db_user&gt; -p &lt;database_name&gt; &lt; Database/dump/&lt;dump-file&gt;.sql</code></pre>

<p>
Replace the placeholders with your own database username, database name,
and SQL file name.
</p>


<h3>Configuration</h3>

<p>
Check the application configuration inside:
</p>

<pre><code>src/main/resources/application.properties</code></pre>

<p>
Configure the required database and application settings before running
the project.
</p>

<p>
Sensitive information such as database passwords, API secrets, and payment
provider secret keys should be stored outside the repository using
environment variables or other secure configuration methods.
</p>


<h2>Build the Application</h2>

<pre><code>mvn clean package</code></pre>

<p>
This compiles the application and creates the packaged application artifact.
</p>


<h2>Run the Application</h2>

<h3>Using Maven</h3>

<pre><code>mvn spring-boot:run</code></pre>

<h3>Using the Packaged JAR</h3>

<pre><code>java -jar target/demo-0.0.1-SNAPSHOT.jar</code></pre>

<p>
The generated JAR name may differ depending on the project configuration.
</p>

<p>
After starting the application, open:
</p>

<pre><code>http://localhost:8080</code></pre>


<h2>REST API Endpoints</h2>

<table>
  <tr>
    <th>Method</th>
    <th>Endpoint</th>
    <th>Purpose</th>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/CheckUserSignup</code></td>
    <td>User registration</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/CheckUserLogin</code></td>
    <td>User login</td>
  </tr>
  <tr>
    <td>GET</td>
    <td><code>/ShowCityData</code></td>
    <td>Returns city data</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/ViewSalons</code></td>
    <td>Lists salons for a city</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/ViewOwnerDetails</code></td>
    <td>Returns salon owner details</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/ViewShopDetails</code></td>
    <td>Returns salon/shop photos</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/ViewPackageDetails</code></td>
    <td>Returns package information</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/CheckPackageServiceDetails</code></td>
    <td>Returns package/service details</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/CheckUserBooking</code></td>
    <td>Creates a booking</td>
  </tr>
  <tr>
    <td>POST</td>
    <td><code>/CheckUserBookingHistory</code></td>
    <td>Returns user booking history</td>
  </tr>
</table>

<p>
Additional administrator and salon-owner REST endpoints are available in
<code>AdminRestController.java</code> and
<code>SalonOwnerRestController.java</code>.
</p>



<p>
<strong>Ishita Arora</strong>
</p>

<hr>

<p align="center">
  Urban Glow — Salon Management and Booking System
</p>
