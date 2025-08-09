
# 📝 SimpleBlog

A **simple personal blog** application built with **Spring Boot**, **Thymeleaf**, and **MySQL**.  
Perfect for learning how to create login/logout and post features in a web app!

---

## 🚀 Features

- 🔐 User Registration & Login  
- 📝 Create and Publish Blog Posts  
- 📖 View All Posts on Homepage  
- 🔒 Logout to end your session  
- 💻 Responsive and clean UI with Bootstrap  

---

## 🛠️ How to Run

1. **Create MySQL Database**  
   Open your MySQL terminal and run:  
   CREATE DATABASE simple_blog_db;

2. **Configure Database Credentials**
   Open `src/main/resources/application.properties` and update:

   properties
   spring.datasource.username=root
   spring.datasource.password=YOUR_PASSWORD_HERE
  

3. **Run the Project**
   Using terminal:

bash
   mvn spring-boot:run


   Or run `SimpleBlogApplication` from your IDE.

4. **Open in Browser**
   Go to [http://localhost:8080] and start using your blog!



## 🎯 What You Can Do

* 👤 Register a new user account
* 🔑 Login and logout securely
* ✍️ Write and publish your blog posts
* 📚 Browse posts from all users on the homepage

---

## 🗂️ Project Structure

* `entity` – Defines data models (User, Post)
* `repository` – Interfaces for database operations
* `service` – Business logic layer
* `controller` – Handles web requests and routes
* `templates` – Thymeleaf HTML pages for UI
* `application.properties` – Config file for database & app settings

---

## 💡 Future Ideas

* Add password encryption 🔐
* Edit & delete posts ✏️🗑️
* User profile pages 👤
* Pagination for posts 📄
* Improved UI/UX 🎨

---

## 👩‍💻 Author

Akhila 

```
