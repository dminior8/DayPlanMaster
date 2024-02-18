-- For the users table
INSERT INTO users (username, email, password) VALUES
('jan_kowalski', 'jan.kowalski@example.com', 'haslo123'),
('anna_nowak', 'anna.nowak@example.com', 'secret456'),
('tomasz_wisniewski', 'tomasz.wisniewski@example.com', 'secure789');

-- For the tasks table
INSERT INTO tasks (user_id, title, description, category, due_date, priority, is_complete, recurrence_id) VALUES
(1, 'Prepare Report', 'Prepare the final report with project results', 'Business', '2024-02-25', 1, 0, null),
(2, 'Grocery Shopping', 'Buy groceries for the entire week', 'Home', '2024-02-20', 2, 0, null),
(3, 'Gym Workout', 'Follow the strength training plan', 'Fitness', null, 3, 0, 1);

-- For the recurrence table
INSERT INTO recurrence (task_id, frequency, task_interval, days) VALUES
(3, 'Weekly', 1, 'Monday, Wednesday, Friday'),
(3, 'Monthly', 1, '1');

-- For the subtasks table
INSERT INTO subtasks (task_id, name, type, is_complete) VALUES
(1, 'Prepare Data', 'Prepare data for the report', 0),
(1, 'Results Analysis', 'Analyze the collected data', 0),
(2, 'Grocery Shopping', 'Grocery shopping for dinner', 0);

-- For the exercises table
INSERT INTO exercises (task_id, type, set_count, reps, is_complete) VALUES
(3, 'Pull-ups', 3, 10, 0),
(3, 'Squats', 4, 15, 0);

-- For the tasks_exercises table
INSERT INTO tasks_exercises (task_id, exercise_id) VALUES
(3, 1),
(3, 2);

-- For the tasks_subtasks table
INSERT INTO tasks_subtasks (tasks_id, subtasks_id) VALUES
(1, 1),
(1, 2),
(2, 3);

-- For the notification table
INSERT INTO notification (user_id, task_id, type, message, received_time) VALUES
(1, 1, 'Reminder', 'Report to be done', '2024-02-24 10:00:00'),
(2, 2, 'Reminder', 'Grocery shopping', '2024-02-19 15:30:00');

-- For the achievement table
INSERT INTO achievement (user_id, name, description, received_date) VALUES
(1, 'Master Productivity', 'Complete all planned tasks', '2024-03-01'),
(2, 'Healthy Living', 'Complete 30 workouts in a month', '2024-03-15');
