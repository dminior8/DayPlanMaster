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
  user_id INT,
  title VARCHAR(60) NOT NULL,
  description VARCHAR(255),
  category VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  due_date DATE,
  priority INT,
  is_complete INT,
  recurrence_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create Recurrence table
CREATE TABLE recurrence (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT,
  frequency VARCHAR(50),
  task_interval INT,
  days VARCHAR(255),
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Subtasks table
CREATE TABLE subtasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT,
  name VARCHAR(255),
  type VARCHAR(50),
  is_complete INT,
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Exercises table
CREATE TABLE exercises (
  id INT PRIMARY KEY AUTO_INCREMENT,
  task_id INT,
  type VARCHAR(50),
  set_count INT,
  reps INT,
  is_complete INT,
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Tasks_Exercises table
CREATE TABLE tasks_exercises (
  task_id INT,
  exercise_id INT,
  FOREIGN KEY (task_id) REFERENCES tasks (id),
  FOREIGN KEY (exercise_id) REFERENCES exercises (id)
);

-- Create Tasks_Subtasks table
CREATE TABLE tasks_subtasks (
  tasks_id INT,
  subtasks_id INT,
  FOREIGN KEY (tasks_id) REFERENCES tasks (id),
  FOREIGN KEY (subtasks_id) REFERENCES subtasks (id)
);

-- Create Notification table
CREATE TABLE notification (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  task_id INT,
  type VARCHAR(255) NOT NULL,
  message VARCHAR(255) NOT NULL,
  received_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (task_id) REFERENCES tasks (id)
);

-- Create Achievement table
CREATE TABLE achievement (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  received_date DATE,
  FOREIGN KEY (user_id) REFERENCES users (id)
);
