use studb;
CREATE TABLE users (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL,
                       email VARCHAR(100) UNIQUE,
                       full_name VARCHAR(100),
                       phone_number VARCHAR(20),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       is_active BOOLEAN DEFAULT TRUE,
                       last_login TIMESTAMP NULL
);
show tables;

CREATE TABLE `students` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) NOT NULL,
                            `gender` varchar(10) NOT NULL,
                            `age` int DEFAULT NULL,
                            `class` varchar(50) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

alter table students rename Column `class` to  `stu_class`;

-- 科目表
CREATE TABLE subjects (
                          subject_id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100) NOT NULL
);

-- 成绩表（学生、科目、成绩）
CREATE TABLE scores (
                        score_id INT PRIMARY KEY AUTO_INCREMENT,
                        student_id INT NOT NULL,
                        subject_id INT NOT NULL,
                        score DECIMAL(5,2) NOT NULL,
                        FOREIGN KEY (student_id) REFERENCES students(id),
                        FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);


