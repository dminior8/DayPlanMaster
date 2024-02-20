-- For the users table
INSERT INTO users (username, email, user_password) VALUES
('jan_kowalski', 'jan.kowalski@example.com', 'haslo123'),
('anna_nowak', 'anna.nowak@example.com', 'secret456'),
('tomasz_wisniewski', 'tomasz.wisniewski@example.com', 'secure789');

-- For the tasks table
INSERT INTO tasks (user_id, title, task_description, category, due_date, is_complete, priority) VALUES
(1, 'Prepare Report', 'Prepare the final report with project results', 'WORK', '2024-02-25', 0 , 'HIGH'),
(2, 'Grocery Shopping', 'Buy groceries for the entire week', 'OTHER', '2024-02-20', 0, 'MEDIUM'),
(3, 'Gym Workout', 'Follow the strength training plan', 'TRAINING', null, 0, 'LOW');

-- For the recurrence table
INSERT INTO recurrence (task_id, frequency, task_interval, days) VALUES
(3, 'weekly', 1, 'Monday, Wednesday, Friday'),
(3, 'monthly', 1, '1');

-- For the subtasks table
INSERT INTO subtasks (task_id, title, is_done) VALUES
(1, 'Prepare Data', 0),
(1, 'Results Analysis', 0),
(2, 'Grocery Shopping', 0);

-- For the exercises table
INSERT INTO exercises (task_id, exercise_category, set_count, reps, is_done) VALUES
(3, 'ARMS', 3, 10, 0),
(3, 'LEGS', 4, 15, 0);

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
INSERT INTO notifications (user_id,category, message, received_time) VALUES
(1,'REMINDER', 'Report to be done', '2024-02-24 10:00:00'),
(1,'REMINDER', 'Grocery shopping', '2024-02-19 15:30:00');

-- For the user_achievements table
INSERT INTO user_achievements (id, user_id, current_value, received_date) VALUES
(1, 1, 0, NULL),
(2, 2, 0, NULL);

-- For the achievement table
INSERT INTO achievements (title, achivement_description, expected_value) VALUES
('Master Productivity', 'Complete all planned tasks', 1),
('Healthy Living', 'Complete 30 workouts in a month', 30);