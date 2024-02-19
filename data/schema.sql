-- Create Users table
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Tasks table
CREATE TABLE tasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  title VARCHAR(60) NOT NULL,
  description VARCHAR(255),
  category ENUM('work', 'education', 'training', 'hobby', 'other'),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  due_date DATE,
  priority ENUM('high', 'medium', 'low', 'routine', 'long-term'),
  is_complete TINYINT DEFAULT 0,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create Recurrence table
CREATE TABLE recurrence (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT NOT NULL,
  frequency ENUM('daily', 'weekly', 'monthly'),
  task_interval INT DEFAULT 1,
  days VARCHAR(255),
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Subtasks table
CREATE TABLE subtasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT NOT NULL,
  name VARCHAR(255),
  is_complete TINYINT DEFAULT 0,
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Exercises table
CREATE TABLE exercises (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT NOT NULL,
  type ENUM ('arms', 'chest', 'back', 'legs', 'other'),
  set_count INT DEFAULT 0,
  reps INT DEFAULT 0,
  is_complete TINYINT DEFAULT 0,
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

-- Create Notification table
CREATE TABLE notification (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  type ENUM('reminder', 'achivement', 'error', 'confirmation', 'other'),
  message VARCHAR(255) NOT NULL,
  received_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create Achievement table
CREATE TABLE achievement (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  received_date DATE,
  FOREIGN KEY (user_id) REFERENCES users (id)
);
