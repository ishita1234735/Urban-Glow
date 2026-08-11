# Urban-Glow
A Spring Boot–based web application for managing and browsing salon services — server-rendered views with REST endpoints and static frontend assets. The project provides user, salon-owner, and admin flows (sign-up, login, listing, bookings and management pages) and is implemented with Java (Spring Boot) serving Thymeleaf templates and static HTML/CSS/JS.

Project overview
Urban Glow is a Java (Spring Boot) web application that serves a salon/beauty service platform. It includes server-rendered pages (Thymeleaf templates and static HTML files), REST endpoints used by the frontend, and simple database utilities to read/write data. The repository contains the application entry point, controller classes for user/owner/admin flows, utility classes to execute SQL and convert results to JSON, UI templates, and static frontend assets.

Main features (implemented in this repo)
User sign-up and login (REST endpoints + signup/login pages)
Salon owner sign-up and login (owner pages + REST endpoints)
Admin pages and REST endpoints for managing owners and cities
City, salon and package listing endpoints that return JSON for the frontend
Booking flow: users can create bookings and view booking history
Owner pages to manage bookings, salon photos and service/package details
Static marketing pages (index, about, services, price, gallery, blog, contact, team, testimonials) and CSS/JS assets
Utility to convert RDBMS ResultSets to JSON for API responses
Local database dump folder (Database/dump) intended for schema/data import
Technologies / frameworks used
Language: Java (primary runtime)
Framework: Spring Boot (parent POM and web starter present)
Template engine: Thymeleaf (spring-boot-starter-thymeleaf)
Database driver: MySQL Connector/J
JSON utility: json-simple
Build system: Maven (pom.xml)
Frontend: HTML, SCSS, JavaScript and static asset folders under src/main/resources/static
User roles (based on templates & controllers)
User — browse salons, view packages, sign up, log in, book services, view booking history
Salon Owner — sign up, log in, manage salon photos, services, and bookings
Admin — log in, manage cities and owner approvals (templates and controllers indicate admin management screens)
Main modules / functionality (key packages & files)
src/main/java/com/new_project/demo
UrbanGlowApplication.java — Spring Boot application entry point
src/main/java/com/new_project/demo/controllers
AdminController.java, AdminRestController.java — admin pages and API
SalonOwnerController.java, SalonOwnerRestController.java — owner pages and API
UserController.java, UserRestController.java — user pages and API
UserRestController contains endpoints for signup, login, viewing cities, salons, packages, and bookings
src/main/java/com/new_project/demo/vmm
DBLoader.java — low-level JDBC helper (executes SQL)
RDBMS_TO_JSON.java — converts ResultSet rows into JSON output (used by REST controllers)
src/main/resources/templates — Thymeleaf / HTML templates for admin, owner and user UIs
src/main/resources/static — static frontend assets (HTML, CSS/SCSS, JS, images, upload directories)
Database/dump — location for database dump(s) / import artifacts
Database information
The repository expects a MySQL-compatible database. A Database/dump directory is present (inspect it for SQL schema and seed data).
The project currently uses a simple JDBC helper that opens a direct connection from code. Before running in any shared environment you should:
Inspect Database/dump for schema and import instructions.
Create the application database locally (name and schema can be found in the dump or code).
Avoid leaving credentials hardcoded — use environment variables or a proper Spring datasource configuration.
Important: do not commit any production credentials. Replace any hardcoded connection strings or passwords with externalized configuration.

Payment integration
There is no evidence of payment provider integration (Stripe, PayPal or similar) in this repository. No payment SDKs, payment endpoints or configuration files related to payment were found.
Project structure (annotated)
Code
.gitattributes
.gitignore
pom.xml                          # Maven build file (Spring Boot parent, dependencies)
nb-configuration.xml
nbactions.xml
README.md
Database/
  dump/                           # SQL dump(s) or DB artifacts (inspect to import schema/data)
src/
  main/
    java/
      com/new_project/demo/
        UrbanGlowApplication.java  # Spring Boot entry point
        controllers/               # User, Owner, Admin controllers and REST controllers
        vmm/                       # DBLoader, RDBMS_TO_JSON utilities
    resources/
      application.properties       # Spring/application runtime config (inspect and update)
      static/                      # static HTML/CSS/JS/img assets (public site)
        css/
        scss/
        js/
        img/
        myphotos/                  # uploaded photos
        owner_uploads/
        owner_new_uploads/
      templates/                   # server-side views (Admin/Owner/User pages)
  test/                            # tests (if provided)
How it fits together

The Spring Boot application bootstraps from UrbanGlowApplication.java. Controllers handle incoming HTTP requests; some endpoints return JSON generated by the RDBMS_TO_JSON utility which executes SQL via DBLoader. Templates are used for server-rendered pages and static files are served from the static folder. The build is managed by Maven (pom.xml) and the Spring Boot plugin can run or package the application.
Setup and installation
Prerequisites

Java JDK 17 (project POM sets java.version to 17)
Maven 3.6+
MySQL (or compatible RDBMS) for the application database
Git (to clone the repo)
Clone the repository

Code
git clone https://github.com/ishita1234735/Urban-Glow.git
cd Urban-Glow
Database

Inspect Database/dump/ for SQL schema and seed data. Import the SQL dump into a local database:
Code
mysql -u <db_user> -p <database_name> < Database/dump/<dump-file>.sql
Replace placeholders with your database user/name and the actual dump file name.
If you prefer to create the schema manually, use the SQL files provided in Database/dump (if present).
Configuration

Inspect src/main/resources/application.properties for configurable properties (server port, logging, etc.).
This project contains a low-level JDBC helper that opens connections directly in code. Before running:
Either update DB connection details safely (do not commit secrets), or
Replace DBLoader usage with a proper Spring-managed DataSource and externalize credentials using environment variables or an external properties file.
Example (recommended): configure the datasource in application.properties or via environment variables and remove hardcoded credentials from the Java helper.
Build

Code
mvn clean package
This compiles the code and packages a runnable artifact (the POM uses the Spring Boot Maven plugin).
How to run
Run with Maven (development)

Code
mvn spring-boot:run
This requires that your database is accessible and configured.

Run the packaged jar

Code
java -jar target/demo-0.0.1-SNAPSHOT.jar
Replace the jar name if the built artifact name differs in your environment.

After startup, open the application in your browser at:

http://localhost:8080 (default Spring Boot port unless changed in application.properties)
Notable REST endpoints (implemented in UserRestController)
The following endpoints are provided in UserRestController (useful for the frontend and API testing):

POST /CheckUserSignup — user signup (multipart for user photo)
POST /CheckUserLogin — user login (creates session attributes)
GET /ShowCityData — returns city data as JSON
POST /ViewSalons — list salons for a city (expects city id)
POST /ViewOwnerDetails — owner details by owner id
POST /ViewShopDetails — shop photos by owner id
POST /ViewPackageDetails — packages for owner id
POST /CheckPackageServiceDetails — package details by package id
POST /CheckUserBooking — create a booking (uses session to get user)
POST /CheckUserBookingHistory — returns booking history for signed-in user
For admin and owner-specific REST endpoints, consult AdminRestController.java and SalonOwnerRestController.java.
