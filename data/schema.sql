-- Create Users table
CREATE TABLE Users (
  id INT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT current_timestamp
);

-- Create Tasks table
CREATE TABLE Tasks (
  id INT PRIMARY KEY,
  user_id INT,
  title VARCHAR(60) NOT NULL,
  description VARCHAR(255),
  category VARCHAR(50),
  created_at TIMESTAMP DEFAULT current_timestamp,
  due_date DATE,
  priority INT,
  isComplete INT,
  FOREIGN KEY (user_id) REFERENCES Users (id)
);

-- Create Recurrence table
CREATE TABLE Recurrence (
  id INT PRIMARY KEY,
  task_id INT,
  frequency VARCHAR(50),
  taskInterval INT,
  days VARCHAR(255),
  FOREIGN KEY (task_id) REFERENCES Tasks (id)
);

-- Create Subtasks table
CREATE TABLE Subtasks (
  id INT PRIMARY KEY,
  task_id INT,
  name VARCHAR(255),
  type VARCHAR(50),
  isComplete INT,
  FOREIGN KEY (task_id) REFERENCES Tasks (id)
);

-- Create Exercises table
CREATE TABLE Exercises (
  id INT PRIMARY KEY,
  task_id INT,
  type VARCHAR(50),
  set_count INT,
  reps INT,
  isComplete INT,
  FOREIGN KEY (task_id) REFERENCES Tasks (id)
);

-- Create Tasks_Exercises table
CREATE TABLE Tasks_Exercises (
  task_id INT,
  exercise_id INT,
  FOREIGN KEY (task_id) REFERENCES Tasks (id),
  FOREIGN KEY (exercise_id) REFERENCES Exercises (id)
);

-- Create Tasks_Subtasks table
CREATE TABLE Tasks_Subtasks (
  task_id INT,
  subtask_id INT,
  FOREIGN KEY (task_id) REFERENCES Tasks (id),
  FOREIGN KEY (subtask_id) REFERENCES Subtasks (id)
);

-- Create Notification table
CREATE TABLE Notification (
  id INT PRIMARY KEY,
  user_id INT,
  task_id INT,
  type VARCHAR(255) NOT NULL,
  message VARCHAR(255) NOT NULL,
  received_time TIMESTAMP DEFAULT current_timestamp,
  FOREIGN KEY (user_id) REFERENCES Users (id),
  FOREIGN KEY (task_id) REFERENCES Tasks (id)
);

-- Create Achievement table
CREATE TABLE Achievement (
  id INT PRIMARY KEY,
  user_id INT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  received_date DATE,
  FOREIGN KEY (user_id) REFERENCES Users (id)
);
