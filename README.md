# PopGamers

Hello, this is our ReadMe file for PopGamers

# Which CRUD are we doing?

Game Management - Adrian

User Management - Thoha

To access User Management CRUD functions, load the server and go to:
```bash
http://localhost:8090/PopGamers/GameUserDetails/dashboard
```

Game Discussion Feed - Javier

Game Discussion Page - Shafiq


# Sql table Script for User Management

CREATE TABLE `gameuserdetails` (
 `username` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
 `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
 `password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
 PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

# Sql table Script for Game Management

CREATE TABLE `gamedetails` (
 `gameName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
 `gamePicture` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
 `gameDescription` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
 `genre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
 PRIMARY KEY (`gameName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci


# Sql table Script for Game Discussion Feed


# Sql table Script for Game Discussion Page


# Continuous Integration and Continuous Deployment Settings

apache tomcat server.xml



apache tomcat tomcat_user.xml



