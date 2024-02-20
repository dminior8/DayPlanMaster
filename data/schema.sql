-- Create Users table
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Tasks table
CREATE TABLE tasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  title VARCHAR(60) NOT NULL,
  task_description VARCHAR(255),
  category ENUM('WORK', 'EDUCATION', 'TRAINING', 'HOBBY', 'OTHER') DEFAULT 'OTHER',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  due_date DATE,
  is_complete TINYINT DEFAULT 0,
  priority ENUM('HIGH', 'MEDIUM', 'LOW'),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create Recurrence table
CREATE TABLE recurrence (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT NOT NULL,
  frequency ENUM('DAILY', 'WEEKLY', 'MONTHLY'),
  task_interval INT DEFAULT 1,
  days VARCHAR(255),
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Subtasks table
CREATE TABLE subtasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT NOT NULL,
  title VARCHAR(60),
  is_done TINYINT DEFAULT 0,
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Exercises table
CREATE TABLE exercises (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT NOT NULL,
  exercise_category ENUM ('ARMS', 'CHEST', 'BACK', 'LEGS', 'OTHER'),
  set_count INT,
  reps INT,
  is_done TINYINT DEFAULT 0,
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Tasks_Exercises table
CREATE TABLE tasks_exercises (
  task_id INT NOT NULL,
  exercise_id INT NOT NULL,
  FOREIGN KEY (task_id) REFERENCES tasks (id),
  FOREIGN KEY (exercise_id) REFERENCES exercises (id)
);

-- Create Tasks_Subtasks table
CREATE TABLE tasks_subtasks (
  tasks_id INT NOT NULL,
  subtasks_id INT NOT NULL,
  FOREIGN KEY (tasks_id) REFERENCES tasks (id),
  FOREIGN KEY (subtasks_id) REFERENCES subtasks (id)
);

-- Create Notifications table
CREATE TABLE notifications (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  category ENUM('REMINDER', 'ACHIVEMENT', 'ERROR', 'CONFIRMATION', 'OTHER'),
  message VARCHAR(255) NOT NULL,
  received_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create User_Achievements table
CREATE TABLE user_achievements (
  id INT PRIMARY KEY,
  user_id INT NOT NULL,
  current_value INT DEFAULT 0,
  received_date DATE,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create Achievements table
CREATE TABLE achievements (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  achivement_description VARCHAR(255),
  expected_value INT NOT NULL,
  FOREIGN KEY (id) REFERENCES user_achievements(id)
);
